package com.semenindonesia.sisi.warehouseautomation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import config.ConnectionList;
import model.Connection;

public class ConnectionSettingActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    final Context context = this;
    Button button15;
    List<Connection> connections;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mFirebaseReference;

    ListView listAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_setting);



//        mRecyclerView = (RecyclerView) findViewById(R.id.rv_connection_setting);

        connections = new ArrayList<>();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseReference = mFirebaseDatabase.getReference();


        button15 = (Button) findViewById(R.id.button15);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectionSettingActivity.this, AddConnectionSettingActivity.class);
                startActivity(intent);
            }
        });

    }
}
