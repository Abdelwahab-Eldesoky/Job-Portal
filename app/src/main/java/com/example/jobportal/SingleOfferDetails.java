package com.example.jobportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        Button apply = (Button) findViewById(R.id.apply_btn);
        final PortalDB database = new PortalDB(this);

        int position = 0;

        for (int i = 0; i < AvailableJobOffers.list.size(); i++) {
            if (AvailableJobOffers.list.get(i).getVacancyID() == getIntent().getIntExtra("jobId", 0)) {
                position = i;
            }
        }

        String username = getIntent().getStringExtra("userName");
        System.out.println("single offer " + username);

        String formatCompAndAdress = AvailableJobOffers.list.get(position).getCompName() + " - " + AvailableJobOffers.list.get(position).getCompAddress();
        String formatYearsOfExp = String.valueOf(AvailableJobOffers.list.get(position).getExpNeeded()) + " Years";
        jobTittle.setText(AvailableJobOffers.list.get(position).getTittle());
        jobID.setText(String.valueOf(AvailableJobOffers.list.get(position).getVacancyID()));
        jobDesc.setText(AvailableJobOffers.list.get(position).getDescription());
        jobType.setText(AvailableJobOffers.list.get(position).getJobType());
        compMail.setText(AvailableJobOffers.list.get(position).getCompMail());
        companyAndAddress.setText(formatCompAndAdress);
        recruiterName.setText(AvailableJobOffers.list.get(position).getRecruiterName());
        yearsOfExperience.setText(formatYearsOfExp);


        int pos = position;
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.addApplication(username, AvailableJobOffers.list.get(pos).getVacancyID());
                database.setApplicationState(username, "Pending", AvailableJobOffers.list.get(pos).getVacancyID());
                Toast.makeText(getApplicationContext(), "Applied Successfully", Toast.LENGTH_LONG).show();
                Intent i = new Intent(SingleOfferDetails.this, AvailableJobOffers.class);
                i.putExtra("userName", username);
                startActivity(i);

            }
        });


    }
}