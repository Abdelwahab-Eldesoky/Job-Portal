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

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context cont=this;
        setContentView(R.layout.activity_main);
        EditText usernametext=(EditText)findViewById(R.id.editTextTextPersonName) ;
        EditText passwordtext=(EditText)findViewById(R.id.editTextTextPersonName2) ;
        Button login=(Button) findViewById(R.id.button);
        final PortalDB database=new PortalDB(this);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //jobSeeker seek;
                String seekerSSN;
                String userName=usernametext.getText().toString();
                String password=passwordtext.getText().toString();
                seekerSSN=jobSeeker.login(database,userName,password);
                if(seekerSSN.equals("Not Found") ){
                    Toast.makeText(getApplicationContext(),"User not found",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_LONG).show();
                }

            }
        });

        TextView lblRegister=(TextView) findViewById(R.id.lblRegister);
        lblRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,ResgisterActivity.class);
                startActivity(intent);
            }
        });

    }
}