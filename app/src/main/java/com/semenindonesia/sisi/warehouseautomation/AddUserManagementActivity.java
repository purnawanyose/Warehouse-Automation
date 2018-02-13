package com.semenindonesia.sisi.warehouseautomation;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import model.User;
import model.UserModel;

public class AddUserManagementActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView txtDetails;
    private EditText inputName, inputEmail;
    private Button btnSave;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private String userId;

    CheckBox checkBox;
    EditText password;
    Button save;
    Spinner spinner;

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_management);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        password = (EditText) findViewById(R.id.password);
        inputName = (EditText) findViewById(R.id.username);
        inputEmail = (EditText) findViewById(R.id.password);
        btnSave = (Button) findViewById(R.id.btn_savee);
        spinner = (Spinner) findViewById(R.id.spinner);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        checkBox.setChecked(true);
        password.setVisibility(View.INVISIBLE);

        final List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Admin");
        spinnerArray.add("Operator");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        CheckBox someCheckBox= (CheckBox) findViewById (R.id.checkBox);
        someCheckBox.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    password.setVisibility(View.INVISIBLE);
                } else {
                    //CODE TO MAKE THE EDITTEXT DISABLED
                 password.setVisibility(View.VISIBLE);

                }
            }
        });

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Realtime Database");

        // app_title change listener
        mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "App title updated");

                String appTitle = dataSnapshot.getValue(String.class);

                // update toolbar title
//                getSupportActionBar().setTitle(appTitle);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        });
        // Save / update the user
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = inputName.getText().toString();
                String password = inputEmail.getText().toString();
                String role = (String) spinner.getSelectedItem();

                // Check for already existed userId
                if (TextUtils.isEmpty(userId)) {
                    createUser(username, password, role);
                    Intent intent = new Intent(AddUserManagementActivity.this, UserManagementAdminActivity.class );
                    startActivity(intent);
                } else {
                    updateUser(username, password, role);
                }
            }
        });

    }

    /**
     * Creating new user node under 'users'
     */
    private void createUser(String username, String password, String role) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(userId)) {
            userId = mFirebaseDatabase.push().getKey();
        }

        User user = new User(username, password, role);

        mFirebaseDatabase.child(userId).setValue(user);

        addUserChangeListener();
    }

    /**
     * User data change listener
     */
    private void addUserChangeListener() {
        // User data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);

                // Check for null
                if (user == null) {
                    Log.e(TAG, "User data is null!");
                    return;
                }

                Log.e(TAG, "User data is changed!" + user.username + ", " + user.password);

                // Display newly updated name and email
//                txtDetails.setText(user.username + ", " + user.password);

                // clear edit text
                inputEmail.setText("");
                inputName.setText("");

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });
    }

    private void updateUser(String username, String password, String role) {
        // updating the user via child nodes
        if (!TextUtils.isEmpty(username))
            mFirebaseDatabase.child(userId).child("username").setValue(username);

        if (!TextUtils.isEmpty(password))
            mFirebaseDatabase.child(userId).child("password").setValue(password);

        if (!TextUtils.isEmpty(role))
            mFirebaseDatabase.child(userId).child("role").setValue(role);
    }


    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }
}
