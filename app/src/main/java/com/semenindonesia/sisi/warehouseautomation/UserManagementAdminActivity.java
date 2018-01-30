package com.semenindonesia.sisi.warehouseautomation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import database.Users;
import de.mrapp.android.dialog.WizardDialog;
import fragment.AddUserManagement;
import fragment.Filter_Movtype;
import database.RealmHelper;
import helper.User;
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
    Realm realm;

    String user,pass,role;

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management_admin);

/*
        data = new ArrayList<>();
        helper = new RealmHelper(UserManagementAdminActivity.this);
*/
        recyclerView = (RecyclerView) findViewById(R.id.rvUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnAdd = (Button) findViewById(R.id.btnAdd);

        Realm.init(this);
        realm=Realm.getDefaultInstance();
        helper = new RealmHelper(UserManagementAdminActivity.this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                WizardDialog.Builder dialogBuilder = new WizardDialog.Builder(UserManagementAdminActivity.this);
                dialogBuilder.addFragment("", AddUserManagement.class);
                dialogBuilder.showHeader(false);
//                dialogBuilder.setHeaderBackground(R.drawable.semensi);
                dialogBuilder.setHeaderIcon(R.drawable.semensi);
                dialogBuilder.setFinishButtonText("Save");
                dialogBuilder.showHeader(false);
                dialogBuilder.setFullscreen(false);
                dialogBuilder.setHeight(400);
                dialogBuilder.setMaxHeight(500);
                dialogBuilder.setCancelable(true);
                dialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        user = AddUserManagement.usernametxt;
                        pass = AddUserManagement.passwordtxt;
                        role = AddUserManagement.role;
                        Log.e(TAG, "onDismiss: "+user+pass+role);
                        realm.beginTransaction();

                        helper.addUser(user,pass,"",role);

                        realm.commitTransaction();
                    }
                });
                WizardDialog dialog = dialogBuilder.create();
                dialog.show(getSupportFragmentManager(),"test");
            }
        });

    }




}
