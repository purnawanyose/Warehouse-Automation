package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import model.Reservation;
import response.ScannerReservationDetailResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class ScannerReservationDetail extends AppCompatActivity {

    TextView WERKS;
    TextView MAKTX;
    TableLayout TABLAY;
    TableRow TABROW;
    TextView RSNUM;
    TextView BDTER;

    String rNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_reservation_detail);

        WERKS =(TextView) findViewById(R.id.noreservation);
//        TABLAY = (TableLayout) findViewById(R.id.tablay);
        TABROW = (TableRow) findViewById(R.id.rowlay);
        RSNUM =(TextView) findViewById(R.id.reservno);
        MAKTX =(TextView) findViewById(R.id.md);

        final Context context = this.getApplicationContext();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ScannerReservationDetailResponse> call = apiService.getScannerReservationDetail();
        call.enqueue(new Callback<ScannerReservationDetailResponse>() {
            @Override
            public void onResponse(Call<ScannerReservationDetailResponse> call, Response<ScannerReservationDetailResponse> response) {
                List<Reservation> content = response.body().getScannerReservationDetail();
                for (Reservation data : content) {

                    WERKS.setText(":  "+data.getWERKS());
                    RSNUM.setText(":  "+data.getRSNUM());
                    MAKTX.setText(data.getMAKTX() + "\n"+data.getMATNR() + "\n"+data.getMATNR() );

                }
            }

            @Override
            public void onFailure(Call<ScannerReservationDetailResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });




    }


}
