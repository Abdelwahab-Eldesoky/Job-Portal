package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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
        System.out.println("Add vacancy Username "+UserName);

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
                System.out.println("userName "+UserName);
                jobVacancy vacancy=new jobVacancy(Integer.parseInt(jobId.getText().toString()),jobTittle.getText().toString(), type,  Integer.parseInt(ExpNeeded.getText().toString()), companyName.getText().toString(), companyMail.getText().toString(), companyAddress.getText().toString(), UserName,jobDesription.getText().toString());


                System.out.println("recruiterName is "+ vacancy.getRecruiterName());
                database.addVacancy(vacancy);
                Toast.makeText(getApplicationContext(),"Application added Successfully",Toast.LENGTH_LONG).show();
                Intent i = new Intent(AddVacancy.this,home_recruiter.class);
                i.putExtra("userName",UserName);
                startActivity(i);

            }
        });

    }
}