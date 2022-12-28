package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class UpdateSeekerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_seeker_info);
        final PortalDB database=new PortalDB(this);

        ArrayList<String> tobeUpdated =new ArrayList<>();
        ArrayList<EditText> boxes=new ArrayList<>();

        Intent i = getIntent();
        String username=i.getStringExtra("userName");

        jobSeeker seeker=database.getUserInfo(username);

        TextView nameLbl = (TextView) findViewById(R.id.lblSeekerName);
        nameLbl.setText(seeker.getName());

        TextView usernameLbl = (TextView) findViewById(R.id.lblSeekerUsername);
        usernameLbl.setText(seeker.getUsername());

        TextView genderLbl = (TextView) findViewById(R.id.lblSeekerGender);
        genderLbl.setText(seeker.getGender());

        EditText passwordTxt = (EditText) findViewById(R.id.txtPassword);
        passwordTxt.setHint(seeker.getPassword());

        EditText phoneTxt = (EditText) findViewById(R.id.txtPhone);
        phoneTxt.setHint(seeker.getPhoneNumber());

        EditText emailTxt = (EditText) findViewById(R.id.txtMail);
        emailTxt.setHint(seeker.getMail());

        EditText addressTxt = (EditText) findViewById(R.id.txtAddress);
        addressTxt.setHint(seeker.getAddress());

        EditText majorTxt = (EditText) findViewById(R.id.txtMajor);
        majorTxt.setHint(seeker.getMajor());

        EditText universityTxt = (EditText) findViewById(R.id.txtUniversity);
        universityTxt.setHint(seeker.getUniName());

        EditText gradYearTxt = (EditText) findViewById(R.id.txtGradYear);
        gradYearTxt.setHint(String.valueOf(seeker.getGradYear()));

        EditText yearsOfExpTxt = (EditText) findViewById(R.id.txtYearsOfExperience);
        yearsOfExpTxt.setHint(String.valueOf(seeker.getYearsOfExp()));


        RadioGroup gradStateGrp = (RadioGroup) findViewById(R.id.grpGradState);


        Button backBtn=(Button) findViewById(R.id.backBtnUpdateSeeker);

        RadioButton graduatedRdb = (RadioButton) findViewById(R.id.rdbGraduate);
        RadioButton underGradRdb = (RadioButton) findViewById(R.id.rdbUnderGrad);
        if(seeker.getGradState().equals("Graduated")){
            graduatedRdb.setChecked(true);
            underGradRdb.setChecked(false);
        }
        else{
            underGradRdb.setChecked(true);
        }

        Button passwordEditBtn = (Button) findViewById(R.id.btnEditPassword);
        Button phoneEditBtn = (Button) findViewById(R.id.btnEditPhone);
        Button emailEditBtn = (Button) findViewById(R.id.btnEditEmail);
        Button addressEditBtn = (Button) findViewById(R.id.btnEditAddress);
        Button majorEditBtn = (Button) findViewById(R.id.btnEditMajor);
        Button universityEditBtn = (Button) findViewById(R.id.btnEditUniversity);
        Button gradYearEditBtn = (Button) findViewById(R.id.btnEditGradYear);
        Button yearsOfExpEditBtn = (Button) findViewById(R.id.btnEditYearsOfExperience);
        Button gradStateEditBtn = (Button) findViewById(R.id.btnEditGradState);

        Button saveBtn = (Button) findViewById(R.id.btnSave);
        //fill user data here call fillData()
        //
        passwordEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordTxt.setEnabled(true);
                boxes.add(passwordTxt);
                tobeUpdated.add("password");
                saveBtn.setEnabled(true);
            }
        });

        phoneEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneTxt.setEnabled(true);
                boxes.add(phoneTxt);
                tobeUpdated.add("phone");
                saveBtn.setEnabled(true);
            }
        });

        emailEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailTxt.setEnabled(true);
                boxes.add(emailTxt);
                tobeUpdated.add("mail");
                saveBtn.setEnabled(true);
            }
        });

        addressEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addressTxt.setEnabled(true);
                boxes.add(addressTxt);
                tobeUpdated.add("address");
                saveBtn.setEnabled(true);

            }
        });

        majorEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                majorTxt.setEnabled(true);
                boxes.add(majorTxt);
                tobeUpdated.add("major");
                saveBtn.setEnabled(true);
            }
        });

        universityEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                universityTxt.setEnabled(true);
                boxes.add(universityTxt);
                tobeUpdated.add("uniName");
                saveBtn.setEnabled(true);
            }
        });

        gradYearEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradYearTxt.setEnabled(true);
                boxes.add(gradYearTxt);
                tobeUpdated.add("gradYear");
                saveBtn.setEnabled(true);
            }
        });

        yearsOfExpEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yearsOfExpTxt.setEnabled(true);
                boxes.add(yearsOfExpTxt);
                tobeUpdated.add("yearsOfExp");
                saveBtn.setEnabled(true);
            }
        });

        gradStateEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradStateGrp.setEnabled(true);
                saveBtn.setEnabled(true);

            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Graduate;
                //To be implemented
                if(graduatedRdb.isChecked()){
                   Graduate="Graduated";

                }
                else{
                   Graduate= "Undergraduate";

                }
                ContentValues values=new ContentValues();
                for(int i=0;i<tobeUpdated.size();i++){
                    values.put(tobeUpdated.get(i),boxes.get(i).getText().toString());
                }
                values.put("gradState",Graduate);
                database.updateInformaation(username,values);

                Intent i=new Intent(UpdateSeekerInfo.this,HomeSeeker.class);
                i.putExtra("userName",username);
                startActivity(i);

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(UpdateSeekerInfo.this,HomeSeeker.class);
                i.putExtra("userName",username);
                startActivity(i);
            }
        });


    }
}