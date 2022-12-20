package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecruiterRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_register);
        EditText name = (EditText) findViewById(R.id.txtName);
        EditText username = (EditText) findViewById(R.id.txtUsername);
        EditText password = (EditText) findViewById(R.id.txtPassword);

        Button backBtn=(Button) findViewById(R.id.backBtn);

        final PortalDB database = new PortalDB(this);

        Intent intent = getIntent();
        intent.getStringExtra("UserName");

        Button register = (Button) findViewById(R.id.btnRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean exists;
                Recruiter recruiter = new Recruiter();
                exists = recruiter.Register(database, name.getText().toString(), username.getText().toString(), password.getText().toString());
                if (exists) {
                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RecruiterRegister.this, home_recruiter.class);
                    intent.putExtra("userName", username.getText().toString());
                    System.out.println("After Registery " + username.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Username already exists", Toast.LENGTH_LONG).show();
                }

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RecruiterRegister.this,home_recruiter.class);
                i.putExtra("userName",username.getText().toString());
                startActivity(i);
            }
        });


    }
}