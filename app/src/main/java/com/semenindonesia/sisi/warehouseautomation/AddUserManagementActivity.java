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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import fragment.AddUserManagement;
import model.Connection;
import model.User;
import model.UserAdmin;
import model.UserModel;

public class AddUserManagementActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView txtDetails;
    private EditText username, inputEmail;
    private Button btnSave;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mFirebaseReference;

    List<UserAdmin> users;

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

        password = (EditText) findViewById(R.id.passwordUser);
        username = (EditText) findViewById(R.id.username);
        btnSave = (Button) findViewById(R.id.btn_savee);
        spinner = (Spinner) findViewById(R.id.spinner);

        final List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Admin");
        spinnerArray.add("Operator");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

      /*  CheckBox someCheckBox = (CheckBox) findViewById(R.id.checkBox);
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
*/

        users = new ArrayList<>();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseReference = mFirebaseDatabase.getReference("users");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanAgenda();
            }
        });

    }

    public void simpanAgenda() {
        String userN = username.getText().toString();
        String pass = password.getText().toString();
        String role = String.valueOf(spinner.getSelectedItem());

        String id = mFirebaseReference.push().getKey();

        UserAdmin user = new UserAdmin(id, userN, pass, role);

        mFirebaseReference.child(id).setValue(user);
        Toast.makeText(this, "Connection ditambahkan", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(AddUserManagementActivity.this, UserManagementAdminActivity.class);
        startActivity(intent);

    }
}
