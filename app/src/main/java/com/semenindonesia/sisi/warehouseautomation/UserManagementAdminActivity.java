package com.semenindonesia.sisi.warehouseautomation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import helper.RealmHelper;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import model.UserModel;

public class UserManagementAdminActivity extends AppCompatActivity {
    final Context context = this;
    Button btnAdd, btnTest;
    CheckBox cbTest;


    private static final String TAG = "UserManagementActivity";


    private RecyclerView recyclerView;
    private RealmHelper helper;
    private ArrayList<UserModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management_admin);

        data = new ArrayList<>();
        helper = new RealmHelper(UserManagementAdminActivity.this);


        recyclerView = (RecyclerView) findViewById(R.id.rvUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.activity_add_user_management, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);


                alertDialogBuilder.setView(promptsView);
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Save",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });
    }
   /* public void spinner(){
        Spinner spinner;
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        List<String> list = new ArrayList<String>();
        list.add("Admin");
        list.add("Operator");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
*/
   /* public void cbTest(){
        btnTest = (Button) findViewById(R.id.btnTest);
        CheckBox someCheckBox= (CheckBox) findViewById (R.id.cbTest);
        someCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    btnTest.setEnabled(false);
                } else {
                    //CODE TO MAKE THE EDITTEXT DISABLED
//                    password.setEnabled(false);

                }
            }
        });

    }*/
}
