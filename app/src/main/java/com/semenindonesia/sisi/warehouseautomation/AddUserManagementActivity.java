package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddUserManagementActivity extends AppCompatActivity {

    CheckBox checkBox;
    EditText password;
    Button save;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_management);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        password = (EditText) findViewById(R.id.password);

        checkBox.setChecked(true);
        password.setVisibility(View.INVISIBLE);

        List<String> spinnerArray =  new ArrayList<String>();
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
    }
}
