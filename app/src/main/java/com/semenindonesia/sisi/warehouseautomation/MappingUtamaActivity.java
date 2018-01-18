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
    ArrayList<String> lorong, lorong2, lorong3;
    RecyclerView mRecyclerView, mRecyclerView2, mRecyclerView3;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager2;
    RecyclerView.Adapter mAdapter2;
    RecyclerView.LayoutManager mLayoutManager3;
    RecyclerView.Adapter mAdapter3;
    public static String sbin;

    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapping_utama);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler1);
        mRecyclerView2 = (RecyclerView) findViewById(R.id.recycler2);
        mRecyclerView3 = (RecyclerView) findViewById(R.id.recycler3);
        mRecyclerView3 = (RecyclerView) findViewById(R.id.recycler3);
        mRecyclerView3 = (RecyclerView) findViewById(R.id.recycler3);

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

//        Bundle extras = getIntent().getExtras();
//        sbin = extras.getString("sbin");

        lorong2 = new ArrayList<>();
        lorong2.add("G3");
        lorong2.add("F3");
        lorong2.add("E3");
        lorong2.add("D3");
        lorong2.add("C3");
        lorong2.add("B3");
        lorong2.add("A3");
        lorong2.add("Z1");
        lorong2.add("Y1");
        lorong2.add("X1");
        lorong2.add("W1");
        lorong2.add("V1");
        lorong2.add("U1");
        lorong2.add("T1");
        lorong2.add("S1");
        lorong2.add("R1");
        lorong2.add("HANG");
        lorong2.add("TANGGA");
        lorong2.add("HANG");
        lorong2.add("Q1");
        lorong2.add("P1");
        lorong2.add("O1");
        lorong2.add("N1");
        lorong2.add("M1");
        lorong2.add("L1");
        lorong2.add("K1");
        lorong2.add("J1");
        lorong2.add("I1");
        mRecyclerView2.setHasFixedSize(true);
        mLayoutManager2 = new LinearLayoutManager(this);
        mAdapter2 = new MappingAdapter(lorong2);
        mRecyclerView2.setLayoutManager(mLayoutManager2);
        mRecyclerView2.setAdapter(mAdapter2);

        lorong3 = new ArrayList<>();
        lorong3.add("H1");
        lorong3.add("G1");
        lorong3.add("F1");
        lorong3.add("E1");
        lorong3.add("D1");
        lorong3.add("C1");
        lorong3.add("B1");
        lorong3.add("A1");
        mRecyclerView3.setHasFixedSize(true);
        mLayoutManager3 = new LinearLayoutManager(this);
        mAdapter3 = new MappingAdapter(lorong3);
        mRecyclerView3.setLayoutManager(mLayoutManager3);
        mRecyclerView3.setAdapter(mAdapter3);

        Bundle extras = getIntent().getExtras();
        sbin = extras.getString("sbin");

    }
}
