package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Button seeker=(Button) findViewById(R.id.SeekerBtn);
        Button recruiter=(Button) findViewById(R.id.recruiterBtn);

        seeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Launcher.this,MainActivity.class);
                i.putExtra("Table Name","jobSeeker");
                startActivity(i);

            }
        });
        recruiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Launcher.this,MainActivity.class);
                i.putExtra("Table Name","Recruiter");
                startActivity(i);

            }
        });
    }
}