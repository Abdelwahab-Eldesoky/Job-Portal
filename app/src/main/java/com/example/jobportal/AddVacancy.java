package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddVacancy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vacancy);
        EditText jobId = (EditText) findViewById(R.id.job_Id_txt);
        EditText jobTittle = (EditText) findViewById(R.id.job_title_txt);
        EditText ExpNeeded = (EditText) findViewById(R.id.txtExperienceNeeded);
        EditText companyName = (EditText) findViewById(R.id.txtCompName);
        EditText companyMail = (EditText) findViewById(R.id.txtCompMail2);
        EditText companyAddress = (EditText) findViewById(R.id.addressTxt2);
        EditText jobDesription = (EditText) findViewById(R.id.descriptionTxt);


        RadioButton fullTime=(RadioButton) findViewById(R.id.fullTime_rdb);
        RadioButton partTime=(RadioButton) findViewById(R.id.partTime_rdb);

        Button addVacancy=(Button) findViewById(R.id.addVacancy_btn);
        final PortalDB database=new PortalDB(this);
        Intent intent=getIntent();
        String UserName=intent.getStringExtra("userName");

        addVacancy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String type=" ";
                if(fullTime.isChecked()){
                    type="Full Time";
                }
                else if(partTime.isChecked()){
                    type="part Time";
                }
                jobVacancy vacancy=new jobVacancy(Integer.parseInt(jobId.getText().toString()),jobTittle.getText().toString(), type,  Integer.parseInt(ExpNeeded.getText().toString()), companyName.getText().toString(), companyMail.getText().toString(), companyAddress.getText().toString(), UserName,jobDesription.getText().toString());

                database.addVacancy(vacancy);
            }
        });



    }
}