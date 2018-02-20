package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import config.DetailStockOpnameRv;
import config.ScannerDetailStockOpnameRv;
import de.mrapp.android.dialog.WizardDialog;
import fragment.CountDialog;
import model.ItemDetailOpname;
import model.Posting;
import response.CallCartResponse;
import response.DetailResponse;
import response.PostingResponse;
import response.StockOpnameResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiClientLocal;
import service.ApiInterface;

public class ScannerDetailOpActivity extends AppCompatActivity {


    private ScannerDetailStockOpnameRv adapter;
    private RecyclerView recyclerView;

    Button btnCount,btnPosting,btnRecount;

    public static String PID, FYEAR;
    String TAG = ScannerDetailOpActivity.class.getSimpleName();

    String PID1, FYEAR1, CURDATE;
    private ArrayList<ItemDetailOpname> itemlist = new ArrayList<ItemDetailOpname>();

    CheckBox cbCountSt, cbAdjust, cbDel, cbPostBlack, cbFreeze;
    TextView pid, plantText, slocText, spcsloc, crtd, docDate, planDate, countDate, postDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_detail_op);

        final Context context = this.getApplicationContext();

        pid = (TextView)findViewById(R.id.pid);
        plantText = (TextView)findViewById(R.id.plantText);
        slocText = (TextView)findViewById(R.id.slocText);
        docDate = (TextView)findViewById(R.id.docdate);
        planDate = (TextView)findViewById(R.id.plandate);
        countDate = (TextView)findViewById(R.id.countdate);
        cbCountSt = (CheckBox) findViewById(R.id.cbCountSt);
        cbPostBlack = (CheckBox) findViewById(R.id.cbPostBlack);
        cbFreeze = (CheckBox) findViewById(R.id.cbFreeze);
        btnCount = (Button) findViewById(R.id.btnCount);
        btnPosting = (Button) findViewById(R.id.btnPosting);
        btnRecount = (Button) findViewById(R.id.btnRecount);

        btnCount.setEnabled(false);
        btnPosting.setEnabled(false);

        Bundle extras = getIntent().getExtras();
        PID = extras.getString("PID");
        FYEAR = extras.getString("FYEAR");

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<DetailResponse> call = apiService.getOpnameDetail(PID, FYEAR);
         /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                int i = response.body().getStatus();
                List<ItemDetailOpname> items = response.body().getContent().getItems();
                generateInterimResponse((ArrayList<ItemDetailOpname>) response.body().getContent().getItems());

                String user = response.body().getContent().getHead().getUSERNAME();
                pid.setText("PID.              : "+response.body().getContent().getHead().getPHYSINVENTORY());
                plantText.setText("Plant             : "+response.body().getContent().getHead().getPLANT());
                slocText.setText("Sloc               : "+response.body().getContent().getHead().getSTGELOC());
                docDate.setText("Doc Date        : "+response.body().getContent().getHead().getDOCDATE());
                planDate.setText("Plan Date       : "+response.body().getContent().getHead().getPLANDATE());
                countDate.setText("Count Dat       : "+response.body().getContent().getHead().getCOUNTDATE());

                PID1 = response.body().getContent().getHead().getPHYSINVENTORY();
                FYEAR1 = response.body().getContent().getHead().getFISCALYEAR();


                if (response.body().getContent().getHead().getPOSTBLOCK().equalsIgnoreCase("")){
                    cbPostBlack.setChecked(false);
                }else{
                    cbPostBlack.setChecked(true);
                }
                if (response.body().getContent().getHead().getFREEZEBOOKINV().equalsIgnoreCase("")){
                    cbFreeze.setChecked(false);
                }else{
                    cbFreeze.setChecked(true);
                }
                if (response.body().getContent().getHead().getCOUNTSTATUS().equalsIgnoreCase("")){
                    cbCountSt.setChecked(false);
                    btnCount.setEnabled(true);
                    btnPosting.setEnabled(false);


                }else{
                    cbCountSt.setChecked(true);
                    btnCount.setVisibility(View.GONE);
                    btnRecount.setVisibility(View.VISIBLE);
                    btnPosting.setEnabled(true);
                }
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("Interim", "Material Noooooooooooo"+ call);

            }
        });

        count();
        recount();
        posting();

    }

    private void generateInterimResponse(ArrayList<ItemDetailOpname> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.scannerdetailOpnameRv);

        adapter = new ScannerDetailStockOpnameRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ScannerDetailOpActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
    public void posting(){

        btnPosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WizardDialog.Builder dialogBuilder = new WizardDialog.Builder(ScannerDetailOpActivity.this);
                dialogBuilder.addFragment("", CountDialog.class);
                dialogBuilder.setFinishButtonText("Count Confirmation");
                dialogBuilder.showHeader(true);
                dialogBuilder.setFullscreen(false);
                dialogBuilder.setMaxHeight(500);
                dialogBuilder.setCancelable(true);
                dialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        CURDATE = CountDialog.rangeDate;
                        Log.e(TAG, "onDismiss: " + CURDATE);
                        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                        Log.e(TAG, "ITEM: " + ScannerDetailStockOpnameRv.ITEM);
                        Log.e(TAG, "MATERIAL: " + ScannerDetailStockOpnameRv.MATERIAL);
                        Log.e(TAG, "QNT: " + ScannerDetailStockOpnameRv.ENTRY_QNT);
                        Log.e(TAG, "UOM: " + ScannerDetailStockOpnameRv.ENTRY_UOM);

                        //*Call the method with parameter in the interface to get the employee data*//*
                        Call<PostingResponse> call = apiService.getPostingOpname(PID1, FYEAR1, CURDATE/*"20180219"*/);

                        //*Log the URL called*//*
                        Log.wtf("URL Called", call.request().url() + "");

                        call.enqueue(new Callback<PostingResponse>() {
                            @Override
                            public void onResponse(Call<PostingResponse> call, Response<PostingResponse> response) {
                                Toast.makeText(ScannerDetailOpActivity.this, "TYPE            : " + response.body().getContent().getTYPE() +
                                                "\n" + "ID                 : " + response.body().getContent().getID() +
                                                "\n" + "NUMBER         : " + response.body().getContent().getNUMBER() +
                                                "\n" + "MESSAGE        : " + response.body().getContent().getMESSAGE()

                                        , Toast.LENGTH_LONG).show();
                                String user = response.body().getContent().getID();
                                Log.e(TAG, "TESTING RESPONSE ID: " + user);

                                finish();
                            }

                            @Override
                            public void onFailure(Call<PostingResponse> call, Throwable t) {
                                Toast.makeText(ScannerDetailOpActivity.this, " Data Deleted", Toast.LENGTH_SHORT).show();
//                            Log.e("Test Error", "onFailure: "+Call.class );
                                finish();
                            }
                        });

                    }
                });
                WizardDialog dialog = dialogBuilder.create();
                dialog.show(getSupportFragmentManager(), "test");

                /*final AlertDialog.Builder builder = new AlertDialog.Builder(ScannerDetailOpActivity.this);
                builder.setMessage("Count Confirmation"+"\n"+
                        "\n"+"PID No.         :"+PID1+"\n"+
                        "\n"+"Fiscal Year   :"+FYEAR1+"\n"+
                        "\n"+"Count Date");
                builder.setCancelable(true);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                         *//*Create handle for the RetrofitInstance interface*//*
                        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                        Log.e(TAG, "ITEM: "+ScannerDetailStockOpnameRv.ITEM );
                        Log.e(TAG, "MATERIAL: "+ ScannerDetailStockOpnameRv.MATERIAL);
                        Log.e(TAG, "QNT: "+ScannerDetailStockOpnameRv.ENTRY_QNT);
                        Log.e(TAG, "UOM: "+ScannerDetailStockOpnameRv.ENTRY_UOM);

                    *//*Call the method with parameter in the interface to get the employee data*//*
                        Call<PostingResponse> call = apiService.getPostingOpname(PID1,FYEAR1,"20180219");

                    *//*Log the URL called*//*
                        Log.wtf("URL Called", call.request().url() + "");

                        call.enqueue(new Callback<PostingResponse>() {
                            @Override
                            public void onResponse(Call<PostingResponse> call, Response<PostingResponse> response) {
                                Toast.makeText(ScannerDetailOpActivity.this, "TYPE            : "+response.body().getContent().getTYPE()+
                                                "\n"+"ID                 : "+response.body().getContent().getID()+
                                                "\n"+"NUMBER         : "+response.body().getContent().getNUMBER()+
                                                "\n"+"MESSAGE        : "+response.body().getContent().getMESSAGE()

                                        ,Toast.LENGTH_LONG).show();
                                String user = response.body().getContent().getID();
                                Log.e(TAG, "TESTING RESPONSE ID: "+user);

                                finish();
                            }

                            @Override
                            public void onFailure(Call<PostingResponse> call, Throwable t) {
                                Toast.makeText(ScannerDetailOpActivity.this, " Data Deleted", Toast.LENGTH_SHORT).show();
//                            Log.e("Test Error", "onFailure: "+Call.class );
                                finish();
                            }
                        });
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();*/
            }
        });

    }

    public void recount(){

        btnRecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ScannerDetailOpActivity.this);
                builder.setMessage("Count Confirmation"+"\n"+
                        "\n"+"PID No.         :"+PID1+"\n"+
                        "\n"+"Fiscal Year   :"+FYEAR1+"\n"+
                        "\n"+"Count Date");
                builder.setCancelable(true);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                         /*Create handle for the RetrofitInstance interface*/
                        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                        Log.e(TAG, "ITEM: "+ScannerDetailStockOpnameRv.ITEM );
                        Log.e(TAG, "MATERIAL: "+ ScannerDetailStockOpnameRv.MATERIAL);
                        Log.e(TAG, "QNT: "+ScannerDetailStockOpnameRv.ENTRY_QNT);
                        Log.e(TAG, "UOM: "+ScannerDetailStockOpnameRv.ENTRY_UOM);

                    /*Call the method with parameter in the interface to get the employee data*/
                        Call<PostingResponse> call = apiService.getRecountOpname(PID1,FYEAR1,ScannerDetailStockOpnameRv.ITEM,
                                ScannerDetailStockOpnameRv.MATERIAL,"448",
                                ScannerDetailStockOpnameRv.ENTRY_UOM);

                    /*Log the URL called*/
                        Log.wtf("URL Called", call.request().url() + "");

                        call.enqueue(new Callback<PostingResponse>() {
                            @Override
                            public void onResponse(Call<PostingResponse> call, Response<PostingResponse> response) {
                                Toast.makeText(ScannerDetailOpActivity.this, "TYPE            : "+response.body().getContent().getTYPE()+
                                                "\n"+"ID                 : "+response.body().getContent().getID()+
                                                "\n"+"NUMBER         : "+response.body().getContent().getNUMBER()+
                                                "\n"+"MESSAGE        : "+response.body().getContent().getMESSAGE()

                                        ,Toast.LENGTH_LONG).show();
                                String user = response.body().getContent().getID();
                                Log.e(TAG, "TESTING RESPONSE ID: "+user);

                                finish();
                            }

                            @Override
                            public void onFailure(Call<PostingResponse> call, Throwable t) {
                                Toast.makeText(ScannerDetailOpActivity.this, " Data Deleted", Toast.LENGTH_SHORT).show();
//                            Log.e("Test Error", "onFailure: "+Call.class );
                                finish();
                            }
                        });
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    public void count(){
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*final AlertDialog.Builder builder = new AlertDialog.Builder(ScannerDetailOpActivity.this);
                builder.setMessage("Count Confirmation"+"\n"+
                                    "\n"+"PID No.         :"+PID1+"\n"+
                                    "\n"+"Fiscal Year   :"+FYEAR1+"\n"+
                                    "\n"+"Count Date");
                builder.setCancelable(true);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                         *//*Create handle for the RetrofitInstance interface*//*
                        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                        Log.e(TAG, "ITEM: "+ScannerDetailStockOpnameRv.ITEM );
                        Log.e(TAG, "MATERIAL: "+ ScannerDetailStockOpnameRv.MATERIAL);
                        Log.e(TAG, "QNT: "+ScannerDetailStockOpnameRv.ENTRY_QNT);
                        Log.e(TAG, "UOM: "+ScannerDetailStockOpnameRv.ENTRY_UOM);

                    *//*Call the method with parameter in the interface to get the employee data*//*
                        Call<PostingResponse> call = apiService.getCountOpname(PID1,FYEAR1,"20160219",ScannerDetailStockOpnameRv.ITEM,
                                                        ScannerDetailStockOpnameRv.MATERIAL,ScannerDetailStockOpnameRv.ENTRY_QNT,
                                                        ScannerDetailStockOpnameRv.ENTRY_UOM);

                    *//*Log the URL called*//*
                        Log.wtf("URL Called", call.request().url() + "");

                        call.enqueue(new Callback<PostingResponse>() {
                            @Override
                            public void onResponse(Call<PostingResponse> call, Response<PostingResponse> response) {
                                Toast.makeText(ScannerDetailOpActivity.this, "TYPE            : "+response.body().getContent().getTYPE()+
                                                "\n"+"ID                 : "+response.body().getContent().getID()+
                                                "\n"+"NUMBER         : "+response.body().getContent().getNUMBER()+
                                                "\n"+"MESSAGE        : "+response.body().getContent().getMESSAGE()

                                        ,Toast.LENGTH_LONG).show();
                                String user = response.body().getContent().getID();
                                Log.e(TAG, "TESTING RESPONSE ID: "+user);

                                finish();
                            }

                            @Override
                            public void onFailure(Call<PostingResponse> call, Throwable t) {
                                Toast.makeText(ScannerDetailOpActivity.this, " Data Deleted", Toast.LENGTH_SHORT).show();
//                            Log.e("Test Error", "onFailure: "+Call.class );
                                finish();
                            }
                        });
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();*/
                WizardDialog.Builder dialogBuilder = new WizardDialog.Builder(ScannerDetailOpActivity.this);
                dialogBuilder.addFragment("", CountDialog.class);
                dialogBuilder.setFinishButtonText("Count Confirmation");
                dialogBuilder.showHeader(true);
                dialogBuilder.setFullscreen(false);
                dialogBuilder.setMaxHeight(500);
                dialogBuilder.setCancelable(true);
                dialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        CURDATE = CountDialog.rangeDate;

                        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                        Log.e(TAG, "ITEM: " + ScannerDetailStockOpnameRv.ITEM);
                        Log.e(TAG, "MATERIAL: " + ScannerDetailStockOpnameRv.MATERIAL);
                        Log.e(TAG, "QNT: " + ScannerDetailStockOpnameRv.ENTRY_QNT);
                        Log.e(TAG, "UOM: " + ScannerDetailStockOpnameRv.ENTRY_UOM);

                        //*Call the method with parameter in the interface to get the employee data*//*
                        Call<PostingResponse> call = apiService.getCountOpname(PID1, FYEAR1, CURDATE,/*"20160219"*/ScannerDetailStockOpnameRv.ITEM,
                                ScannerDetailStockOpnameRv.MATERIAL, ScannerDetailStockOpnameRv.ENTRY_QNT,
                                ScannerDetailStockOpnameRv.ENTRY_UOM);

                        //*Log the URL called*//*
                        Log.wtf("URL Called", call.request().url() + "");

                        call.enqueue(new Callback<PostingResponse>() {
                            @Override
                            public void onResponse(Call<PostingResponse> call, Response<PostingResponse> response) {
                                Toast.makeText(ScannerDetailOpActivity.this, "TYPE            : " + response.body().getContent().getTYPE() +
                                                "\n" + "ID                 : " + response.body().getContent().getID() +
                                                "\n" + "NUMBER         : " + response.body().getContent().getNUMBER() +
                                                "\n" + "MESSAGE        : " + response.body().getContent().getMESSAGE()

                                        , Toast.LENGTH_LONG).show();
                                String user = response.body().getContent().getID();
                                Log.e(TAG, "TESTING RESPONSE ID: " + user);

                                finish();
                            }

                            @Override
                            public void onFailure(Call<PostingResponse> call, Throwable t) {
                                Toast.makeText(ScannerDetailOpActivity.this, " Data Deleted", Toast.LENGTH_SHORT).show();
//                            Log.e("Test Error", "onFailure: "+Call.class );
                                finish();
                            }
                        });

                    }
                });
                WizardDialog dialog = dialogBuilder.create();
                dialog.show(getSupportFragmentManager(), "test");
            }
        });
    }
}
