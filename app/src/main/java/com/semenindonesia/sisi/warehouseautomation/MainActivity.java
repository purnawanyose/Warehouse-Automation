package com.semenindonesia.sisi.warehouseautomation;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.arasthel.asyncjob.AsyncJob;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.List;

import model.BonSementara;
import model.Interim;
import model.Reservation;
import response.BonSementaraResponse;
import response.InterimResponse;
import response.ReservationMainResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

import static com.semenindonesia.sisi.warehouseautomation.R.id.layInterim;
import static com.semenindonesia.sisi.warehouseautomation.R.id.qty;
import static com.semenindonesia.sisi.warehouseautomation.R.id.reservation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = InterimActivity.class.getSimpleName();
    private Button button;
    private View layInterim;
    private View layReservation;
    private View layBon;

    int d = 0;
    int e = 0;
    TextView Reservation;
    TextView Interim;
    TextView Bon;


    public void Reservation(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ReservationMainResponse> call = apiService.getHomeReservation();
        call.enqueue(new Callback<ReservationMainResponse>() {

            @Override
            public void onResponse(Call<ReservationMainResponse> call, Response<ReservationMainResponse> response) {
                List<model.Reservation> content = response.body().getReservationMain();
                int i = 0;
                for (Reservation data : content) {
                    d = d + 1;
                    Log.e("sa", "as" + d);

                }
                Reservation.setText("" + d);
            }

            @Override
            public void onFailure(Call<ReservationMainResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo" + call);
            }
        });
    }
    public void Bon(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<BonSementaraResponse> call = apiService.getBonSementara();
        call.enqueue(new Callback<BonSementaraResponse>() {

            @Override
            public void onResponse(Call<BonSementaraResponse> call, Response<BonSementaraResponse> response) {
                List<BonSementara> content = response.body().getBonSementara();
                int i = 0;
                for (BonSementara data : content) {
                    d = d + 1;
                    Log.e("sa", "as" + d);

                }
                Bon.setText("" + d);
            }

            @Override
            public void onFailure(Call<BonSementaraResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo" + call);
            }
        });
    }
    public void Interim(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<InterimResponse> call = apiService.getInterim();
        call.enqueue(new Callback<InterimResponse>() {

            @Override
            public void onResponse(Call<InterimResponse> call, Response<InterimResponse> response) {
                List<Interim> content = response.body().getInterim();
                int i = 0;
                for (Interim data : content) {
                    e = e + 1;
                    Log.e("sa", "as" + e);

                }
                Interim.setText("" + e);
            }

            @Override
            public void onFailure(Call<InterimResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo" + call);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.button);
        layInterim = (View) findViewById(R.id.layInterim);
        layReservation = (View) findViewById(R.id.layReservation);
        layBon = (View) findViewById(R.id.layBon);

        Reservation = (TextView) findViewById(R.id.reservation_count);
        Interim = (TextView) findViewById(R.id.interim_count);
        Bon = (TextView) findViewById(R.id.bonsementara_count);

        Bon();
        Interim();

        final KProgressHUD khud = KProgressHUD.create(MainActivity.this)
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

//BUTTON ON CLICK -BEGIN-

        layInterim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InterimActivity.class );
                startActivity(intent);
            }
        });

        layReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservationActivity.class );
                startActivity(intent);
            }
        });

        layBon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BonSementaraActivity.class );
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScannerActivity.class );
                startActivity(intent);
            }
        });
    }
}