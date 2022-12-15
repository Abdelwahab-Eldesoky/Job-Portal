package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class AvailableJobOffers extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<jobVacancy> list;
    AllOffersRecyclerViewAdapter adapter;
    final PortalDB database=new PortalDB(this);
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_job_offers);

        username=getIntent().getStringExtra("userName");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=database.ShowAllVacancies();

        adapter=new AllOffersRecyclerViewAdapter(this,list,username);
        recyclerView.setAdapter(adapter);

    }
}