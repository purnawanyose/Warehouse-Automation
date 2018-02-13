package com.semenindonesia.sisi.warehouseautomation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.arasthel.asyncjob.AsyncJob;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import adapter.Filter_MaterialRv;
import adapter.Filter_MovtypeRv;
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
import static com.semenindonesia.sisi.warehouseautomation.R.id.cbMvtInd;
import static com.semenindonesia.sisi.warehouseautomation.R.id.checkbox;
import static com.semenindonesia.sisi.warehouseautomation.R.id.etPlant;
import static com.semenindonesia.sisi.warehouseautomation.R.id.plantt;
import static com.semenindonesia.sisi.warehouseautomation.R.id.reservation;

public class ReservationActivity extends AppCompatActivity implements View.OnClickListener {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView tglAwal, tglAkhir;
    private int year, month, day;
    private EditText movtype, mattype, etNoReservation;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter,dateFormatterr;

    private Main_ReservationRv adapter ;
    private ArrayList<Reservation> rsvlist =  new ArrayList<Reservation>();

    Call<ReservationMainResponse> call;

    @BindView(R.id.etPlant)
    EditText etPlant;
    Editable teeeet;
    @BindView(R.id.recycler_view_reservation)
    RecyclerView recyclerView;
    ImageView img_search;
    CheckBox mvt, finalz, delete;
    String mvtS, finalzS, deleteS;
    String date1,date2;
    Date dateObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        ButterKnife.bind(this);

        etPlant =(EditText) findViewById(R.id.etPlant);
        etNoReservation =(EditText) findViewById(R.id.etNoReservation);

        tglAwal = (TextView) findViewById(R.id.tglAwal);
        tglAkhir = (TextView) findViewById(R.id.tglAkhir);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateFormatterr = new SimpleDateFormat("yyyyMMdd", Locale.US);

        movtype = (EditText) findViewById(R.id.movtype);
        mattype = (EditText) findViewById(R.id.materialno);

        findViewsById();
        setDateTimeField();

        mvt = (CheckBox) findViewById(cbMvtInd);
        finalz = (CheckBox) findViewById(cbMvtInd);
        delete = (CheckBox) findViewById(cbMvtInd);

        if (mvt.isChecked()){
            mvtS = "X";
            finalzS ="";
            deleteS ="";
            finalz.setChecked(false);
            delete.setChecked(false);
        }else if (finalz.isChecked()){
            finalzS = "X";
            mvtS ="";
            deleteS ="";
            mvt.setChecked(false);
            delete.setChecked(false);
        }else if (delete.isChecked()){
            deleteS = "X";
            mvtS = "";
            finalzS="";
            mvt.setChecked(false);
            finalz.setChecked(false);
        }else {

        }

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

                try {
                    String aa = tglAwal.getText().toString();
                    dateObject = dateFormatter.parse(aa);
                    date1 = new SimpleDateFormat("yyyyMMdd", Locale.US).format(dateObject);
                } catch (ParseException e) {e.printStackTrace();

                }

            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tglAkhir.setText(dateFormatter.format(newDate.getTime()));
                try {
                    String bb = tglAkhir.getText().toString();
                    dateObject = dateFormatter.parse(bb);
                    date2 = new SimpleDateFormat("yyyyMMdd", Locale.US).format(dateObject);
                } catch (ParseException e) {e.printStackTrace();

                }

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
                String checked = Filter_MovtypeRv.selected;
                movtype.setText(checked);
                Log.e("checked"," "+checked);
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
                String checked = Filter_MaterialRv.selected;
                mattype.setText(checked);
                Log.e("checked"," "+checked);
            }
        });
        WizardDialog dialog = dialogBuilder.create();
        dialog.show(getSupportFragmentManager(),"test");

    }

    @OnClick(R.id.btnSearch)

    void actionCari() {
        final KProgressHUD khud = KProgressHUD.create(ReservationActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("Retrieve Data")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();

        AsyncJob.doInBackground(new AsyncJob.OnBackgroundJob() {
            @Override
            public void doOnBackground() {

                // Pretend it's doing some background processing
                try {
                    Thread.sleep(6000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Create a fake result (MUST be final)
                final boolean result = true;

                // Send the result to the UI thread and show it on a Toast
                AsyncJob.doOnMainThread(new AsyncJob.OnMainThreadJob() {
                    @Override
                    public void doInUIThread() {
                        khud.dismiss();
                    }
                });
            }
        });
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);



        Call<ReservationMainResponse> call = apiService.getReservationMain(etNoReservation.getText().toString(),etPlant.getText().toString()
                , movtype.getText().toString(), mattype.getText().toString(), mvtS,finalzS,deleteS,date1,date2);
        Log.wtf("URL Called", call.request().url() + "");

        if (etNoReservation.getText().toString().equalsIgnoreCase("")){
            call = apiService.getReservationMain(etNoReservation.getText().toString(),etPlant.getText().toString()
                    , movtype.getText().toString(), mattype.getText().toString(), mvtS,finalzS,deleteS,date1,date2);
            Log.wtf("URL Called", call.request().url() + "");
        }else {
            call = apiService.getReservationMainRsv(etNoReservation.getText().toString(),etPlant.getText().toString()
                    , movtype.getText().toString(), mattype.getText().toString(), mvtS,finalzS,deleteS,date1,date2);
            Log.wtf("URL Called", call.request().url() + "");
        }
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
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(ReservationActivity.this);
            builder.setMessage("Apakah Anda Yakin Akan Keluar?");
            builder.setCancelable(true);
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed(){

    }
}

