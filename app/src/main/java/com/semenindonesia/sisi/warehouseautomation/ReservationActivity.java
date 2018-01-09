package com.semenindonesia.sisi.warehouseautomation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.mrapp.android.dialog.WizardDialog;
import fragment.DatePickerFragment;
import fragment.Filter_Movtype;
import model.Reservation;
import model.Response;
import response.ReservationMainResponse;
import retrofit2.Call;
import retrofit2.Callback;
import service.ApiClient;
import service.ApiInterface;

//import static com.semenindonesia.sisi.warehouseautomation.R.id.Plant;
import static com.semenindonesia.sisi.warehouseautomation.R.id.checkbox;
import static com.semenindonesia.sisi.warehouseautomation.R.id.etPlant;
import static com.semenindonesia.sisi.warehouseautomation.R.id.plantt;
import static com.semenindonesia.sisi.warehouseautomation.R.id.reservation;

public class ReservationActivity extends AppCompatActivity implements View.OnClickListener {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView tglAwal, tglAkhir;
    private int year, month, day;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @BindView(R.id.etPlant)
    EditText etPlant;
    Editable teeeet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        ButterKnife.bind(this);

        etPlant =(EditText) findViewById(R.id.etPlant);
        teeeet = etPlant.getText();

        tglAwal = (TextView) findViewById(R.id.tglAwal);
        tglAkhir = (TextView) findViewById(R.id.tglAkhir);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();

        setDateTimeField();



    }
    private void findViewsById() {
        tglAwal = (EditText) findViewById(R.id.tglAwal);
        tglAwal.setInputType(InputType.TYPE_NULL);
        tglAwal.requestFocus();

        tglAkhir = (EditText) findViewById(R.id.tglAkhir);
        tglAkhir.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {
        tglAwal.setOnClickListener(this);
        tglAkhir.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tglAwal.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tglAkhir.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == tglAwal) {
            fromDatePickerDialog.show();
        } else if(view == tglAkhir) {
            toDatePickerDialog.show();
        }
    }

    @OnClick(R.id.srcmovtype)
    public void actionsrcmovtype() {

        WizardDialog.Builder dialogBuilder = new WizardDialog.Builder(ReservationActivity.this);
        dialogBuilder.addFragment("", Filter_Movtype.class);
        dialogBuilder.setFinishButtonText("Search items");
        dialogBuilder.setHeaderIcon(R.drawable.ic_search_black_24dp);
        dialogBuilder.showHeader(true);
        dialogBuilder.setFullscreen(false);
        dialogBuilder.setMaxHeight(600);
        dialogBuilder.setCancelable(true);
        dialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
        WizardDialog dialog = dialogBuilder.create();
        dialog.show(getSupportFragmentManager(),"test");

    }

    @OnClick(R.id.btnSearch)
    void actionCari() {
        String bb = "Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?rwerks[1]="+teeeet+"";
        Log.e("aa","as"+bb.toString());

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ReservationMainResponse> call = apiService.getReservationMain(bb);

        call.enqueue(new Callback<ReservationMainResponse>() {

            @Override
            public void onResponse(Call<ReservationMainResponse> call, retrofit2.Response<ReservationMainResponse> response) {
                List<Reservation> reservation = response.body().getReservationMain();
                loadData(reservation);
//
//                for (Reservation data : reservation ) {
//                    Plant.setText(data.getWERKS());
//
//
//                if (Plant == Plant.getText()) {
//                    Log.e("reservation", "Material No " + call.toString());
//                }else{
//                    Log.e("asjsa","asj");
//                }

                }


            @Override
            public void onFailure(Call<ReservationMainResponse> call, Throwable t) {

            }

        });
    }

    private void loadData(List<Reservation> reservation) {
        for (Reservation data : reservation) {
            etPlant.setText(data.getMAKTX());
        }
    }
}

