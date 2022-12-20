package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home_recruiter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_recruiter);
        Intent intent=getIntent();
        String username=intent.getStringExtra("userName");
        System.out.println("home Recruiter "+username);

        Button logoutBtn=(Button) findViewById(R.id.btnLogOutrec);
        Button addVacancyBtn=(Button) findViewById(R.id.add_btn);
        Button showApplicantsBtn=(Button) findViewById(R.id.btnShowApplicants);
        TextView welcomeRecruiter=(TextView)findViewById(R.id.txtWelcomRecruiter);
        welcomeRecruiter.setText("Welcome "+username);


        addVacancyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home_recruiter.this,AddVacancy.class);
                i.putExtra("userName",username);
                startActivity(i);

            }
        });

        showApplicantsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(home_recruiter.this,ShowApplicants.class);
                i.putExtra("userName",username);
                startActivity(i);
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(home_recruiter.this,Launcher.class);
                i.putExtra("userName",username);
                startActivity(i);
            }
        });
    }
}