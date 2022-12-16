package com.example.jobportal;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApplicationsHistoryRecyclerViewAdapter extends RecyclerView.Adapter<ApplicationsHistoryRecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Pair<String,String>> list;
    String username;

    public ApplicationsHistoryRecyclerViewAdapter(Context context, List<Pair<String, String>> list, String username) {
        this.context = context;
        this.list = list;
        this.username = username;
    }

    @NonNull
    @Override
    public ApplicationsHistoryRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_history, parent, false);
        return new ApplicationsHistoryRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationsHistoryRecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.jobName.setText(list.get(position).first);
        holder.jobStatus.setText(list.get(position).second);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView jobName, jobStatus;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            jobName=itemView.findViewById(R.id.lblJobTittle);
            jobStatus=itemView.findViewById(R.id.lblJobState);
        }
    }
}
