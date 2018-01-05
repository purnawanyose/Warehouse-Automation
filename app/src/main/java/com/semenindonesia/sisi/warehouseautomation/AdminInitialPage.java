package com.semenindonesia.sisi.warehouseautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminInitialPage extends AppCompatActivity {
    Button button20,button12,button14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_initial_page);

        button20 = (Button) findViewById(R.id.button20);
        button12 = (Button) findViewById(R.id.button12);
        button14 = (Button) findViewById(R.id.button14);

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminInitialPage.this, UserManagementAdmin.class );
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminInitialPage.this, ConnectionSettingActivity.class );
                startActivity(intent);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminInitialPage.this, PlantAssigmentActivity.class );
                startActivity(intent);
            }
        });
    }

}
