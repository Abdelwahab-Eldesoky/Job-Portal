package com.example.jobportal;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AllApplicantsRecyclerViewAdapter extends RecyclerView.Adapter<AllApplicantsRecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<jobSeeker> list;
    String username;
    int jobID;
    PortalDB database;

    public AllApplicantsRecyclerViewAdapter(Context context, List<jobSeeker> list, String username, int jobID) {
        this.context = context;
        this.list = list;
        this.username = username;
        this.jobID = jobID;
        database = new PortalDB(this.context);
    }

    @NonNull
    @Override
    public AllApplicantsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_applicant, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllApplicantsRecyclerViewAdapter.MyViewHolder holder, int position) {
        int pos = position;
        String tmpStudy = list.get(position).getMajor() + " - " + list.get(position).getUniName();
        String tmpYoE = String.valueOf(list.get(position).getYearsOfExp()) + " Years";
        holder.seekerNameLbl.setText(list.get(position).getName());
        holder.studyLbl.setText(tmpStudy);
        holder.gradYearLbl.setText(String.valueOf(list.get(position).getGradYear()));
        holder.gradStateLbl.setText(list.get(position).getGradState());
        holder.yearsOfExpLbl.setText(tmpYoE);
        holder.mailLbl.setText(list.get(position).getMail());
        holder.genderLbl.setText(list.get(position).getGender());
        holder.phoneLbl.setText(list.get(position).getPhoneNumber());

        holder.acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.setApplicationState(list.get(pos).getUsername()
                        , "Accepted", jobID);
                holder.acceptBtn.setVisibility(View.INVISIBLE);
                holder.rejectBtn.setVisibility(View.INVISIBLE);
                holder.stateLbl.setText("Accepted");
                holder.stateLbl.setTextColor(Color.rgb(0, 255, 0));
            }
        });

        holder.rejectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.setApplicationState(list.get(pos).getUsername(), "Rejected", jobID);
                holder.acceptBtn.setVisibility(View.INVISIBLE);
                holder.rejectBtn.setVisibility(View.INVISIBLE);
                holder.stateLbl.setText("Rejected");
                holder.stateLbl.setTextColor(Color.rgb(255, 0, 0));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView seekerNameLbl, studyLbl, gradYearLbl, gradStateLbl, yearsOfExpLbl, mailLbl, phoneLbl, genderLbl, stateLbl;
        Button rejectBtn, acceptBtn;
        CardView myCard;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            seekerNameLbl = itemView.findViewById(R.id.lblSeekerName);
            studyLbl = itemView.findViewById(R.id.lblMajorUniversity);
            gradYearLbl = itemView.findViewById(R.id.lblGradYear);
            gradStateLbl = itemView.findViewById(R.id.lblGradState);
            yearsOfExpLbl = itemView.findViewById(R.id.lblYearsOfExperience);
            mailLbl = itemView.findViewById(R.id.lblMail);
            phoneLbl = itemView.findViewById(R.id.lblPhone);
            genderLbl = itemView.findViewById(R.id.lblGender);
            stateLbl = itemView.findViewById(R.id.lblState);

            rejectBtn = itemView.findViewById(R.id.btnReject);
            acceptBtn = itemView.findViewById(R.id.btnAccept);

            myCard = itemView.findViewById(R.id.myCardView);


        }
    }
}
