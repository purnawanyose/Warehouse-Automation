package com.semenindonesia.sisi.warehouseautomation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
import model.UserAdmin;

public class LoginActivity extends AppCompatActivity {
    EditText username,password,editText;
    Button btnLogin;
    Editable aa;

    String usernameKey,passwordKey;
    final Context context = this;
    Button btnAdd, btnTest;
    CheckBox cbTest;
    private static final String TAG = "UserManagementActivity";
    private RecyclerView recyclerView;
    private RealmHelper helper;
    private ArrayList<UserAdmin> data;
    Realm realm;

    public static String pr_uname;


    String userFix, passFix, roleFix, idFix;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<User> list;
    RecyclerView recycle;
    Button view;
    private DatabaseReference mDatabase;

    String user,pass,role;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        recycle = (RecyclerView) findViewById(R.id.rvUser);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        recyclerView = (RecyclerView) findViewById(R.id.rvUser);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        // Initialize Database
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 usernameKey = username.getText().toString();
                 passwordKey= password.getText().toString();

                ValueEventListener postListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        data = new ArrayList<>();
                        for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                            UserAdmin user = noteDataSnapshot.getValue(UserAdmin.class);
                            user.setId(noteDataSnapshot.getKey());
                            Log.e(TAG, "onDataChange1: " + dataSnapshot.getValue());
                            Log.e(TAG, "onDataChange2: " + noteDataSnapshot.getKey());

                            data.add(user);

                        }
                        for (int i = 0; i < data.size(); i++) {
                            userFix = data.get(i).getUsername();
                            passFix = data.get(i).getPassword();
                            idFix = data.get(i).getId();
                            roleFix = data.get(i).getRole();
                            Log.e(TAG, "onDataChange3000: " + userFix);
                            Log.e(TAG, "onDataChange4000: " + passFix);
                            Log.e(TAG, "onDataChange5000: " + roleFix);
                            Log.e(TAG, "onDataChange6000: " + idFix);

                           if(usernameKey.equalsIgnoreCase("")){

                               username.setError("This field is required");

                           }else if(passwordKey.equalsIgnoreCase("")){
                               password.setError("This field is required");

                           }else if (usernameKey.equals(userFix) && passwordKey.equals(passFix) && roleFix.equalsIgnoreCase("Operator")) {
                                Toast.makeText(getApplicationContext(), "LOGIN SUKSES  Denga Userfix Operator", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                Log.e("login", "testtt" + userFix);
                                 pr_uname = userFix;

                            }else if (usernameKey.equals(userFix) && passwordKey.equals(passFix) && roleFix.equalsIgnoreCase("Admin")){
                                Toast.makeText(getApplicationContext(), "LOGIN SUKSES  Denga Userfix Admin", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, AdminInitialPage.class);
                                startActivity(intent);
                                finish();
                                Log.e("login", "testtt" + username.getText());
                                 pr_uname = userFix;
                            }else{
                               Toast.makeText(getApplicationContext(), "Gagal Login !!\nSilahkan Periksa Kembali Username & Password Anda", Toast.LENGTH_SHORT).show();

                           }
                        }
                        // Get Post object and use the values to update the UI
              /*  User user = dataSnapshot.getValue(User.class);
                // [START_EXCLUDE]
                Log.e(TAG, "onDataChange: "+dataSnapshot.getValue());
                Log.e(TAG, "onDataChange: "+user.getPassword().toString());
                // [END_EXCLUDE]*/
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                        // [START_EXCLUDE]
                        Toast.makeText(LoginActivity.this, "Failed to load post.",
                                Toast.LENGTH_SHORT).show();
                        // [END_EXCLUDE]
                    }
                };
                mDatabase.addValueEventListener(postListener);

                /*if(usernameKey.equals("1") && passwordKey.equals("1")) {

                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    Log.e("login", "testtt" + username.getText());
                }else if (usernameKey.equals("2") && passwordKey.equals("2")){
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, AdminInitialPage.class);
                    startActivity(intent);
                    finish();
                    Log.e("login", "testtt" + username.getText());
                }else if (usernameKey.equals("") && passwordKey.equals("")) {
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES Tanpa User Password", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    Log.e("login", "testtt" + username.getText());
                }*/
            }
        });

    }
}
