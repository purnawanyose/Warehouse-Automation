package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
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

public class ReservationActivity extends AppCompatActivity {


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

