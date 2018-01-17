package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BinActivity extends AppCompatActivity {
    String namaLorong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin);

        Bundle extras = getIntent().getExtras();
        namaLorong = extras.getString("namaLorong");
    }
}
