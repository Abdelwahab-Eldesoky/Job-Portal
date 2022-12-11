package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class ResgisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister);
        PortalDB db=new PortalDB(this);

        Context cont=this;
        Button regesterBtn=(Button) findViewById(R.id.button);
        System.out.println("1");
        EditText nametext=(EditText) findViewById(R.id.txtName);
        System.out.println("2");
        EditText userNametext=(EditText) findViewById(R.id.txtUsername);
        EditText passwordtext=(EditText) findViewById(R.id.txtPassword);
        EditText phonetext=(EditText) findViewById(R.id.txtPhone);
        EditText mailtext=(EditText) findViewById(R.id.txtMail);
        EditText majortext=(EditText) findViewById(R.id.txtMajor);
        EditText universitytext=(EditText) findViewById(R.id.txtUniversity);
        EditText gradYeartext=(EditText) findViewById(R.id.txtGradYear);
        EditText YearsOfExperiencetext=(EditText) findViewById(R.id.txtYearsOfExperience);
        EditText addresstext=(EditText) findViewById(R.id.txtAddress);
        final PortalDB database=new PortalDB(this);

        regesterBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name=nametext.getText().toString();
                System.out.println("3");
                String userName=userNametext.getText().toString();
                System.out.println("4");
                String password=passwordtext.getText().toString();
                System.out.println("5");
                System.out.println("6");
                String phone=phonetext.getText().toString();
                System.out.println("7");
                String mail=mailtext.getText().toString();
                System.out.println("8");
                String major=majortext.getText().toString();
                System.out.println("9");
                String university=universitytext.getText().toString();
                System.out.println("10");
                int gradYear=Integer.parseInt(gradYeartext.getText().toString());
                System.out.println("11");
                int YearsOfExperience=Integer.parseInt(YearsOfExperiencetext.getText().toString());
                System.out.println("12");
                String address=addresstext.getText().toString();


                RadioButton genderMale=(RadioButton) findViewById(R.id.rdbMale);
                RadioButton genderFemale=(RadioButton) findViewById(R.id.rdbFemale);
                RadioButton graduated=(RadioButton) findViewById(R.id.rdbGraduate);
                RadioButton underGrad=(RadioButton) findViewById(R.id.rdbUnderGrad);

                String gender;
                String gradState;
                if(genderMale.isChecked()){
                    gender="Male";
                }
                else {
                    gender="Female";
                }
                if(graduated.isChecked()){
                    gradState="Graduated";
                }
                else{
                    gradState="Undergraduate";
                }
                jobSeeker seeker=new jobSeeker(cont);
                seeker.Register(database,name, userName,password,phone,mail,major, university,gradYear, gradState,  address, gender,YearsOfExperience);
            }
        });
    }
}