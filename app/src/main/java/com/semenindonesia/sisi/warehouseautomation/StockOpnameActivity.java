package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import config.InterimRv;
import config.StockOpnameRv;
import model.BonSementara;
import model.Interim;
import model.Opname;
import response.BonSementaraResponse;
import response.StockOpnameResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class StockOpnameActivity extends AppCompatActivity {
    TextView PLANT;

    private StockOpnameRv adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_opname);

        final Context context = this.getApplicationContext();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<StockOpnameResponse> call = apiService.getStockOpname();
         /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<StockOpnameResponse>() {
            @Override
            public void onResponse(Call<StockOpnameResponse> call, Response<StockOpnameResponse> response) {
                generateInterimResponse((ArrayList<Opname>) response.body().getStockopname());
                List<Opname> content = response.body().getStockopname();
                if (content.size() < 1){
                    Toast.makeText(StockOpnameActivity.this,"Data Not Found!",Toast.LENGTH_LONG).show();
                }
                Log.e("StockOpname", "Sukses");
            }

            @Override
            public void onFailure(Call<StockOpnameResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });
    }
    private void generateInterimResponse(ArrayList<Opname> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.opnameRv);

        adapter = new StockOpnameRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StockOpnameActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
