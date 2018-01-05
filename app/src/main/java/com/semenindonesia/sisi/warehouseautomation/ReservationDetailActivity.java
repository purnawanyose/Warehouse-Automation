package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.List;
import model.Reservation;
import response.ReservationDetailResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class ReservationDetailActivity extends AppCompatActivity {

    TextView WERKS;
    TextView AUFNR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_detail);
        WERKS =(TextView) findViewById(R.id.noreservation);

        final Context context = this.getApplicationContext();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ReservationDetailResponse> call = apiService.getReservation();
        call.enqueue(new Callback<ReservationDetailResponse>() {
            @Override
            public void onResponse(Call<ReservationDetailResponse> call, Response<ReservationDetailResponse> response) {
                List<Reservation> content = response.body().getReservation();
                for (Reservation data : content) {
                    Log.e("content", "Material No " + content.toString());
//

                    WERKS.setText("Plant \t\t\t\t\t\t\t\t\t\t : "+data.getWERKS());
                }
            }

            @Override
            public void onFailure(Call<ReservationDetailResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Reservation", "Material Noooooooooooo"+ call);

            }
        });
    }
}
