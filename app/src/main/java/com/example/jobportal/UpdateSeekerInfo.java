package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UpdateSeekerInfo extends AppCompatActivity {

    TextView nameLbl = (TextView) findViewById(R.id.lblSeekerName);
    TextView usernameLbl = (TextView) findViewById(R.id.lblSeekerUsername);
    TextView genderLbl = (TextView) findViewById(R.id.lblSeekerGender);

    EditText passwordTxt = (EditText) findViewById(R.id.txtPassword);
    EditText phoneTxt = (EditText) findViewById(R.id.txtPhone);
    EditText emailTxt = (EditText) findViewById(R.id.txtMail);
    EditText addressTxt = (EditText) findViewById(R.id.txtAddress);
    EditText majorTxt = (EditText) findViewById(R.id.txtMajor);
    EditText universityTxt = (EditText) findViewById(R.id.txtUniversity);
    EditText gradYearTxt = (EditText) findViewById(R.id.txtGradYear);
    EditText yearsOfExpTxt = (EditText) findViewById(R.id.txtYearsOfExperience);

    RadioGroup gradStateGrp = (RadioGroup) findViewById(R.id.grpGradState);

    RadioButton graduatedRdb = (RadioButton) findViewById(R.id.rdbGraduate);
    RadioButton underGradRdb = (RadioButton) findViewById(R.id.rdbUnderGrad);

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

    public void fillData(String name, String username, String phoneNumber, String mail, String major, String uniName, int gradYear, String gradState, String address, String gender, int yearsOfExp) {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_seeker_info);
        //fill user data here call fillData()
        //

        //onClick functions
        passwordEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordTxt.setEnabled(true);
            }
        });

        phoneEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneTxt.setEnabled(true);
            }
        });

        emailEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailTxt.setEnabled(true);
            }
        });

        addressEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addressTxt.setEnabled(true);
            }
        });

        majorEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                majorTxt.setEnabled(true);
            }
        });

        universityEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                universityTxt.setEnabled(true);
            }
        });

        gradYearEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradYearTxt.setEnabled(true);
            }
        });

        yearsOfExpEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yearsOfExpTxt.setEnabled(true);
            }
        });

        gradStateEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradStateGrp.setEnabled(true);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To be implemented
            }
        });

    }
}