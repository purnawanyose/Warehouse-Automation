package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import config.DetailStockOpnameRv;
import config.StockOpnameRv;
import model.HeadDetailOpname;
import model.ItemDetailOpname;
import model.Opname;
import model.Reservation;
import response.DetailResponse;
import response.StockOpnameDetailResponse;
import response.StockOpnameResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class DetailOpActivity extends AppCompatActivity {


    private DetailStockOpnameRv adapter;
    private RecyclerView recyclerView;

    String PID, FYEAR;
    String TAG = DetailOpActivity.class.getSimpleName();
    private ArrayList<ItemDetailOpname> itemlist = new ArrayList<ItemDetailOpname>();


    TextView pid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_op);

        final Context context = this.getApplicationContext();

        pid = (TextView)findViewById(R.id.pid);

        Bundle extras = getIntent().getExtras();
        PID = "1000000040";
        FYEAR = "2015";
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<DetailResponse> call = apiService.getOpnameDetail(PID, FYEAR);
         /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                //generateInterimResponse((ArrayList<ItemDetailOpname>) response.body().getItems());
                /*HeadDetailOpname aa = response.body().getHead();
                Log.e("StockOpname", "Sukses"+aa.getPHYSINVENTORY());
                    pid.setText(aa.getPHYSINVENTORY());*/

                int i = response.body().getStatus();
                List<ItemDetailOpname> items = response.body().getContent().getItems();

                generateInterimResponse((ArrayList<ItemDetailOpname>) response.body().getContent().getItems());

                String user = response.body().getContent().getHead().getUSERNAME();
                Log.e(TAG, "Sukses: user head " + user);


            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });
    }

    private void generateInterimResponse(ArrayList<ItemDetailOpname> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.detailOpnameRv);

        adapter = new DetailStockOpnameRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DetailOpActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
