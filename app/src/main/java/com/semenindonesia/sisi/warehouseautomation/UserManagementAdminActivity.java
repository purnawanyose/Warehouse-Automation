package com.semenindonesia.sisi.warehouseautomation;

import android.app.Activity;
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

import adapter.Filter_MovtypeRv;
import config.Management_User_Rv;
import config.ReservationDetailRv;
import config.UserManagementRv;
import database.RealmHelper;
import io.realm.Realm;
import model.MovTypeSelection;
import model.Reservation;
import model.User;
import model.UserAdmin;
import model.UserModel;

public class UserManagementAdminActivity extends AppCompatActivity {
    final Context context = this;
    Button btnAdd, btnTest;
    CheckBox cbTest;
    private static final String TAG = "UserManagementActivity";
    private RecyclerView recyclerView;
    private RealmHelper helper;
    private ArrayList<UserAdmin> dataUser;
    private ArrayList<UserAdmin> datalist;
    Realm realm;

    String userFix, passFix, roleFix, idFix;
    public static String usernameLogin;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<model.User> list;
    RecyclerView recycle;
    Button view;
    private DatabaseReference mDatabase;
    String user, pass, role;
    FragmentManager fm = getSupportFragmentManager();

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management_admin);

        layoutManager = new LinearLayoutManager(this);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");


        btnAdd = (Button) findViewById(R.id.btnAdd);


        recyclerView = (RecyclerView) findViewById(R.id.rvUser);

        // Initialize Database
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                dataUser = new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {

                    UserAdmin user = noteDataSnapshot.getValue(UserAdmin.class);
                    user.setId(noteDataSnapshot.getKey());

                    Log.e(TAG, "onDataChange1: " + dataSnapshot.getValue());
                    Log.e(TAG, "onDataChange2: " + noteDataSnapshot.getKey());

                    dataUser.add(user);

                }


                Log.e("ASDASD", "TESTING USER MANAGEMENT "+dataUser.size());

                datalist =  new ArrayList<UserAdmin>();
                for (int i = 0; i < dataUser.size(); i++) {
                    userFix = dataUser.get(i).getUsername();
                    passFix = dataUser.get(i).getPassword();
                    idFix = dataUser.get(i).getId();
                    roleFix = dataUser.get(i).getRole();

                    UserAdmin userlist= new UserAdmin(idFix,userFix,passFix,roleFix);
                    datalist.add(userlist);

                    Log.e(TAG, "onDataChange3000: " + userFix);
                    Log.e(TAG, "onDataChange4000: " + passFix);
                    Log.e(TAG, "onDataChange5000: " + roleFix);
                    Log.e(TAG, "onDataChange6000: " + idFix);
                    Log.e(TAG, "TESTING USER MANAGEMENT "+datalist.size());
                    Log.e(TAG, "onDataChange: "+dataSnapshot.getValue() );
                }


                adapter = new Management_User_Rv(dataUser);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(UserManagementAdminActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();






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
                Intent intent = new Intent(UserManagementAdminActivity.this, AddUserManagementActivity.class);
                startActivity(intent);
            }
        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, UserManagementAdminActivity.class);
    }
}
