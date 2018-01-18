package com.semenindonesia.sisi.warehouseautomation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import adapter.Filter_MaterialRv;
import adapter.Main_ReservationRv;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.mrapp.android.dialog.WizardDialog;
import fragment.DatePickerFragment;
import fragment.Filter_Movtype;
import fragment.Filter_material;
import model.Material;
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

    private Main_ReservationRv adapter ;
    private ArrayList<Reservation> rsvlist =  new ArrayList<Reservation>();

    @BindView(R.id.etPlant)
    EditText etPlant;
    Editable teeeet;
    @BindView(R.id.recycler_view_reservation)
    RecyclerView recyclerView;
    ImageView img_search;

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
/*
        img_search = (ImageView) findViewById(R.id.img_search);
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationActivity.this, ReservationDetailActivity.class );
                startActivity(intent);
            }
        });*/
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

    @OnClick(R.id.srcmat)
    public void actionsrcmat() {

        WizardDialog.Builder dialogBuilder = new WizardDialog.Builder(ReservationActivity.this);
        dialogBuilder.addFragment("", Filter_material.class);
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

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ReservationMainResponse> call = apiService.getReservationMain("7702", "W210", "51556926", "1");

        call.enqueue(new Callback<ReservationMainResponse>() {

            @Override
            public void onResponse(Call<ReservationMainResponse> call, retrofit2.Response<ReservationMainResponse> response) {
                List<Reservation> reservation = response.body().getReservationMain();
                rsvlist.clear();
                for (Reservation data : reservation){
                    Reservation rsv = new Reservation(data.getRSNUM(),data.getRSPOS(),data.getRSART(),data.getBDART(),
                            data.getRSSTA(),data.getXLOEK(),data.getXWAOK(),data.getKZEAR(),data.getXFEHL(),data.getMATNR(),
                            data.getMAKTX(),data.getWERKS(),data.getLGORT(),data.getCHARG(),data.getSORTF(),data.getSOBKZ(),
                            data.getBDTER(),data.getBDMNG(),data.getMEINS(),data.getSHKZG(),data.getENMNG(),data.getAUFNR(),
                            data.getBWART(),data.getPSPEL(),data.getZZWBS()
                    );
                rsvlist.add(rsv);
                }

                adapter = new Main_ReservationRv(rsvlist);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ReservationActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                if (rsvlist.size() < 1){
                    Toast.makeText(ReservationActivity.this,"Data Not Found!",Toast.LENGTH_LONG).show();
                }

                }


            @Override
            public void onFailure(Call<ReservationMainResponse> call, Throwable t) {
                Toast.makeText(ReservationActivity.this,"Error retrofit!",Toast.LENGTH_SHORT).show();
                Log.e("Error Retrofit: ", t.toString());
            }

        });
    }

}

