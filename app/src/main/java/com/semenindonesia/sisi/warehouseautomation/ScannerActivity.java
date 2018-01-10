package com.semenindonesia.sisi.warehouseautomation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.nfc.tech.NfcBarcode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.data;

public class ScannerActivity extends AppCompatActivity {
    TextView tvSbin;
    TextView tvScan;
    TextView levelText, plantText,slocText, sbinText, whsText, stypeText;
    Button button2,button4,button5,button6;
    String levelTextt;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        tvSbin = (TextView) findViewById(R.id.tvSbin);
        tvScan = (TextView) findViewById(R.id.tvScan);
        button2 = (Button) findViewById(R.id.button2);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        levelText = (TextView) findViewById(R.id.levelText);
        plantText = (TextView) findViewById(R.id.plantText);
        slocText = (TextView) findViewById(R.id.slocText);
        sbinText = (TextView) findViewById(R.id.sbinText);
        whsText = (TextView) findViewById(R.id.whsText);
        stypeText = (TextView) findViewById(R.id.stypeText);

        button2.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);

//        tvScan.setText("Azmi# Burhan");


        /*/*
        tvScan.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String scanner = tvScan.getText().toString();
                String[] scan = scanner.split("#");
                Log.e("Hasil","Scan"+scanner.toString());
                if(tvScan.getText().toString().matches("")){
                    button2.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    plantText.setText("Plant");
                    levelText.setText("Level");
                    slocText.setText("Sloc");
                    sbinText.setText("Sbin");
                    whsText.setText("Whs No.");
                    stypeText.setText("Stype");

                }else {
                    button2.setEnabled(true);
                    button4.setEnabled(true);
                    button5.setEnabled(true);
                    button6.setEnabled(true);
                    levelText.setText("Level     :  " + scan[0]);
                    plantText.setText("Plant     :  " + scan[1]);
                    slocText.setText("Sloc       :  " + scan[2]);
                    sbinText.setText("Sbin       :  " + scan[3]);
                    whsText.setText("Whs No.     :  " + scan[4]);
                    stypeText.setText("Stype         :  " + scan[5]);
                }
            }
        });
*/

        tvScan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String scanner = tvScan.getText().toString();
                String[] scan = scanner.split("#");
                Log.e("Hasil","Scan"+scanner.toString());
                if(tvScan.getText().toString().matches("")
                        && scan[3].matches(null)
                        && scan[4].matches(null)
                        && scan[5].matches(null)){
                    button2.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    plantText.setText("Plant");
                    levelText.setText("Level");
                    slocText.setText("Sloc");
                    sbinText.setText("Sbin");
                    whsText.setText("Whs No.");
                    stypeText.setText("Stype");
                }else {
                    button2.setEnabled(true);
                    button4.setEnabled(true);
                    button5.setEnabled(true);
                    button6.setEnabled(true);
                    levelText.setText("Level     :  "+scan[0]);
                    plantText.setText("Plant     :  "+scan[1]);
                    slocText.setText("Sloc       :  "+scan[2]);
                    sbinText.setText("Sbin       :  "+scan[3]);
                    whsText.setText("Whs No.     :  "+scan[4]);
                    stypeText.setText("Stype         :  "+scan[5]);
                 if (scan[0].toString().matches("")&&scan[1].toString().matches("")) {
                        plantText.setText("Plant :");
                        levelText.setText("Level :");
                    } else {
                        levelText.setText("Level :" + scan[0]);
                        plantText.setText("Plant :" + scan[1]);
                    }
                }
            }
        });


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
