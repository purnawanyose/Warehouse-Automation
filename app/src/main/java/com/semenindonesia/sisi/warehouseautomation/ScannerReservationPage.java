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
import response.ScannerReservationPageResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class ScannerReservationPage extends AppCompatActivity {

    TextView WERKS;
    TextView STGE_LOC;
    TableLayout TABLAY;
    TableRow TABROW;
    TextView RSNUM;
    TextView BDTER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_reservation_page);

        WERKS =(TextView) findViewById(R.id.noreservation);
        STGE_LOC = (TextView) findViewById(R.id.sloc);
//        TABLAY = (TableLayout) findViewById(R.id.tablay);
        TABROW = (TableRow) findViewById(R.id.rowlay);
        RSNUM =(TextView) findViewById(R.id.reservno);
        BDTER =(TextView) findViewById(R.id.reqdate);
        final Context context = this.getApplicationContext();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ScannerReservationPageResponse> call = apiService.getScannerReservationPage();
        call.enqueue(new Callback<ScannerReservationPageResponse>() {
            @Override
            public void onResponse(Call<ScannerReservationPageResponse> call, Response<ScannerReservationPageResponse> response) {
                List<Reservation> content = response.body().getScannerReservationPage();
                for (Reservation data : content) {

                    WERKS.setText(data.getWERKS());
                    STGE_LOC.setText(data.getSHKZG()); // Masih salah get
                    RSNUM.setText(data.getRSNUM());
                    BDTER.setText(data.getBDTER());




                }
            }

            @Override
            public void onFailure(Call<ScannerReservationPageResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });




    }


}
