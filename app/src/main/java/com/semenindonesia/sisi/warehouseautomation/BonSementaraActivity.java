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

import config.BonSementaraRv;
import config.InterimRv;
import model.BonSementara;
import model.Interim;
import response.BonSementaraResponse;
import response.InterimResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

import static android.R.id.list;
import static com.semenindonesia.sisi.warehouseautomation.R.id.cb1;

public class BonSementaraActivity extends AppCompatActivity {
    private BonSementaraRv adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_sementara);

        /*Create handle for the RetrofitInstance interface*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<BonSementaraResponse> call = apiService.getBonSementara();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<BonSementaraResponse>() {

            @Override
            public void onResponse(Call<BonSementaraResponse> call, Response<BonSementaraResponse> response) {
                generateBonresponse((ArrayList<BonSementara>) response.body().getBonSementara());
                List<BonSementara> content = response.body().getBonSementara();
            }

            @Override
            public void onFailure(Call<BonSementaraResponse> call, Throwable t) {
                Toast.makeText(BonSementaraActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
   /* link();*/

    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateBonresponse(ArrayList<BonSementara> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_bon);

        adapter = new BonSementaraRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BonSementaraActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }



    /*TextView RSNUM;
    TextView MAKTX;
    TextView WERKS;
    TextView BDMNG;
    TextView MEINS;
    TableLayout TABLAY;
    TableRow LAYROW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_sementara);


        TABLAY = (TableLayout) findViewById(R.id.tablay);
        LAYROW = (TableRow) findViewById(R.id.rowlay);
        RSNUM =(TextView) findViewById(R.id.reservation);
        MAKTX =(TextView) findViewById(R.id.material);
        WERKS =(TextView) findViewById(R.id.noreservation);
        BDMNG =(TextView) findViewById(R.id.qty);
        MEINS =(TextView) findViewById(R.id.uom);



        final Context context = this.getApplicationContext();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<BonSementaraResponse> call = apiService.getBonSementara();
        call.enqueue(new Callback<BonSementaraResponse>() {
            @Override
            public void onResponse(Call<BonSementaraResponse> call, Response<BonSementaraResponse> response) {
                List<BonSementara> content = response.body().getBonSementara();
                for (BonSementara data : content) {


                    RSNUM.setText(data.getRSNUM() + "  "+ data.getRSPOS());
                    MAKTX.setText(data.getMAKTX() +"\n"+ data.getMATNR());
                    WERKS.setText(data.getWERKS() +"\n"+ data.getLGORT());
                    BDMNG.setText(data.getBDMNG());
                    MEINS.setText(data.getMEINS());

                    Log.e("content", "Material No " + content.toString());

                }
            }

            @Override
            public void onFailure(Call<BonSementaraResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });

    }*/
}
