package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

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
        AllApplicantsRecyclerViewAdapter applicantsAdapter;

        username=getIntent().getStringExtra("userName");
        listOfOffers=database.showJobs(username);

        applicantsAdapter=new AllApplicantsRecyclerViewAdapter(this,listOfApplicants,username);
        recyclerView.setAdapter(applicantsAdapter);

        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,listOfOffers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                listOfApplicants=database.showApplicants(Integer.parseInt(spinner.getSelectedItem().toString()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Toast.makeText(getApplicationContext(),"select Job Offer",Toast.LENGTH_LONG).show();

            }
        });





    }
}