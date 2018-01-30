package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
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
import service.ApiInterface;

import static com.semenindonesia.sisi.warehouseautomation.R.drawable.rsv;
import static com.semenindonesia.sisi.warehouseautomation.R.id.plantText;
import static com.semenindonesia.sisi.warehouseautomation.R.id.tvScan;

public class OnhandLocationActivity extends AppCompatActivity {
    TextView tvScann,et2;
    TextView plant, norsv, order, matno;

    public static String scan = "";

    String plantt, norsvv,orderr,matnoo;
    private RecyclerView recyclerView;
<<<<<<< HEAD
=======
    public static String scan = "dfsgfsdgs";
    public static Button btnAction;
    public static String qtybro, matnooo,ambilTampung;
>>>>>>> 62ff7254fa9a1a0a80500f4568a641c38e2c63d8

    private OnHandLocationRv adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onhand_location);

        plant = (TextView) findViewById(R.id.noreservation);
        norsv = (TextView) findViewById(R.id.reservationno);
        order = (TextView) findViewById(R.id.order);
        matno = (TextView) findViewById(R.id.material);
        tvScann = (TextView) findViewById(R.id.tvScann);
        et2 = (TextView) findViewById(R.id.et2);

          /* Bundle extras = getIntent().getExtras();*/
        plant.setText("Plant \t\t\t\t\t\t : "+getIntent().getStringExtra("PLANT"));
        norsv.setText("Reservation No. \t : "+getIntent().getStringExtra("RSVNO"));
        order.setText("Order \t\t\t\t\t\t : "+getIntent().getStringExtra("ORDER"));
        matno.setText("Material \t\t\t\t : "+getIntent().getStringExtra("MATNR"));

        Bundle extras = getIntent().getExtras();
        plantt = extras.getString("PLANT");
        matnoo = extras.getString("MATNO");
<<<<<<< HEAD

=======
        rsvnoo = extras.getString("RSVNO");
        ordr = extras.getString("ORDER");
        matnrr = extras.getString("MATNR");
        matnooo = extras.getString("MATNO");
        ambilTampung = extras.getString("TAMPUNG");
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
                    btnAction.setEnabled(true);
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
                Log.e("MASRAMZI", "onClick: "+qtybro );
                Intent intent = new Intent(OnhandLocationActivity.this, ReservationDetailActivity.class);
                intent.putExtra("WERKS",plantt);
                intent.putExtra("matno",matnooo);
                intent.putExtra("RSNUM",rsvnoo);
                intent.putExtra("WERKS",ordr);
                intent.putExtra("matnr",matnrr);
                intent.putExtra("QTY",qtybro);
                intent.putExtra("TAMPUNG",ambilTampung);

                startActivity(intent);
            }
        });

    }
    private void retrofit(){
>>>>>>> 62ff7254fa9a1a0a80500f4568a641c38e2c63d8
        /*Create handle for the RetrofitInstance interface*/
        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<OnHandLocationResponse> call = apiService.getOnhandLocation("7702","623-000005");

        /*Log the URL called*/
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
<<<<<<< HEAD
=======
    }
>>>>>>> 62ff7254fa9a1a0a80500f4568a641c38e2c63d8

        tvScann.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                scan = tvScann.getText().toString();
                return false;
            }
        });


    }
    private void generateReservationDetailResponse(ArrayList<OnHandLocation> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.rv_onhand_location);

        adapter = new OnHandLocationRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OnhandLocationActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

}
