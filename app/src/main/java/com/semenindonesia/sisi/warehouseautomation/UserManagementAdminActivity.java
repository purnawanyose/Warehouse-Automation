package com.semenindonesia.sisi.warehouseautomation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import config.Management_User_Rv;
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

    FirebaseDatabase database;
    DatabaseReference myRef;
    List<model.User>list;
    RecyclerView recycle;
    Button view;


    String user,pass,role;

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management_admin);


        recycle = (RecyclerView) findViewById(R.id.rvUser);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

/*
        data = new ArrayList<>();
        helper = new RealmHelper(UserManagementAdminActivity.this);
*/
        recyclerView = (RecyclerView) findViewById(R.id.rvUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnAdd = (Button) findViewById(R.id.btnAdd);
        view = (Button) findViewById(R.id.button3);

        Realm.init(this);
        realm=Realm.getDefaultInstance();
        helper = new RealmHelper(UserManagementAdminActivity.this);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<model.User>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    model.User value = dataSnapshot1.getValue(model.User.class);
                    model.User fire = new model.User();

                    String username = value.getUsername();
                    String password = value.getPassword();
                    String role = value.getRole();

                    fire.setUsername(username);
                    fire.setPassword(password);
                    fire.setRole(role);
                    list.add(fire);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "onCancelled: ",databaseError.toException() );

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserManagementAdminActivity.this, AddUserManagementActivity.class );
                startActivity(intent);
            }
        });

        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                Management_User_Rv recyclerAdapter = new Management_User_Rv(list,UserManagementAdminActivity.this);
                RecyclerView.LayoutManager recyce = new GridLayoutManager(UserManagementAdminActivity.this,2);
                recycle.setLayoutManager(recyce);
                recycle.setItemAnimator(new DefaultItemAnimator());
                recycle.setAdapter(recyclerAdapter);
                return false;
            }
        });


    }
}
