package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import config.InterimRv;
import config.OnHandRv;
import model.Interim;
import model.OnHand;
import model.Quant;
import response.InterimResponse;
import response.OnHandResponse;
import response.QuantResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;


public class ScannerOnhandPageActivity extends AppCompatActivity {

    TextView tvLevel;
    TextView tvPlant;
    TextView sloc;
    TextView whno;
    TextView strgtype;
    TextView strgBin;

    private OnHandRv adapter;
    private RecyclerView recyclerView;
    String level, plant, whn, stype, slc,strgbin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_onhand_page);


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



        final Context context = this.getApplicationContext();

         /*Create handle for the RetrofitInstance interface*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<OnHandResponse> call = apiService.getOnHand(level,whn,stype,strgbin);
//        Log.e("AZMI","BURHAN",+Call.class);

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<OnHandResponse>() {

            @Override
            public void onResponse(Call<OnHandResponse> call, Response<OnHandResponse> response) {
                generateOnhandResponse((ArrayList<OnHand>) response.body().getOnHand());
                List<OnHand> content = response.body().getOnHand();
                Log.e("aa","aaas"+content.toString());
            }

            @Override
            public void onFailure(Call<OnHandResponse> call, Throwable t) {
                Toast.makeText(ScannerOnhandPageActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void generateOnhandResponse(ArrayList<OnHand> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_onhand);

        adapter = new OnHandRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ScannerOnhandPageActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
