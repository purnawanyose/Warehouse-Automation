package com.semenindonesia.sisi.warehouseautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckCoba extends AppCompatActivity {
    CheckBox cbTest;
    Button btnTest;
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_coba);

        cbTest = (CheckBox) findViewById(R.id.cbTest);
        btnTest = (Button) findViewById(R.id.btnTest);
        tvTest = (TextView) findViewById(R.id.tvTest);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTest.setText("AAA");

            }
        });

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



    }
}
