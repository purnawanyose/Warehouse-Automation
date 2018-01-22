package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.BinAdapter;
import adapter.BinAdapter3;

public class LayoutKetiga extends AppCompatActivity {
    private static final String TAG = "LayoutPertama";
    ArrayList<String> bin, bin2;
    RecyclerView mRecyclerView;
    RecyclerView mRecyclerView2;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    public static String sbinnn,sbinFull;
    TextView textView73;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_ketiga);


        mRecyclerView = (RecyclerView) findViewById(R.id.rvKetiga2);
        mRecyclerView2 = (RecyclerView) findViewById(R.id.rvKetiga1);
        textView73 = (TextView) findViewById(R.id.tvKetiga);

        bin = new ArrayList<>();
        bin.add("7");
        bin.add("6");
        bin.add("5");
        bin.add("4");
        bin.add("3");
        bin.add("2");
        bin.add("1");
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BinAdapter3(bin);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        bin2 = new ArrayList<>();
        bin2.add("14");
        bin2.add("13");
        bin2.add("12");
        bin2.add("11");
        bin2.add("10");
        bin2.add("9");
        bin2.add("8");
        mRecyclerView2.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BinAdapter3(bin2);
        mRecyclerView2.setLayoutManager(mLayoutManager);
        mRecyclerView2.setAdapter(mAdapter);

        Bundle extras = getIntent().getExtras();
        sbinnn = extras.getString("namaLorong");
        sbinFull = extras.getString("sbinFull");

        textView73.setText("STORAGE BIN\t\t: "+sbinFull);


    }
}
