package com.semenindonesia.sisi.warehouseautomation;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.arasthel.asyncjob.AsyncJob;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;

import config.InterimRv;
import model.Interim;
import response.InterimResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

//import static com.semenindonesia.sisi.warehouseautomation.R.id.MATNR;


public class InterimActivity extends AppCompatActivity {

    private InterimRv adapter;
    private RecyclerView recyclerView;

    TextView textView56, textView27;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interim_storage);


        final KProgressHUD khud = KProgressHUD.create(InterimActivity.this)
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
                    retrifit();
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
    public void  retrifit(){
         /*Create handle for the RetrofitInstance interface*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<InterimResponse> call = apiService.getInterim();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<InterimResponse>() {

            @Override
            public void onResponse(Call<InterimResponse> call, Response<InterimResponse> response) {
                generateInterimResponse((ArrayList<Interim>) response.body().getInterim());
                List<Interim> content = response.body().getInterim();
                if (content.size() < 1){
                    Toast.makeText(InterimActivity.this,"Data Not Found!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<InterimResponse> call, Throwable t) {
                Toast.makeText(InterimActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateInterimResponse(ArrayList<Interim> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_interim);

        adapter = new InterimRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(InterimActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
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

