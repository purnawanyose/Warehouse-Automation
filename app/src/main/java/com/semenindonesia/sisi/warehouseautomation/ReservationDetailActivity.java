package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

import com.arasthel.asyncjob.AsyncJob;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;

import config.InterimRv;
import config.ReservationDetailRv;
import model.Interim;
import model.Reservation;
import response.ReservationDetailResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class ReservationDetailActivity extends AppCompatActivity {

    TextView WERKS;
    TextView rsv,order,textView68,textView66;

    String rNumber, rwerks,rlgort;
    private ReservationDetailRv adapter;
    private RecyclerView recyclerView;
    public static String chart ="1";
    public static String akhirTampung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_detail);
        WERKS =(TextView) findViewById(R.id.noreservation);
        rsv =(TextView) findViewById(R.id.rsv);
        order =(TextView) findViewById(R.id.order);
        textView68 = (TextView) findViewById(R.id.textView68);
        textView66 = (TextView) findViewById(R.id.textView66);

        final KProgressHUD khud = KProgressHUD.create(ReservationDetailActivity.this)
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

        if (OnhandLocationActivity.matnooo != null ){
            textView66.setText(chart);
        }else{

        }


        final Context context = this.getApplicationContext();

        Bundle extras = getIntent().getExtras();
        rNumber = extras.getString("RSNUM");
        rwerks = extras.getString("WERKS");
        rlgort = extras.getString("LGORT");
        akhirTampung = extras.getString("TAMPUNG");

                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ReservationDetailResponse> call = apiService.getReservation(rwerks,rNumber,"1");
        call.enqueue(new Callback<ReservationDetailResponse>() {
            @Override
            public void onResponse(Call<ReservationDetailResponse> call, Response<ReservationDetailResponse> response) {
                generateReservationDetailResponse((ArrayList<Reservation>) response.body().getReservation());
                List<Reservation> content = response.body().getReservation();
                for (Reservation data : content) {
                    Log.e("content", "Material No " + content.toString());
                    WERKS.setText("Plant \t\t\t\t\t\t : "+data.getWERKS());
                    rsv.setText("Reservation No. \t : "+data.getRSNUM());
                    order.setText("Order \t\t\t\t\t\t : "+data.getAUFNR());
//                    textView68.setText(data.getMAKTX());
                }
            }

            @Override
            public void onFailure(Call<ReservationDetailResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Reservation", "Material Noooooooooooo"+ call);

            }
        });
    }
    private void generateReservationDetailResponse(ArrayList<Reservation> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_reservation_detail);

        adapter = new ReservationDetailRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ReservationDetailActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            Intent a = new Intent(this,ReservationActivity.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(a);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
