package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        TextView seeker=(TextView) findViewById(R.id.lblSeeker);
        TextView recruiter=(TextView) findViewById(R.id.lblRecruiter);

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