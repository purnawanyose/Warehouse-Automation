package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.MappingAdapter2;
import adapter.MappingAdapter3;

public class MappingAUPA extends AppCompatActivity {
    private static final String TAG = "MappingAUPC";
    ArrayList<String> lorong;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    public static String sbin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapping_aupa);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvAUPA);

        lorong = new ArrayList<>();
        lorong = new ArrayList<>();
        lorong.add("W2");
        lorong.add("V2");
        lorong.add("U2");
        lorong.add("T2");
        lorong.add("S2");
        lorong.add("R2");
        lorong.add("Q2");
        lorong.add("P2");
        lorong.add("O2");
        lorong.add("N2");
        lorong.add("M2");
        lorong.add("L2");
        lorong.add("K2");
        lorong.add("J2");
        lorong.add("I2");
        lorong.add("H2");
        lorong.add("HANG");
        lorong.add("TANGGA");
        lorong.add("HANG");
        lorong.add("G2");
        lorong.add("F2");
        lorong.add("E2");
        lorong.add("D2");
        lorong.add("C2");
        lorong.add("B2");
        lorong.add("A2");
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MappingAdapter3(lorong);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Bundle extras = getIntent().getExtras();
        sbin = extras.getString("sbin");
    }
}
