package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_recruiter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_recruiter);
        Intent intent=getIntent();
        String UserName=intent.getStringExtra("userName");

        Button addVacancy=(Button) findViewById(R.id.add_btn);

        addVacancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home_recruiter.this,AddVacancy.class);
                i.putExtra("userName",UserName);
                startActivity(i);

            }
        });
    }
}