package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeSeeker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_seeker);

        Button userInfo = (Button) findViewById(R.id.button5);
        Button logoutBtn = (Button) findViewById(R.id.btnLogOut);
        Button showOffers = (Button) findViewById(R.id.add_btn);
        Button seeApplications = (Button) findViewById(R.id.button4);

        Intent intent = getIntent();
        String username = intent.getStringExtra("userName");

        TextView welcomeSeeker = (TextView) findViewById(R.id.TxtWelcomSeeker);
        welcomeSeeker.setText("Welcome " + username);

        userInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeSeeker.this, UpdateSeekerInfo.class);
                i.putExtra("userName", username);
                startActivity(i);

            }
        });


        showOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeSeeker.this, AvailableJobOffers.class);
                i.putExtra("userName", username);
                startActivity(i);
            }
        });

        seeApplications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeSeeker.this, ShowApplicationHistory.class);
                i.putExtra("userName", username);
                startActivity(i);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeSeeker.this, Launcher.class);
                startActivity(i);
            }
        });
    }
}