package com.example.jobportal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AllOffersRecyclerViewAdapter extends RecyclerView.Adapter<AllOffersRecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<jobVacancy> list;
    String username;

    public AllOffersRecyclerViewAdapter(Context context, List<jobVacancy> list, String username) {
        this.context = context;
        this.list = list;
        this.username=username;
    }

    @NonNull
    @Override
    public AllOffersRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllOffersRecyclerViewAdapter.MyViewHolder holder, final int position) {
        int pos=position;
        String tmp = list.get(position).getCompName()+" - "+list.get(position).getCompAddress();
        holder.jobName.setText(list.get(position).getTittle());
        holder.companyANDaddress.setText(tmp);
        holder.jobDesc.setText(list.get(position).getDescription());
        holder.jobType.setText(list.get(position).getJobType());
        holder.jobID.setText(String.valueOf(list.get(position).getVacancyID()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,SingleOfferDetails.class);
                intent.putExtra("position",pos);
                intent.putExtra("userName",username);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView jobName, jobType, jobDesc, jobID, companyANDaddress;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            jobDesc = itemView.findViewById(R.id.txtJobDesc);
            jobName = itemView.findViewById(R.id.txtJobName);
            jobType = itemView.findViewById(R.id.txtJobType);
            jobID = itemView.findViewById(R.id.txtJobId);
            companyANDaddress = itemView.findViewById(R.id.txtCompanyAndAddress);

        }
    }
}
