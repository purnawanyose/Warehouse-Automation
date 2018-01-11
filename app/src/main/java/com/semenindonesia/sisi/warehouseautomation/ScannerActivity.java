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
        /*tvScan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
*/

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
//
//                intent.putExtra("MATNR", data.getMATNR());
//                intent.putExtra("WERKS", data.getWERKS());
//                intent.putExtra("LQNUM", data.getLQNUM());
//                intent.putExtra("LGTYP", data.getLGTYP());
                startActivity(intent);
                    //======== Menuju ke form quant ========
            }
        });


        sbinText.setLinkTextColor(Color.BLUE);
        sbinText.setPaintFlags(sbinText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        sbinText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScannerActivity.this, ImageViewActivity.class);
                startActivity(intent);
            }

        });

    }
    private void generateInterimResponse(ArrayList<OnHand> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_onhand);

        adapter = new OnHandRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ScannerActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}



