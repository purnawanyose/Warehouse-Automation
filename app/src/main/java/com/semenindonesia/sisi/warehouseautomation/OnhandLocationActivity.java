package com.semenindonesia.sisi.warehouseautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.arasthel.asyncjob.AsyncJob;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;

import config.OnHandLocationRv;
import config.ReservationDetailRv;
import model.Interim;
import model.OnHandLocation;
import model.Plant;
import model.Reservation;
import response.InterimResponse;
import response.OnHandLocationResponse;
import response.ReservationDetailResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiClientLocal;
import service.ApiInterface;

import static com.semenindonesia.sisi.warehouseautomation.R.drawable.rsv;
import static com.semenindonesia.sisi.warehouseautomation.R.id.plantText;
import static com.semenindonesia.sisi.warehouseautomation.R.id.tvScan;
import static com.semenindonesia.sisi.warehouseautomation.R.id.visible;

public class OnhandLocationActivity extends AppCompatActivity {
    TextView tvScann,et2;
    TextView plant, norsv, order, matno;

    String norsvv,orderr, werkss, rsposs;

    public static String plantt;
    public static String matnoo;
    public static String rsvnoo;
    public static String matnrr;
    public static String lgortt;
    public static String ordr;

    private RecyclerView recyclerView;
    public static String scan = "dfsgfsdgs";
    public  Button btnAction;
    public static String  matnooo,ambilTampung;
    public static List<String>list;
    public static List<String>qtybro;
    public  static  int qtybroo[];
    public  static  int nilaiAkhir = 0;
    public static String specialStock[];
    public static String wbs_elem[];
    public static String val_type[];
    private OnHandLocationRv adapter;
    String ss, wbs, val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onhand_location);

        recyclerView = (RecyclerView) findViewById(R.id.rv_onhand_location);
        plant = (TextView) findViewById(R.id.noreservation);
        norsv = (TextView) findViewById(R.id.reservationno);
        order = (TextView) findViewById(R.id.order);
        matno = (TextView) findViewById(R.id.material);
        tvScann = (TextView) findViewById(R.id.tvScann);
        et2 = (TextView) findViewById(R.id.et2);
        btnAction = (Button) findViewById(R.id.btnAction);

        list = new ArrayList<String>();

        /* Bundle extras = getIntent().getExtras();*/
        plant.setText("Plant \t\t\t\t\t\t : "+getIntent().getStringExtra("PLANT"));
        norsv.setText("Reservation No. \t : "+getIntent().getStringExtra("RSVNO"));
        order.setText("Order \t\t\t\t\t\t : "+getIntent().getStringExtra("ORDER"));
        matno.setText("Material \t\t\t\t : "+getIntent().getStringExtra("MATNR"));

        Bundle extras = getIntent().getExtras();
        plantt = extras.getString("PLANT");
        matnoo = extras.getString("MATNO");
        rsvnoo = extras.getString("RSVNO");
        ordr = extras.getString("ORDER");
        matnrr = extras.getString("MATNR");
        werkss = extras.getString("WERKS");
        lgortt = extras.getString("LGORT");
        rsposs= extras.getString("RSPOS");

        matnooo = extras.getString("MATNO");


        final KProgressHUD khud = KProgressHUD.create(OnhandLocationActivity.this)
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
                    retrofit();
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

        tvScann.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    tvScann.setVisibility(View.GONE);
                    btnAction.setVisibility(View.VISIBLE);
                    btnAction.setEnabled(false);
                    if (qtybroo != null) {
                        btnAction.setEnabled(true);
                    }
                    // Perform action on key press
                    String scanner = tvScann.getText().toString();
                    String[] scann = scanner.split("#");
                    Log.e("Hasil", "Scan" + scanner.toString());
                    String s = scann[5];
                    scan = s;
                    Log.e("aa", "onKey: " + scan.toString());
                    retrofit();
                }else{

                }
                return false;
            }
        });



            btnAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    retrofitLokal();
                    Intent intent = new Intent(OnhandLocationActivity.this, ReservationDetailActivity.class);
                    intent.putExtra("WERKS",plantt);
                    intent.putExtra("matno",matnooo);
                    intent.putExtra("RSNUM",rsvnoo);
                    intent.putExtra("WERKS",ordr);
                    intent.putExtra("matnr",matnrr);
                    intent.putExtra("TAMPUNG",ambilTampung);

                    startActivity(intent);
                    finish();
                }
            });
    }
    private void retrofit(){
        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<OnHandLocationResponse> call = apiService.getOnhandLocation(plantt,matnoo);

        Log.e("PLANT TEST NILAI", "retrofit: "+plantt);
        Log.e("MATNO TEST NILAI", "retrofit: "+matnoo);

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<OnHandLocationResponse>() {

            @Override
            public void onResponse(Call<OnHandLocationResponse> call, Response<OnHandLocationResponse> response) {
                generateReservationDetailResponse((ArrayList<OnHandLocation>) response.body().getOnHandLocation());
                List<OnHandLocation> content = response.body().getOnHandLocation();
            }

            @Override
            public void onFailure(Call<OnHandLocationResponse> call, Throwable t) {
                Toast.makeText(OnhandLocationActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                Log.e("Test", "onFailure: "+Call.class );
            }
        });
    }

    private void retrofitLokal(){
        /*Create handle for the RetrofitInstance interface*/
        final ApiInterface apiService = ApiClientLocal.getClient().create(ApiInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        for (int i = 0; i <specialStock.length ; i++) {
            if (qtybroo[i] > 0 && String.valueOf(qtybroo[i]) != null ){
                Call<ReservationDetailResponse> call = apiService.getApiLocal(LoginActivity.pr_uname,plantt,werkss,
                        String.valueOf(qtybroo[i]),rsvnoo,rsposs,lgortt,val_type[i],specialStock[i],wbs_elem[i]);

                /*Log the URL called*/
                Log.wtf("URL Called", call.request().url() + "");

                call.enqueue(new Callback<ReservationDetailResponse>() {

                    @Override
                    public void onResponse(Call<ReservationDetailResponse> call, Response<ReservationDetailResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<ReservationDetailResponse> call, Throwable t) {
                        Toast.makeText(OnhandLocationActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                        Log.e("Test", "onFailure: "+Call.class );
                    }
                });
            }else{

            }
        }
    }

    private void generateReservationDetailResponse(ArrayList<OnHandLocation> empDataList) {

        adapter = new OnHandLocationRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OnhandLocationActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        qtybroo = new int[empDataList.size()];
        specialStock = new String[empDataList.size()];
        wbs_elem = new String[empDataList.size()];
        val_type = new String[empDataList.size()];
    }
}