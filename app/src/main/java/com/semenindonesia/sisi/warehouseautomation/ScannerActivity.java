package com.semenindonesia.sisi.warehouseautomation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.nfc.tech.NfcBarcode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.data;

public class ScannerActivity extends AppCompatActivity {
    TextView tvSbin;
    TextView tvScan;
    TextView levelText;
    TextView button2;
    String levelTextt;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        tvSbin = (TextView) findViewById(R.id.tvSbin);
        tvScan = (TextView) findViewById(R.id.tvScan);
        button2 = (Button) findViewById(R.id.button2);
        levelText = (TextView) findViewById(R.id.levelText);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvScan.getText() == null) {
                    levelText.setText("SUKSES");

                } else {
                    levelText.setText("GAGAL");

                }
            }
        });


        tvSbin.setLinkTextColor(Color.BLUE);
        tvSbin.setPaintFlags(tvSbin.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        tvSbin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScannerActivity.this, ImageViewActivity.class);
                startActivity(intent);
            }

        });

    }
}
