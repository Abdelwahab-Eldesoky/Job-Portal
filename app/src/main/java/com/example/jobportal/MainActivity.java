package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText usernametext = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText passwordtext = (EditText) findViewById(R.id.editTextTextPersonName2);

        Button login = (Button) findViewById(R.id.button);
        Button tolauncherBtn = (Button) findViewById(R.id.btnToLauncher);

        final PortalDB database = new PortalDB(this);

        Intent intent = getIntent();
        String tableName = intent.getStringExtra("Table Name");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User;
                String userName = usernametext.getText().toString();
                String password = passwordtext.getText().toString();
                User = jobSeeker.login(tableName, database, userName, password);

                if (User.equals("Not Found")) {
                    Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_LONG).show();

                    if (tableName.equals("jobSeeker")) {

                        Intent i = new Intent(MainActivity.this, HomeSeeker.class);
                        i.putExtra("userName", User);
                        startActivity(i);

                    } else {
                        Intent i = new Intent(MainActivity.this, home_recruiter.class);
                        i.putExtra("userName", User);
                        startActivity(i);
                    }
                }

            }
        });

        TextView lblRegister = (TextView) findViewById(R.id.lblRegister);
        lblRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tableName.equals("jobSeeker")) {
                    Intent intent = new Intent(MainActivity.this, ResgisterActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, RecruiterRegister.class);
                    startActivity(intent);
                }
            }

        });

        tolauncherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Launcher.class);
                startActivity(i);
            }
        });

    }
}