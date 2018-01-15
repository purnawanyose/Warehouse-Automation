package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.MappingAdapter;

public class MappingUtamaActivity extends AppCompatActivity {
    private static final String TAG = "MappingUtamaActivity";
    ArrayList<String> lorong;
    RecyclerView mRecyclerView, mRecyclerView2;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager2;
    RecyclerView.Adapter mAdapter2;
    String sbin;

    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapping_utama);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler1);
        mRecyclerView2 = (RecyclerView) findViewById(R.id.recycler2);

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
        mAdapter = new MappingAdapter(lorong);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    sendData();
    }

    public void sendData() {
        Bundle extras = getIntent().getExtras();
        sbin = extras.getString("sbin");
    }
}
