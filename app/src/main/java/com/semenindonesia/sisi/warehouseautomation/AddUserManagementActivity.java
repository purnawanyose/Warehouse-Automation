package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddUserManagementActivity extends AppCompatActivity {

    CheckBox checkBox;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_management);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        password = (EditText) findViewById(R.id.password);


        setCheckBoxListener();

    }

    private void setCheckBoxListener() {
        checkBox = (CheckBox) findViewById(R.id.checkBox);
       checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (checkBox.isChecked()){
                   password.setVisibility(View.INVISIBLE);
               }
           }
       });
    }
}
