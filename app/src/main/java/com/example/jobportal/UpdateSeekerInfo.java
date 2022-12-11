package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

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



    /*public void fillData(String name, String username, String phoneNumber, String mail, String major, String uniName, int gradYear, String gradState, String address, String gender, int yearsOfExp) {
        nameLbl.setText(name);
        usernameLbl.setText(username);
        genderLbl.setText(gender);

        phoneTxt.setHint(phoneNumber);
        emailTxt.setHint(mail);
        addressTxt.setHint(address);
        majorTxt.setHint(major);
        universityTxt.setHint(uniName);
        gradYearTxt.setHint(gradYear);
        yearsOfExpTxt.setHint(yearsOfExp);

        if (gradState.equals("graduate")) {
            underGradRdb.setEnabled(false);
            graduatedRdb.setEnabled(true);
        } else {
            graduatedRdb.setEnabled(false);
            underGradRdb.setEnabled(true);
        }
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_seeker_info);
        final PortalDB database=new PortalDB(this);

        ArrayList<String> tobeUpdated =new ArrayList<>();
        ArrayList<String> values =new ArrayList<>();
        ArrayList<EditText> boxes=new ArrayList<>();


        Intent i = getIntent();
        String username=i.getStringExtra("userName");

        HashMap<String,String> userData =database.getUserInfo(username);

        TextView nameLbl = (TextView) findViewById(R.id.lblSeekerName);
        nameLbl.setText(userData.get("name"));

        TextView usernameLbl = (TextView) findViewById(R.id.lblSeekerUsername);
        usernameLbl.setText(userData.get("UserName"));

        TextView genderLbl = (TextView) findViewById(R.id.lblSeekerGender);
        genderLbl.setText(userData.get("gender"));

        EditText passwordTxt = (EditText) findViewById(R.id.txtPassword);
        passwordTxt.setHint(userData.get("password"));

        EditText phoneTxt = (EditText) findViewById(R.id.txtPhone);
        phoneTxt.setHint(userData.get("phone"));

        EditText emailTxt = (EditText) findViewById(R.id.txtMail);
        emailTxt.setHint(userData.get("mail"));

        EditText addressTxt = (EditText) findViewById(R.id.txtAddress);
        addressTxt.setHint(userData.get("address"));

        EditText majorTxt = (EditText) findViewById(R.id.txtMajor);
        majorTxt.setHint(userData.get("major"));

        EditText universityTxt = (EditText) findViewById(R.id.txtUniversity);
        universityTxt.setHint(userData.get("uniName"));

        EditText gradYearTxt = (EditText) findViewById(R.id.txtGradYear);
        gradYearTxt.setHint(userData.get("gradYear"));

        EditText yearsOfExpTxt = (EditText) findViewById(R.id.txtYearsOfExperience);
        yearsOfExpTxt.setHint(userData.get("yearsOfExp"));

        //Setting Edittexts with value

        RadioGroup gradStateGrp = (RadioGroup) findViewById(R.id.grpGradState);


        RadioButton graduatedRdb = (RadioButton) findViewById(R.id.rdbGraduate);
        RadioButton underGradRdb = (RadioButton) findViewById(R.id.rdbUnderGrad);
        if(userData.get("gradState")=="Graduated"){
            graduatedRdb.setChecked(true);
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
        EditText Graduate = new EditText(this);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //To be implemented
                if(graduatedRdb.isChecked()){
                    Graduate.setHint("Graduated");
                    boxes.add(Graduate);
                }
                else{
                    Graduate.setHint("Undergraduate");
                    boxes.add(Graduate);
                }

                tobeUpdated.add("gradState");

                database.updateInformaation(username,boxes,tobeUpdated);

            }
        });

    }
}