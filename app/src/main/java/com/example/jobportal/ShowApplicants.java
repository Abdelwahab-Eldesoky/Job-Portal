package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowApplicants extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> listOfOffers;
    List<jobSeeker> listOfApplicants;
    Spinner spinner;
    PortalDB database;
    String username;
    AllApplicantsRecyclerViewAdapter applicantsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_applicants);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        database=new PortalDB(this);

        username=getIntent().getStringExtra("userName");
        listOfOffers=database.showJobs(username);

        Button backBtn=(Button) findViewById(R.id.backBtnApplicants);

        if(listOfOffers.isEmpty()){
            Toast.makeText(getApplicationContext(),"No Jobs Added",Toast.LENGTH_LONG).show();
            Intent i = new Intent(ShowApplicants.this,home_recruiter.class);
            i.putExtra("userName",username);
            startActivity(i);
        }


        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,listOfOffers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        /*listOfApplicants=new ArrayList<>();
        applicantsAdapter=new AllApplicantsRecyclerViewAdapter(getApplicationContext(),listOfApplicants,username);
        recyclerView.setAdapter(applicantsAdapter);*/



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int JobId=Integer.parseInt(spinner.getSelectedItem().toString());
                listOfApplicants=database.showApplicants(JobId);
                applicantsAdapter=new AllApplicantsRecyclerViewAdapter(getApplicationContext(),listOfApplicants,username,JobId);
                recyclerView.setAdapter(applicantsAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Toast.makeText(getApplicationContext(),"select Job Offer",Toast.LENGTH_LONG).show();

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ShowApplicants.this,home_recruiter.class);
                i.putExtra("userName",username);
                startActivity(i);
            }
        });






    }
}