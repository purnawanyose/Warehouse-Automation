package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapping_aupc);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvAUPC);



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
    }
}
