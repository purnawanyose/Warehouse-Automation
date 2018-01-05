package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import model.BonSementara;
import model.Opname;
import response.BonSementaraResponse;
import response.StockOpnameResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class StockOpnameActivity extends AppCompatActivity {
    TextView PHYSINVENTORY;
    TextView PLANT;
    TextView STGELOC;
    TextView FISCALYEAR ;
    TextView SPEC_STOCK;
    TableLayout TABLAY;
    TableRow LAYROW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_opname);

//        TABLAY = (TableLayout) findViewById(R.id.tablay);
//        LAYROW = (TableRow) findViewById(R.id.rowlay);
//        PHYSINVENTORY =(TextView) findViewById(R.id.pidx);
//        PLANT = (TextView) findViewById(R.id.plantt);
//        STGELOC = (TextView) findViewById(R.id.slocc);
//        FISCALYEAR  = (TextView) findViewById(R.id.periodd);
//        SPEC_STOCK = (TextView) findViewById(R.id.ss);

        final Context context = this.getApplicationContext();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<StockOpnameResponse> call = apiService.getStockOpname();
        call.enqueue(new Callback<StockOpnameResponse>() {
            @Override
            public void onResponse(Call<StockOpnameResponse> call, Response<StockOpnameResponse> response) {
                List<Opname> content = response.body().getStockopname();
                for (Opname data : content) {


                    PHYSINVENTORY.setText(data.getPHYSINVENTORY());
                    PLANT.setText(data.getPLANT());
                    STGELOC.setText(data.getSTGELOC());
                    FISCALYEAR.setText(data.getFISCALYEAR());
                    SPEC_STOCK.setText(data.getSPECSTOCK());

                    Log.e("content", "Material No " + content.toString());

                }
            }

            @Override
            public void onFailure(Call<StockOpnameResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });



    }
}
