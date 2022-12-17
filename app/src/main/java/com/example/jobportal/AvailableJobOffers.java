package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AvailableJobOffers extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<jobVacancy> list;
    AllOffersRecyclerViewAdapter adapter;
    final PortalDB database=new PortalDB(this);
    String username;
    EditText searchTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_job_offers);

        username=getIntent().getStringExtra("userName");

        searchTxt=(EditText)findViewById(R.id.txtSearch);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=database.ShowAllVacancies();

        adapter=new AllOffersRecyclerViewAdapter(this,list,username);
        recyclerView.setAdapter(adapter);

        searchTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<jobVacancy> tmpList=new ArrayList<>();
                if (TextUtils.isEmpty(searchTxt.getText().toString())){
                    adapter=new AllOffersRecyclerViewAdapter(getApplicationContext(),list,username);
                    recyclerView.setAdapter(adapter);
                }
                else{
                    for(jobVacancy vacancy:list){
                        if(vacancy.getTittle().toLowerCase(Locale.ROOT).contains(searchTxt.getText().toString().toLowerCase(Locale.ROOT))){
                            tmpList.add(vacancy);
                        }
                    }
                    adapter=new AllOffersRecyclerViewAdapter(getApplicationContext(),tmpList,username);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}