package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import model.Interim;
import model.Quant;
import response.InterimResponse;
import response.QuantResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class QuantDetailActivity extends AppCompatActivity {


    TextView MATNR;
    TextView WERKS;
    TextView CHARG;
    TextView BESTQ;
    TextView SOBKZ;
    TextView LGNUM;
    TextView LGTYP;
    TextView LGPLA;
    TextView LQNUM;
    TextView GESME;
    TextView VERME;
    TextView EINME;
    TextView BTAPS;
    TextView WDATU;
    TextView WENUM;
    TextView IDATU;
    TextView BTANR;

    String MATNRR;
    String WERKSS;
    String LQNUMM;
    String LGTYPP;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quant_detail);
//        LAYROW = (TableRow) findViewById(R.id.rowlay);
        MATNR =(TextView) findViewById(R.id.material);
        WERKS =(TextView) findViewById(R.id.plantsloc);
        CHARG =(TextView) findViewById(R.id.batch);
        BESTQ =(TextView) findViewById(R.id.stockcat);
        SOBKZ =(TextView) findViewById(R.id.spesialstok);
        LGNUM =(TextView) findViewById(R.id.whno);
        LGTYP= (TextView) findViewById(R.id.stype);
        LGPLA= (TextView) findViewById(R.id.sbin);
        LQNUM= (TextView) findViewById(R.id.quant);
        GESME= (TextView) findViewById(R.id.totalstock);
        VERME= (TextView) findViewById(R.id.availstok);
        EINME= (TextView) findViewById(R.id.putaway);
        BTAPS= (TextView) findViewById(R.id.picking);
        WDATU= (TextView) findViewById(R.id.grdate);
        WENUM= (TextView) findViewById(R.id.grnumber);
        IDATU= (TextView) findViewById(R.id.lastmvt);
        BTANR= (TextView) findViewById(R.id.docnumber);

        Bundle extras = getIntent().getExtras();
        MATNRR = extras.getString("MATNR");
        WERKSS = extras.getString("WERKS");
        LQNUMM = extras.getString("LQNUM");
        LGTYPP = extras.getString("LGTYP");

        final Context context = this.getApplicationContext();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<QuantResponse> call = apiService.getQuant(WERKSS,LGTYPP,LQNUMM,MATNRR);
//        Call<QuantResponse> call = apiService.getQuant("7702","902","602","623-000013");


        Log.e("aa","bb"+ Call.class);
        call.enqueue(new Callback<QuantResponse>() {
            @Override
            public void onResponse(Call<QuantResponse> call, Response<QuantResponse> response) {
                List<Quant> content = response.body().getQuant();
                Log.e("content", "Material No " + content);
                for (Quant data : content) {
                    Log.e("content", "Material No " + content.toString());
                    MATNR.setText("Material \t\t\t: "+data.getMATNR() + " \n " +data.getMAKTX());
                    WERKS.setText("Plant / Sloc \t\t: "+data.getWERKS()+"\t"+data.getLGORT());
                    CHARG.setText("Batch  \t\t\t\t: "+data.getCHARG());
                    BESTQ.setText("Stock Cat\t\t\t: "+data.getBESTQ());
                    SOBKZ.setText("Spesial Stock\t: "+data.getSOBKZ());
                    LGNUM.setText("Wh No. \t\t\t\t: "+data.getLGNUM());
                    LGTYP.setText("SType \t\t\t\t: "+data.getLGTYP());
                    LGPLA.setText("SBin \t\t\t\t\t: "+data.getLGPLA());
                    LQNUM.setText("Quant \t\t\t\t: "+data.getLQNUM());
                    GESME.setText("Total Stock \t\t\t: "+data.getGESME());
                    VERME.setText("Avail Stock \t\t\t: "+data.getVERME());
                    EINME.setText("Putaway Stock \t: "+data.getEINME());
                    BTAPS.setText("Picking Stock \t\t: "+data.getBTAPS());
                    WDATU.setText("GR Date \t\t\t\t: "+data.getWDATU());
                    WENUM.setText("GR Number \t\t\t: "+data.getWENUM());
                    IDATU.setText("Last Mvtv\t\t\t\t: "+data.getIDATU());
                    BTANR.setText("Doc Number \t\t: "+data.getBTANR());

                    Log.e("content", "Material No " + content.toString());

                }
            }

            @Override
            public void onFailure(Call<QuantResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });
    }
}
