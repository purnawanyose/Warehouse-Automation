package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.arasthel.asyncjob.AsyncJob;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;

import config.BonSementaraRv;
import config.InterimRv;
import model.BonSementara;
import model.Interim;
import response.BonSementaraResponse;
import response.InterimResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

import static android.R.id.list;
import static com.semenindonesia.sisi.warehouseautomation.R.id.combo1;

public class BonSementaraActivity extends AppCompatActivity {
    private BonSementaraRv adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_sementara);
        final KProgressHUD khud = KProgressHUD.create(BonSementaraActivity.this)
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
                    retrofit();
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

    public void retrofit(){
        /*Create handle for the RetrofitInstance interface*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<BonSementaraResponse> call = apiService.getBonSementara();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<BonSementaraResponse>() {

            @Override
            public void onResponse(Call<BonSementaraResponse> call, Response<BonSementaraResponse> response) {
                generateBonresponse((ArrayList<BonSementara>) response.body().getBonSementara());
                List<BonSementara> content = response.body().getBonSementara();
                Log.e("aa","aaas"+content.toString());
            }

            @Override
            public void onFailure(Call<BonSementaraResponse> call, Throwable t) {
                Toast.makeText(BonSementaraActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateBonresponse(ArrayList<BonSementara> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_bon);

        adapter = new BonSementaraRv(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BonSementaraActivity.this);

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
