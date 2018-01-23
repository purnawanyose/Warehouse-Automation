package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
import static com.semenindonesia.sisi.warehouseautomation.R.id.tvScan;

public class OnhandLocationActivity extends AppCompatActivity {
    TextView tvScann,et2;
    TextView plant, norsv, order, matno;

    String plantt, norsvv,orderr,matnoo;
    private RecyclerView recyclerView;

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

        /*Create handle for the RetrofitInstance interface*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

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
