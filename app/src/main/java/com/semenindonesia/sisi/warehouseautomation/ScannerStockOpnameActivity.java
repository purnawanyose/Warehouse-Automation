package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import config.ScannerStockOpnameRv;
import config.StockOpnameRv;
import model.OnHand;
import model.Opname;
import response.OnHandResponse;
import response.StockOpnameDetailResponse;
import response.StockOpnameResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class ScannerStockOpnameActivity extends AppCompatActivity {

    private ScannerStockOpnameRv adapter;
    private RecyclerView recyclerView;

    String level, plant, whn, stype, slc,strgbin;

    TextView tvLevel;
    TextView tvPlant;
    TextView sloc;
    TextView whno;
    TextView strgtype;
    TextView strgBin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_stock_opname);

        tvLevel = (TextView) findViewById(R.id.tvLevel);
        tvPlant = (TextView) findViewById(R.id.tvPlant);
        sloc = (TextView) findViewById(R.id.sloc);
        whno = (TextView) findViewById(R.id.whno);
        strgtype = (TextView) findViewById(R.id.strgtype);
        strgBin = (TextView) findViewById(R.id.strgBin);

           /* Bundle extras = getIntent().getExtras();*/
        tvLevel.setText(getIntent().getStringExtra("level"));
        tvPlant.setText(getIntent().getStringExtra("plant"));
        sloc.setText(getIntent().getStringExtra("sloc"));
        strgtype.setText(getIntent().getStringExtra("stype"));
        whno.setText(getIntent().getStringExtra("whs"));
        strgBin.setText(getIntent().getStringExtra("sbin"));


        Bundle extras = getIntent().getExtras();
        level = extras.getString("level");
        plant = extras.getString("plant");
        slc = extras.getString("sloc");
        whn = extras.getString("whs");
        stype = extras.getString("stype");
        strgbin = extras.getString("sbin");

        //====================== Start Retrofit ======================\\

        /*Create handle for the RetrofitInstance interface*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<StockOpnameResponse> call = apiService.getScannerOpnameDetail(plant, slc);
        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<StockOpnameResponse>() {

            @Override
            public void onResponse(Call<StockOpnameResponse> call, Response<StockOpnameResponse> response) {
                generateInterimResponse((ArrayList<Opname>) response.body().getStockopname());
                List<Opname> content = response.body().getStockopname();
                if (content.size() < 1){
                    Toast.makeText(ScannerStockOpnameActivity.this,"Data Not Found!",Toast.LENGTH_LONG).show();
                }
                Log.e("StockOpname", "Sukses");
            }

            @Override
            public void onFailure(Call<StockOpnameResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });

        //====================== End Retrofit ======================\\
    }
    private void generateInterimResponse(ArrayList<Opname> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.opnameRv);

        adapter = new ScannerStockOpnameRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ScannerStockOpnameActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
