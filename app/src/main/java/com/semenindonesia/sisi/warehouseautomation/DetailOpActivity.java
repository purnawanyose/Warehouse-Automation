package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.CheckBox;
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

    CheckBox cbCountSt, cbAdjust, cbDel, cbPostBlack, cbFreeze;
    TextView pid, plantText, slocText, spcsloc, crtd, docDate, planDate, countDate, postDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_op);

        final Context context = this.getApplicationContext();

        pid = (TextView)findViewById(R.id.pid);
        plantText = (TextView)findViewById(R.id.plantText);
        slocText = (TextView)findViewById(R.id.slocText);
        spcsloc = (TextView)findViewById(R.id.spcsloc);
        crtd = (TextView)findViewById(R.id.crtd);
        docDate = (TextView)findViewById(R.id.docdate);
        planDate = (TextView)findViewById(R.id.plandate);
        countDate = (TextView)findViewById(R.id.countdate);
        postDate = (TextView)findViewById(R.id.postdate);


        cbCountSt = (CheckBox) findViewById(R.id.cbCountSt);
        cbAdjust = (CheckBox) findViewById(R.id.cbAdjust);
        cbDel = (CheckBox) findViewById(R.id.cbDel);
        cbPostBlack = (CheckBox) findViewById(R.id.cbPostBlack);
        cbFreeze = (CheckBox) findViewById(R.id.cbFreeze);


        Bundle extras = getIntent().getExtras();
        PID = extras.getString("PID");
        FYEAR = extras.getString("FYEAR");

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<DetailResponse> call = apiService.getOpnameDetail(PID, FYEAR);
         /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                int i = response.body().getStatus();
                List<ItemDetailOpname> items = response.body().getContent().getItems();
                generateInterimResponse((ArrayList<ItemDetailOpname>) response.body().getContent().getItems());

                String user = response.body().getContent().getHead().getUSERNAME();
                pid.setText("PID.              : "+response.body().getContent().getHead().getPHYSINVENTORY());
                plantText.setText("Plant             : "+response.body().getContent().getHead().getPLANT());
                slocText.setText("Sloc               : "+response.body().getContent().getHead().getSTGELOC());
                spcsloc.setText("Spc Sloc        : "+"");
                crtd.setText("Crty by           : "+response.body().getContent().getHead().getUSERNAME());
                docDate.setText("Doc Date        : "+response.body().getContent().getHead().getDOCDATE());
                planDate.setText("Plan Date       : "+response.body().getContent().getHead().getPLANDATE());
                countDate.setText("Count Dat       : "+response.body().getContent().getHead().getCOUNTDATE());
                postDate.setText("Post Date       : "+response.body().getContent().getHead().getPSTNGDATE());


                if (response.body().getContent().getHead().getPOSTBLOCK().equalsIgnoreCase("")){
                    cbPostBlack.setChecked(false);
                }else{
                    cbPostBlack.setChecked(true);
                }
                if (response.body().getContent().getHead().getFREEZEBOOKINV().equalsIgnoreCase("")){
                    cbFreeze.setChecked(false);
                }else{
                    cbFreeze.setChecked(true);
                }
                if (response.body().getContent().getHead().getCOUNTSTATUS().equalsIgnoreCase("")){
                    cbCountSt.setChecked(false);
                }else{
                    cbCountSt.setChecked(true);
                }
                if (response.body().getContent().getHead().getADJUSTSTATUS().equalsIgnoreCase("")){
                    cbAdjust.setChecked(false);
                }else{
                    cbAdjust.setChecked(true);
                }
                if (response.body().getContent().getHead().getDELETESTATUS().equalsIgnoreCase("")){
                    cbDel.setChecked(false);
                }else{
                    cbDel.setChecked(true);
                }
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
