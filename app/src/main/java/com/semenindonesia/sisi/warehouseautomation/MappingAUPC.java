package com.semenindonesia.sisi.warehouseautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.MappingAdapter;

public class MappingAUPC extends AppCompatActivity {
    private static final String TAG = "MappingAUPC";
    ArrayList<String> lorong;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    public static String sbin,sbinFull;
   /* public static String plantt;
    public static String matnoo;*/

    Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapping_aupc);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvAUPC);
        btnKembali= (Button) findViewById(R.id.btnKembali);


        lorong = new ArrayList<>();
        lorong.add("H1");
        lorong.add("G1");
        lorong.add("F1");
        lorong.add("E1");
        lorong.add("D1");
        lorong.add("C1");
        lorong.add("B1");
        lorong.add("A1");
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MappingAdapter(lorong);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Bundle extras = getIntent().getExtras();
        sbin = extras.getString("sbin");
        sbinFull = extras.getString("sbinFull");
       /* matnoo = extras.getString("matno");
        plantt = extras.getString("plant");*/



        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MappingAUPC.this, OnhandLocationActivity.class);
                intent.putExtra("PLANT", OnhandLocationActivity.plantt);
                intent.putExtra("ORDER", OnhandLocationActivity.ordr);
                intent.putExtra("MATNR", OnhandLocationActivity.matnrr);
                intent.putExtra("RSVNO", OnhandLocationActivity.rsvnoo);
                intent.putExtra("MATNO", OnhandLocationActivity.matnoo);
                startActivity(intent);
            }
        });
    }

}
