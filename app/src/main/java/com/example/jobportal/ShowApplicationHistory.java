package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Pair;

import java.util.List;

public class ShowApplicationHistory extends AppCompatActivity {

    RecyclerView recyclerView;
    String username;
    PortalDB database;
    List<Pair<String, String>> list;
    ApplicationsHistoryRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_application_history);

        database = new PortalDB(this);

        username = getIntent().getStringExtra("userName");

        list = database.showHistory(username);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new ApplicationsHistoryRecyclerViewAdapter(this,list,username);
        recyclerView.setAdapter(adapter);


    }
}