package com.example.jobportal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class AvailableJobOffers extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<jobVacancy> list;
    RecyclerViewAdapter adapter;
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

        adapter=new RecyclerViewAdapter(this,list,username);
        recyclerView.setAdapter(adapter);

    }
}