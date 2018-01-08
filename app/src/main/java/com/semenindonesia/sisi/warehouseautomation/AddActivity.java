package com.semenindonesia.sisi.warehouseautomation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import helper.RealmHelper;

public class AddActivity extends AppCompatActivity {


    private RealmHelper realmHelper;
    private EditText password;
    private EditText username;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_management);


        realmHelper = new RealmHelper(AddActivity.this);


        password = (EditText) findViewById(R.id.password);
        username = (EditText) findViewById(R.id.username);
        save = (Button) findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inisialisasi string
                String usr, psw;

                //mengambil text dr edittext
                usr = username.getText().toString();
                psw = password.getText().toString();

                //menambahkan data pada database
                realmHelper.addArticle(usr, psw);

                //menutup Add Activity
                finish();
                //kembali ke MainActivity
                Intent i = new Intent(AddActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
} 