package com.semenindonesia.sisi.warehouseautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import model.Connection;

public class AddConnectionSettingActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mFirebaseReference;

    List<Connection> connections;
    TextView connectionName,serverIP;
    Button addConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_connection_setting);

        serverIP = (TextView) findViewById(R.id.serverIP);
        connectionName = (TextView) findViewById(R.id.connectionName);
        addConnection = (Button) findViewById(R.id.addConnection);

        connections = new ArrayList<>();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseReference = mFirebaseDatabase.getReference("connection");

        addConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanAgenda();
            }
        });
    }

    public void simpanAgenda() {
        String cName = connectionName.getText().toString();
        String sIP = serverIP.getText().toString();

        String id = mFirebaseReference.push().getKey();

        Connection agenda = new Connection(id, cName, sIP);

        mFirebaseReference.child(id).setValue(agenda);
        Toast.makeText(this, "Connection ditambahkan", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(AddConnectionSettingActivity.this, ConnectionSettingActivity.class);
        startActivity(intent);

    }
}
