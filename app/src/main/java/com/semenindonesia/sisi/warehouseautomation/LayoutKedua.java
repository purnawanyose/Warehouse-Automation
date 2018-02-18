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

import adapter.BinAdapter;
import adapter.BinAdapter2;

public class LayoutKedua extends AppCompatActivity {
    private static final String TAG = "LayoutKedua";
    ArrayList<String> bin;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    public static String sbinnn,sbinFull;
    TextView textView733;

    Button btnKembali2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_kedua);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvKedua);
        textView733 = (TextView) findViewById(R.id.textView733);

        btnKembali2 = (Button) findViewById(R.id.btnKembali2);

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
        mAdapter = new BinAdapter2(bin);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Bundle extras = getIntent().getExtras();
        sbinnn = extras.getString("namaLorong");
        sbinFull = extras.getString("sbinFull");

        textView733.setText("STORAGE BIN\t\t: "+sbinFull);

        btnKembali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LayoutKedua.this, OnhandLocationActivity.class);
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
