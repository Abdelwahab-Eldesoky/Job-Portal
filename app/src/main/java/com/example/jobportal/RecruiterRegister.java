package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RecruiterRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_register);
        EditText name =(EditText) findViewById(R.id.txt_Name);
        EditText username =(EditText) findViewById(R.id.usernameTxt);
        EditText password =(EditText) findViewById(R.id.passwordTxt);

        final PortalDB database=new PortalDB(this);

        Intent intent=getIntent();
        intent.getStringExtra("UserName");

        Button register=(Button) findViewById(R.id.Register_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recruiter recruiter = new Recruiter();
                recruiter.Register(database,name.getText().toString(),username.getText().toString(),password.getText().toString());
                Intent intent=new Intent(RecruiterRegister.this,home_recruiter.class);
                intent.putExtra("UserName",username.getText().toString());
                System.out.println("After Registery "+ username.getText().toString());
                startActivity(intent);

            }
        });

    }
}