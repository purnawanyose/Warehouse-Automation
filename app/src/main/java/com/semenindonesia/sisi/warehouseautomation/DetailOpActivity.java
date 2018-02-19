package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.DetailStockOpnameRv;
import config.StockOpnameRv;
import model.HeadDetailOpname;
import model.ItemDetailOpname;
import model.Opname;
import model.Reservation;
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

    TextView pid;

    String URL_LOGIN = "http://int-eprocurement.semenindonesia.com/eproc/EC_API/Opname/detail/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_op);

        final Context context = this.getApplicationContext();

        pid = (TextView)findViewById(R.id.pid);

        Bundle extras = getIntent().getExtras();
        PID = extras.getString("PID");
        FYEAR = extras.getString("FYEAR");

//        detailVolley();

        /*ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<StockOpnameDetailResponse> call = apiService.getOpnameDetail(PID,FYEAR);
         *//*Log the URL called*//*
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<StockOpnameDetailResponse>() {
            @Override
            public void onResponse(Call<StockOpnameDetailResponse> call, Response<StockOpnameDetailResponse> response) {
//                generateInterimResponse((ArrayList<ItemDetailOpname>) response.body().getItems());
                *//*HeadDetailOpname aa = response.body().getHead();
                Log.e("StockOpname", "Sukses"+aa.getPHYSINVENTORY());
                    pid.setText(aa.getPHYSINVENTORY());
*//*
                Log.e("StockOpname", "Sukses");
            }

            @Override
            public void onFailure(Call<StockOpnameDetailResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });*/
    }
/*
    private void detailVolley() {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        StringRequest strReq = new StringRequest(Request.Method.GET,
                URL_LOGIN, new com.android.volley.Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e("", "Login Response: " + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    String content = jObj.getString("head");
                    JSONArray Head = jObj.getJSONArray(content);


                    Log.e("TESTING BRO", "onResponse: "+Head.length());
                    Toast.makeText(getApplicationContext(),
                            ""+content, Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Log.e("TAG", "onResponse: "+e.getMessage() );
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("", "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();

                params.put("pid", "1000000040");
                params.put("fiscalyear", "2015");

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(strReq);
    }*/

    private void generateInterimResponse(ArrayList<ItemDetailOpname> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.detailOpnameRv);

        adapter = new DetailStockOpnameRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DetailOpActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
