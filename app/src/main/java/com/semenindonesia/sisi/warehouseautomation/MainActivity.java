package com.semenindonesia.sisi.warehouseautomation;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.arasthel.asyncjob.AsyncJob;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.List;

import model.BonSementara;
import model.Interim;
import model.Reservation;
import response.BonSementaraResponse;
import response.ClearResponse;
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
    private View stockOpname;

    int d = 0;
    int e = 0;
    TextView Reservation;
    TextView Interim;
    TextView Bon;
    TextView StockOpname;


    public void Reservation(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ClearResponse> call = apiService.getHomeReservation();
        call.enqueue(new Callback<ClearResponse>() {

            @Override
            public void onResponse(Call<ClearResponse> call, Response<ClearResponse> response) {


                Reservation.setText(response.body().getContent());

                /*List<model.Reservation> content = response.body().getReservationMain();
                int i = 0;
                for (Reservation data : content) {
                    d = d + 1;
                    Log.e("sa", "as" + d);

                }
                Reservation.setText("" + d);*/
            }

            @Override
            public void onFailure(Call<ClearResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo" + call);
            }
        });
    }
    public void Bon(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ClearResponse> call = apiService.getHomeBonSementara();
        Log.wtf("URL Called", call.request().url() + "");
        call.enqueue(new Callback<ClearResponse>() {

            @Override
            public void onResponse(Call<ClearResponse> call, Response<ClearResponse> response) {


              /*  List<BonSementara> content = response.body().getBonSementara();
                int i = 0;
                for (BonSementara data : content) {
                    d = d + 1;
                    Log.e("sa", "as" + d);

                }*/
                Bon.setText(response.body().getContent());
            }

            @Override
            public void onFailure(Call<ClearResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo" + call);
            }
        });
    }
    public void Interim(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ClearResponse> call = apiService.getHomeInterim();
        call.enqueue(new Callback<ClearResponse>() {

            @Override
            public void onResponse(Call<ClearResponse> call, Response<ClearResponse> response) {
                /*List<Interim> content = response.body().getInterim();
                int i = 0;
                for (Interim data : content) {
                    e = e + 1;
                    Log.e("sa", "as" + e);

                }*/
                Interim.setText(response.body().getContent());
            }

            @Override
            public void onFailure(Call<ClearResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo" + call);
            }
        });
    }

    public void StockOpname(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ClearResponse> call = apiService.getHomeOpname();
        call.enqueue(new Callback<ClearResponse>() {

            @Override
            public void onResponse(Call<ClearResponse> call, Response<ClearResponse> response) {
                /*List<Interim> content = response.body().getInterim();
                int i = 0;
                for (Interim data : content) {
                    e = e + 1;
                    Log.e("sa", "as" + e);

                }*/
                StockOpname.setText(response.body().getContent());
            }

            @Override
            public void onFailure(Call<ClearResponse> call, Throwable t) {
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
        stockOpname = (View) findViewById(R.id.stockopname);

        Reservation = (TextView) findViewById(R.id.reservation_count);
        Interim = (TextView) findViewById(R.id.interim_count);
        Bon = (TextView) findViewById(R.id.bonsementara_count);
        StockOpname = (TextView) findViewById(R.id.stockopname_count);

        Bon();
        Interim();
        Reservation();
        StockOpname();

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

        stockOpname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StockOpnameActivity.class );
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

//        ForceCloseDebugger.handle(this);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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