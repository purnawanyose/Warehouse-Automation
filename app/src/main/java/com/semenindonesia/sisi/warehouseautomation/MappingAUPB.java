package com.semenindonesia.sisi.warehouseautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import adapter.MappingAdapter;
import adapter.MappingAdapter2;

public class MappingAUPB extends AppCompatActivity {
    private static final String TAG = "MappingAUPC";
    ArrayList<String> lorong;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    public static String sbin,sbinFull;
    public static String plantt;
    public static String matnoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapping_aupb);


        mRecyclerView = (RecyclerView) findViewById(R.id.rvAUPB);


        lorong = new ArrayList<>();
        lorong = new ArrayList<>();
        lorong.add("G3");
        lorong.add("F3");
        lorong.add("E3");
        lorong.add("D3");
        lorong.add("C3");
        lorong.add("B3");
        lorong.add("A3");
        lorong.add("Z1");
        lorong.add("Y1");
        lorong.add("X1");
        lorong.add("W1");
        lorong.add("V1");
        lorong.add("U1");
        lorong.add("T1");
        lorong.add("S1");
        lorong.add("R1");
        lorong.add("HANG");
        lorong.add("TANGGA");
        lorong.add("HANG");
        lorong.add("Q1");
        lorong.add("P1");
        lorong.add("O1");
        lorong.add("N1");
        lorong.add("M1");
        lorong.add("L1");
        lorong.add("K1");
        lorong.add("J1");
        lorong.add("I1");
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MappingAdapter2(lorong);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Bundle extras = getIntent().getExtras();
        sbin = extras.getString("sbin");
        sbinFull = extras.getString("sbinFull");

    }
}
