package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.List;

public class ShowApplicants extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Integer> listOfOffers;
    List<jobSeeker> listOfApplicants;
    Spinner spinner;
    PortalDB database;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_applicants);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        database=new PortalDB(this);

        username=getIntent().getStringExtra("userName");
        listOfOffers=database.showJobs(username);

        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,listOfOffers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);




    }
}