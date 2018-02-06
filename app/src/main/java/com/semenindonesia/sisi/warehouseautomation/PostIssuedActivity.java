package com.semenindonesia.sisi.warehouseautomation;

import android.app.DatePickerDialog;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import model.Content;
import model.ContentIssued;
import model.Issued;
import model.OnHandLocation;
import model.Reservation;
import response.IssuedResponse;
import response.ReservationDetailResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
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
                postRetrofit();
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
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void postRetrofit(){
        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<IssuedResponse> call = apiService.setGoodIssued
                (date2,date1,etHeaderText.getText().toString(),"YORAMZI",plant,bwart,nilaiInput,norsv,rspos,lgort,val_type,specialStock,wbs_elem);

        Log.e("TEST ISSUED", "postRetrofit: "+date1);
        Log.e("TEST ISSUED", "postRetrofit: "+date2);
        Log.e("TEST ISSUED", "postRetrofit: "+etHeaderText.getText());
        Log.e("TEST ISSUED", "postRetrofit: "+"YORAMZI");
        Log.e("TEST ISSUED", "postRetrofit: "+plant);
        Log.e("TEST ISSUED", "postRetrofit: "+bwart);
        Log.e("TEST ISSUED", "postRetrofit: "+nilaiInput);
        Log.e("TEST ISSUED", "postRetrofit: "+norsv);
        Log.e("TEST ISSUED", "postRetrofit: "+rspos);
        Log.e("TEST ISSUED", "postRetrofit: "+lgort );
        Log.e("TEST ISSUED", "postRetrofit: "+wbs_elem );
        Log.e("TEST ISSUED", "postRetrofit: "+val_type );
        Log.e("TEST ISSUED", "postRetrofit: "+specialStock );



//        ("20180108","20180110","Azmi","Coba Ramzi","7702","961","4","52165269","1","W201","","","");
        Log.wtf("URL Called", call.request().url() + "");
        call.enqueue(new Callback<IssuedResponse>() {

            @Override
            public void onResponse(Call<IssuedResponse> call, Response<IssuedResponse> response) {

                Toast.makeText(PostIssuedActivity.this,"DONE \n Transaction Succes with" +
                        "document number : "+date1,Toast.LENGTH_LONG).show();
                Log.e("Test Sukses", "onResponse: "+date1);

                  /*  if(data.getSuccess() != null){
                        for (Issued dataList : content)

                        Toast.makeText(PostIssuedActivity.this,"DONE \n Transaction Succes with" +
                                "document number : "+data.getMATDOC()+"\n"+data.getDOCYEAR(),Toast.LENGTH_LONG).show();
                         Log.e("Test Sukses", "onResponse: "+data.getMATDOC());
                    }else{
                        Log.e("Test error brom", "onResponse: "+data.getMATDOC());
                    }*/

            }
            @Override
            public void onFailure(Call<IssuedResponse> call, Throwable t) {
                Toast.makeText(PostIssuedActivity.this, "FAILED \n"
                        +"TYPE : \n"
                        +"ID : \n"
                        +"NUMBER : \n"
                        +"MESSAGE : \n"
                        + "Does Not Exist", Toast.LENGTH_SHORT).show();
                Log.e("TEST ERROR", "onFailure: "+apiService);
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
