package com.semenindonesia.sisi.warehouseautomation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.arasthel.asyncjob.AsyncJob;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import model.Cart;
import model.Content;
import model.ContentModel;
import model.Issued;
import model.MatDoc;
import model.Reservation;
import model.Transloc;
import response.CallCartResponse;
import response.TranslocResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiClientLocal;
import service.ApiInterface;

public class PostTransferLocActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDateFormat dateFormatter,dateFormatterr;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    String TAG = PostTransferLocActivity.class.getSimpleName();

    EditText docDate, postDate,etHeaderText;
    Date dateObject;
    String date1,date2;
    Button btnPost;

    String PLANT, MATNO, SLOC;

    EditText etSloc, etBatch, etSS, etQty, etVendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_transfer_loc);

        docDate = (EditText) findViewById(R.id.docDate);
        postDate = (EditText) findViewById(R.id.posDate);
        etSloc = (EditText) findViewById(R.id.etSloc);
        etBatch = (EditText) findViewById(R.id.etBatch);
        etSS = (EditText) findViewById(R.id.etSS);
        etQty = (EditText) findViewById(R.id.etQty);
        etVendor = (EditText) findViewById(R.id.etVendor);
        btnPost = (Button) findViewById(R.id.btnPostTransfer);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateFormatterr = new SimpleDateFormat("yyyyMMdd", Locale.US);

        setDateTimeField();

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final KProgressHUD khud = KProgressHUD.create(PostTransferLocActivity.this)
                        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                        .setLabel("Please wait")
                        .setDetailsLabel("Retrieve Data")
                        .setCancellable(false)
                        .setAnimationSpeed(2)
                        .setDimAmount(0.5f)
                        .show();

                AsyncJob.doInBackground(new AsyncJob.OnBackgroundJob() {
                    @Override
                    public void doOnBackground() {

                        // Pretend it's doing some background processing
                        try {
                            transferLoc();
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // Create a fake result (MUST be final)
                        final boolean result = true;

                        // Send the result to the UI thread and show it on a Toast
                        AsyncJob.doOnMainThread(new AsyncJob.OnMainThreadJob() {
                            @Override
                            public void doInUIThread() {
                                khud.dismiss();

                            }
                        });
                    }
                });


            }
        });

        Bundle extras = getIntent().getExtras();
        PLANT = extras.getString("PLANT");
        MATNO = extras.getString("MATNO");
        SLOC = extras.getString("SLOCCC");
    }

    private void findViewsById() {
        docDate = (EditText) findViewById(R.id.docDate);
        docDate.setInputType(InputType.TYPE_NULL);
        docDate.requestFocus();

        postDate = (EditText) findViewById(R.id.posDate);
        postDate.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {
        docDate.setOnClickListener(this);
        postDate.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                docDate.setText(dateFormatter.format(newDate.getTime()));

                try {
                    String aa = docDate.getText().toString();
                    dateObject = dateFormatter.parse(aa);
                    date1 = new SimpleDateFormat("yyyyMMdd", Locale.US).format(dateObject);
                } catch (ParseException e) {e.printStackTrace();

                }

            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                postDate.setText(dateFormatter.format(newDate.getTime()));
                try {
                    String bb = postDate.getText().toString();
                    dateObject = dateFormatter.parse(bb);
                    date2 = new SimpleDateFormat("yyyyMMdd", Locale.US).format(dateObject);
                } catch (ParseException e) {e.printStackTrace();

                }

            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void transferLoc(){

        final ApiInterface apiService = ApiClientLocal.getClient().create(ApiInterface.class);

        Call<TranslocResponse> call = apiService.setTransloc(date1,date2,LoginActivity.pr_uname,MATNO,PLANT
                                    ,SLOC,"311",etBatch.getText().toString(),etQty.getText().toString()
                                    ,etSloc.getText().toString(),etSS.getText().toString(),etVendor.getText().toString());

        Log.wtf("URL Called", call.request().url() + "");

        Log.e("TEST TRANSLOC", "transferLoc: "+date1);
        Log.e("TEST TRANSLOC", "transferLoc: "+date2);
        Log.e("TEST TRANSLOC", "transferLoc: "+MATNO);
        Log.e("TEST TRANSLOC", "transferLoc: "+PLANT);
        Log.e("TEST TRANSLOC", "transferLoc: "+SLOC);
        Log.e("TEST TRANSLOC", "transferLoc: "+etBatch.getText().toString());
        Log.e("TEST TRANSLOC", "transferLoc: "+etQty.getText().toString());
        Log.e("TEST TRANSLOC", "transferLoc: "+etSloc.getText().toString());
        Log.e("TEST TRANSLOC", "transferLoc: "+etSS.getText().toString());
        Log.e("TEST TRANSLOC", "transferLoc: "+etVendor.getText().toString());


        call.enqueue(new Callback<TranslocResponse>() {

            @Override
            public void onResponse(Call<TranslocResponse> call, Response<TranslocResponse> response) {
                List<Transloc> content = response.body().getTransloc();
                for (Transloc data : content) {
                    Log.e(TAG, "Test Transloc: "+data.getMATDOC() );


                    if(data.getMATDOC().equalsIgnoreCase("Gagal Transloc")) {

                    }else{
                        Intent intent = new Intent(PostTransferLocActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                    Toast.makeText(PostTransferLocActivity.this, data.getMATDOC(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<TranslocResponse> call, Throwable t) {

                Toast.makeText(PostTransferLocActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                Log.e("Test", "onFailure: "+Call.class );

            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == docDate) {
            fromDatePickerDialog.show();
        } else if(view == postDate) {
            toDatePickerDialog.show();
        }
    }

}
