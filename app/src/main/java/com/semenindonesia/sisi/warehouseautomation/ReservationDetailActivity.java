package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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

import adapter.Filter_MaterialRv;
import butterknife.OnClick;
import config.InterimRv;
import config.Keranjang;
import config.ReservationDetailRv;
import de.mrapp.android.dialog.WizardDialog;
import fragment.Filter_Movtype;
import fragment.Filter_material;
import fragment.GoodIssued;
import model.Cart;
import model.Interim;
import model.OnHandLocation;
import model.Reservation;
import response.CallCartResponse;
import response.InterimResponse;
import response.OnHandLocationResponse;
import response.ReservationDetailResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiClientLocal;
import service.ApiInterface;

public class ReservationDetailActivity extends AppCompatActivity {

    TextView WERKS;
    TextView rsv,order,textView68,textView66;

    String rNumber, rwerks,rlgort;
    private ReservationDetailRv adapter;
    private RecyclerView recyclerView;
    int chart = 0;
    public static String akhirTampung, tampung1;
    public static int[] akhirNilaii;
    public static int akhirNilaiii;
    String WERKSS,RSVNO, BWART, LGORT;
    public static String RSPOS;
    public static String specialStock;
    public static String wbs_elem;
    public static String val_type;
    public static int cart[];
    public static int cartt;
    int chartNilai;

    Button btnGoodIssued;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_detail);
        WERKS =(TextView) findViewById(R.id.noreservation);
        rsv =(TextView) findViewById(R.id.rsv);
        order =(TextView) findViewById(R.id.order);
        textView68 = (TextView) findViewById(R.id.textView68);
        textView66 = (TextView) findViewById(R.id.textView66);

        btnGoodIssued = (Button) findViewById(R.id.btnGoodIssued);

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

        final Context context = this.getApplicationContext();

        Bundle extras = getIntent().getExtras();
        rNumber = extras.getString("RSNUM");
        rwerks = extras.getString("WERKS");
        rlgort = extras.getString("LGORT");
        akhirTampung = extras.getString("TAMPUNG");
        tampung1 = extras.getString("QTY");
        wbs_elem = extras.getString("WBS");
        val_type = extras.getString("VAL");
        specialStock = extras.getString("SS");



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

                    WERKSS = data.getWERKS();
                    RSVNO = data.getRSNUM();
                    BWART = data.getBWART();
                    LGORT = data.getLGORT();
                }

                Log.e("CART LENGTH","onCreate: "+cart.length );

                for (int i = 0; i <cart.length ; i++) {

                     chartNilai = cart[i];
                    Log.e("Test Cart "+i, "onCreate: "+chartNilai);

                    chart = chart + chartNilai;
//                    Log.e("TESTISTESTIS", "onCreate: "+chart);
                }
//                textView66.setText(chartNilai);
            }

            @Override
            public void onFailure(Call<ReservationDetailResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Reservation", "Material Noooooooooooo"+ call);

            }
        });

        btnGoodIssued.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PostIssuedActivity.class);

                intent.putExtra("PLANT", WERKSS);
                intent.putExtra("RSVNO", RSVNO);
                intent.putExtra("BWART", BWART);
                intent.putExtra("LGORT", LGORT);
                intent.putExtra("RSPOS", RSPOS);
                intent.putExtra("WBS", wbs_elem);
                intent.putExtra("SS", specialStock);
                intent.putExtra("VAL", val_type);


//                intent.putExtra("ORDER", order.getText().toString());
                intent.putExtra("NILAIAKHIR", ReservationDetailRv.akhirNilai);
                Log.e("Test BTN ISSUED", "onClick: "+ReservationDetailRv.akhirNilai);
                Log.e("Test RSPOS", "onClick: "+RSPOS);
                Log.e("Test RSPOS", "onClick: "+wbs_elem);
                Log.e("Test RSPOS", "onClick: "+specialStock);
                Log.e("Test RSPOS", "onClick: "+val_type);
                startActivity(intent);


            }
        });

        Log.e("TESTSTTSTSTSTTST","onCreate: "+"aaaaaaaaaaaa");
    }
    // END ON CREATE



    private void generateReservationDetailResponse(ArrayList<Reservation> empDataList) {
        cart = new int[empDataList.size()];
        Log.e("EMP DATALIST","onCreate: "+cart.length);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_reservation_detail);

        adapter = new ReservationDetailRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ReservationDetailActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);



    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(ReservationDetailActivity.this);
            builder.setMessage("Apakah Anda Yakin Akan Keluar?");
            builder.setCancelable(true);
            builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {

                   /*Create handle for the RetrofitInstance interface*/
                    final ApiInterface apiService = ApiClientLocal.getClient().create(ApiInterface.class);

                    /*Call the method with parameter in the interface to get the employee data*/
                    Call<CallCartResponse> call = apiService.getDelete(RSVNO);

                    /*Log the URL called*/
                    Log.wtf("URL Called", call.request().url() + "");

                    call.enqueue(new Callback<CallCartResponse>() {
                        @Override
                        public void onResponse(Call<CallCartResponse> call, Response<CallCartResponse> response) {
                            Toast.makeText(ReservationDetailActivity.this, "Berhasil Delete", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<CallCartResponse> call, Throwable t) {
                            Toast.makeText(ReservationDetailActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                            Log.e("Test", "onFailure: "+Call.class );
                            finish();
                        }
                    });
                }
            });
            builder.setPositiveButton("Close", new DialogInterface.OnClickListener(){

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

}
