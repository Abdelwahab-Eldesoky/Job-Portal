package com.example.jobportal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllApplicantsRecyclerViewAdapter extends RecyclerView.Adapter<AllApplicantsRecyclerViewAdapter.MyViewHolder> {
    @NonNull
    @Override
    public AllApplicantsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_applicant, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllApplicantsRecyclerViewAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView seekerNameLbl,jobTittleLbl,studyLbl,gradYearLbl,gradStateLbl,yearsOfExpLbl,mailLbl,phoneLbl,genderLbl;
        Button rejectBtn,acceptBtn;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            seekerNameLbl=itemView.findViewById(R.id.lblSeekerName);
            jobTittleLbl=itemView.findViewById(R.id.lblAppliedJob);
            studyLbl=itemView.findViewById(R.id.lblMajorUniversity);
            gradYearLbl=itemView.findViewById(R.id.lblGradYear);
            gradStateLbl=itemView.findViewById(R.id.lblGradState);
            yearsOfExpLbl=itemView.findViewById(R.id.lblYearsOfExperience);
            mailLbl=itemView.findViewById(R.id.lblMail);
            phoneLbl=itemView.findViewById(R.id.lblPhone);
            genderLbl=itemView.findViewById(R.id.lblGender);

            rejectBtn=itemView.findViewById(R.id.btnReject);
            acceptBtn=itemView.findViewById(R.id.btnAccept);


        }
    }
}
