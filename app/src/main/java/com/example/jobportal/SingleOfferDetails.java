package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SingleOfferDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_offer_details);

        TextView jobTittle = (TextView) findViewById(R.id.lblJobTitle);
        TextView jobID = (TextView) findViewById(R.id.lblJobId);
        TextView jobDesc = (TextView) findViewById(R.id.lblJobDesc);
        TextView jobType = (TextView) findViewById(R.id.lblJobType);
        TextView compMail = (TextView) findViewById(R.id.lblCompanyMail);
        TextView companyAndAddress = (TextView) findViewById(R.id.lblCompAndAddress);
        TextView recruiterName = (TextView) findViewById(R.id.lblRecruiterName);
        TextView yearsOfExperience = (TextView) findViewById(R.id.lblYearsOfExperience);

        int position = getIntent().getIntExtra("position", 0);

        String username=getIntent().getStringExtra("username");

        String formatCompAndAdress = AvailableJobOffers.list.get(position).getCompName() + " - " + AvailableJobOffers.list.get(position).getCompAddress();
        String formatYearsOfExp=String.valueOf(AvailableJobOffers.list.get(position).getExpNeeded())+" Years";
        jobTittle.setText(AvailableJobOffers.list.get(position).getTittle());
        jobID.setText(String.valueOf(AvailableJobOffers.list.get(position).getVacancyID()));
        jobDesc.setText(AvailableJobOffers.list.get(position).getDescription());
        jobType.setText(AvailableJobOffers.list.get(position).getJobType());
        compMail.setText(AvailableJobOffers.list.get(position).getCompMail());
        companyAndAddress.setText(formatCompAndAdress);
        recruiterName.setText(AvailableJobOffers.list.get(position).getRecruiterName());
        yearsOfExperience.setText(formatYearsOfExp);

        //AvailableJobOffers.list.get(position).getVacancyID()

    }
}