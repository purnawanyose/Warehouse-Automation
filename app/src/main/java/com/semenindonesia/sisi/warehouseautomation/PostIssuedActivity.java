package com.semenindonesia.sisi.warehouseautomation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.arasthel.asyncjob.AsyncJob;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import model.Cart;
import model.Content;
import model.ContentIssued;
import model.Issued;
import model.OnHandLocation;
import model.Quant;
import model.Reservation;
import model.Transloc;
import okio.Timeout;
import response.CallCartResponse;
import response.IssuedResponse;
import response.ReservationDetailResponse;
import response.TranslocResponse;
/*import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;*/
import retrofit2.http.Field;
import service.ApiClient;
import service.ApiClientLocal;
import service.ApiInterface;

import static com.semenindonesia.sisi.warehouseautomation.R.id.tglAkhir;

public class PostIssuedActivity extends AppCompatActivity implements View.OnClickListener {
    private SimpleDateFormat dateFormatter,dateFormatterr;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;


    EditText docDate, postDate,etHeaderText;
    Date dateObject;
    String date1,date2;
    Button btnPost;
    String plant,norsv,order,nilaiInput, bwart, lgort, rspos;
    String specialStock, wbs_elem, val_type;

    String URL_LOGIN = "http://10.15.26.4/API_Warehouse/get_data.php";

    public String plant1[];
    public List<String> user1 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_issued);

        docDate = (EditText) findViewById(R.id.docDate);
        postDate = (EditText) findViewById(R.id.posDate);
        etHeaderText = (EditText) findViewById(R.id.etHeaderText);
        btnPost = (Button) findViewById(R.id.btnPost);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateFormatterr = new SimpleDateFormat("yyyyMMdd", Locale.US);

        setDateTimeField();

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final KProgressHUD khud = KProgressHUD.create(PostIssuedActivity.this)
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
                            checkIssued();
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
        plant = extras.getString("PLANT");
        norsv = extras.getString("RSVNO");
        bwart = extras.getString("BWART");
        lgort = extras.getString("LGORT");
        rspos = extras.getString("RSPOS");
        nilaiInput = extras.getString("NILAIAKHIR");
        specialStock = extras.getString("SS");
        wbs_elem = extras.getString("WBS");
        val_type = extras.getString("VAL");

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
        return true;
    }

    /*private void issuedBaru(){

        final ApiInterface apiService = ApiClientLocal.getClient().create(ApiInterface.class);

        Call<IssuedResponse> call = apiService.setPostIssued(date1,date2,etHeaderText.getText().toString(),norsv);
        Log.e("Nilai Header Text", "issuedBaru: "+etHeaderText.getText().toString());
        Log.e("Nilai Date1", "issuedBaru: "+date1 );
        Log.e("Nilai Date2", "issuedBaru: "+date2);
        Log.e("Nilai NO RESERVASI", "issuedBaru: "+norsv);
        Log.e("Nilai PR_UNAME", "issuedBaru: "+LoginActivity.pr_uname);

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<IssuedResponse>() {

            @Override
            public void onResponse(Call<IssuedResponse> call, Response<IssuedResponse> response) {

                    Toast.makeText(PostIssuedActivity.this, "Sukses", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<IssuedResponse> call, Throwable t) {
                Toast.makeText(PostIssuedActivity.this, "Error  " +t.getMessage(), Toast.LENGTH_SHORT).show();
                   Log.e("Error  "," " +t.getMessage());
            }
        });
    }*/

    private void checkIssued() {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e("", "Login Response: " + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    String content = jObj.getString("content");
                    Log.e("postissues", "onResponse: "+content );

                    Toast.makeText(getApplicationContext(),
                            ""+content, Toast.LENGTH_LONG).show();

                    if(content.equalsIgnoreCase("List di database kosong") || content.equalsIgnoreCase("Gagal issued")){


                    }else{
                        Intent intent = new Intent(PostIssuedActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    //}


                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Log.e("TAG", "onResponse: "+e.getMessage() );
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("", "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();

                params.put("DOC_DATE", date1);
                params.put("PSTNG_DATE", date2);
                params.put("HEADER_TXT", etHeaderText.getText().toString());
                params.put("RESERV_NO", norsv);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(strReq);
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
