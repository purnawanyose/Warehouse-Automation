package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.MappingAdapter;
import config.OnHandRv;
import model.OnHand;
import response.OnHandResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

import static android.R.attr.data;
import static com.semenindonesia.sisi.warehouseautomation.R.id.levelText;
import static com.semenindonesia.sisi.warehouseautomation.R.id.nama_lorong;
import static com.semenindonesia.sisi.warehouseautomation.R.id.strgBin;
import static com.semenindonesia.sisi.warehouseautomation.R.id.view;

public class ScannerActivity extends AppCompatActivity {
    TextView tvSbin;
    TextView tvScan;
    TextView levelText, plantText,slocText, sbinText, whText, strgText;
    Button button2,button4,button5,button6;
    String aa;
    private OnHandRv adapter;
    private RecyclerView recyclerView;

    private Context context;
    public ArrayList<OnHand> dataList;
    String s1,s2,s3,s4,s5,s6;

    RecyclerView recyclerView1;
    TextView nama_lorong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        tvScan = (TextView) findViewById(R.id.tvScan);
        button2 = (Button) findViewById(R.id.button2);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        levelText = (TextView) findViewById(R.id.levelText);
        plantText = (TextView) findViewById(R.id.plantText);
        slocText = (TextView) findViewById(R.id.slocText);
        sbinText = (TextView) findViewById(R.id.sbinText);
        whText = (TextView) findViewById(R.id.whText);
        strgText = (TextView) findViewById(R.id.strgText);
//        recyclerView1 = (RecyclerView) findViewById(R.id.rece)
        nama_lorong = (TextView) findViewById(R.id.nama_lorong);

        button2.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
////        tvScan.setText("Azmi# Burhan");
//        aa = tvScan.getText().toString();


        tvScan.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
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
                        sbinText.setText("Strg Bin");
                        whText.setText("Wh No.");
                        strgText.setText("Strg Type");
                    }else {
                        if(scan[0].toString().matches("WM")){
                            button2.setEnabled(true);
                            button4.setEnabled(true);
                            button5.setEnabled(true);
                            button6.setEnabled(true);
                            levelText.setText(scan[0]);
                            plantText.setText(scan[1]);
                            slocText.setText(scan[2]);
                            sbinText.setText(scan[5]);
                            whText.setText(scan[3]);
                            strgText.setText(scan[4]);
                            levelText.setVisibility(View.VISIBLE);
                            plantText.setVisibility(View.VISIBLE);
                            slocText.setVisibility(View.VISIBLE);
                            sbinText.setVisibility(View.VISIBLE);
                            whText.setVisibility(View.VISIBLE);
                            strgText.setVisibility(View.VISIBLE);
                        }else if(scan[0].toString().matches("IM")){
                            button2.setEnabled(true);
                            button4.setEnabled(true);
                            button5.setEnabled(true);
                            button6.setEnabled(true);
                            levelText.setText(scan[0]);
                            plantText.setText(scan[1]);
                            slocText.setText(scan[2]);
                            levelText.setVisibility(View.VISIBLE);
                            plantText.setVisibility(View.VISIBLE);
                            slocText.setVisibility(View.VISIBLE);
                        }else{

                        }
                    }
                    return true;
                }
                return false;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ScannerActivity.this, ScannerOnhandPageActivity.class);

                intent.putExtra("level", levelText.getText().toString());
                intent.putExtra("plant", plantText.getText().toString());
                intent.putExtra("sloc", slocText.getText().toString());
                intent.putExtra("sbin", sbinText.getText().toString());
                intent.putExtra("whs", whText.getText().toString());
                intent.putExtra("stype", strgText.getText().toString());
                startActivity(intent);
                    //======== Menuju ke form Onhand ========
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ScannerActivity.this, ScannerStockOpnameActivity.class);

                intent.putExtra("level", levelText.getText().toString());
                intent.putExtra("plant", plantText.getText().toString());
                intent.putExtra("sloc", slocText.getText().toString());
                intent.putExtra("sbin", sbinText.getText().toString());
                intent.putExtra("whs", whText.getText().toString());
                intent.putExtra("stype", strgText.getText().toString());
                startActivity(intent);
                    //======== Menuju ke form Onhand ========
            }
        });


        sbinText.setLinkTextColor(Color.BLUE);
        sbinText.setPaintFlags(sbinText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        sbinText.setOnClickListener(new View.OnClickListener() {
            public static final String TAG = "ScannerActivity";

            @Override
            public void onClick(View v) {

                String huruf = (String) sbinText.getText().toString();
                String akhir = huruf.substring(1,3);
                Log.e(TAG, "onClicdsfhgjgfdsafghk: "+akhir );

                Intent intent = new Intent(ScannerActivity.this, MapUtamaActivity.class);
                intent.putExtra("sbin", sbinText.getText().toString());
                startActivity(intent);

            }

        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            Intent a = new Intent(this,MainActivity.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(a);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}



