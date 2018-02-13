package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import database.RealmHelper;
import io.realm.Realm;
import model.User;
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
    private DatabaseReference mDatabase;

    String user,pass,role;

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management_admin);


        recycle = (RecyclerView) findViewById(R.id.rvUser);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        recyclerView = (RecyclerView) findViewById(R.id.rvUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnAdd = (Button) findViewById(R.id.btnAdd);

        // Initialize Database
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                User user = dataSnapshot.getValue(User.class);
                // [START_EXCLUDE]
                Log.e(TAG, "onDataChange: "+dataSnapshot.getValue() );
                // [END_EXCLUDE]
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
                Toast.makeText(UserManagementAdminActivity.this, "Failed to load post.",
                        Toast.LENGTH_SHORT).show();
                // [END_EXCLUDE]
            }
        };
        mDatabase.addValueEventListener(postListener);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserManagementAdminActivity.this, AddUserManagementActivity.class );
                startActivity(intent);
            }
        });

      /*  view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                Management_User_Rv recyclerAdapter = new Management_User_Rv(list,UserManagementAdminActivity.this);
                RecyclerView.LayoutManager recyce = new GridLayoutManager(UserManagementAdminActivity.this,2);
                recycle.setLayoutManager(recyce);
                recycle.setItemAnimator(new DefaultItemAnimator());
                recycle.setAdapter(recyclerAdapter);
                return false;
            }
        });*/
    }
}
