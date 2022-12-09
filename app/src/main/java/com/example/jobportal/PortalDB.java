package com.example.jobportal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PortalDB extends SQLiteOpenHelper {
    private static String databaseName="PortalDb";
    SQLiteDatabase PortalDb;
    public PortalDB(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("create DB");
        db.execSQL("create table jobSeeker (UserName text primary key,phone text , password text not null, name text not null , mail text not null , major text not null, uniName text not null , gradYear integer not null ,gradState text not null,address text,yearsOfExp integer not null )");

        db.execSQL("create table Recruiter(UserName text primary key, name text,password text not null)");

        db.execSQL("Create table jobVacancy(vacancyID integer primary key autoincrement , tittle text not null , jobType text not null , expNeeded integer, compName text ,compMail text, compAddress text,RecruiterUsername text,Foreign key(RecruiterUsername) References Recruiter(UserName))");


        db.execSQL("create table applications(SeekerSSN integer,JobID integer,Foreign key(SeekerSSN) References jobSeeker(SSN) , Foreign key(JobID) References JobVacancy(vacancyID) )");

    }
    public void addSeeker(jobSeeker seek){
        ContentValues row=new ContentValues();
        row.put("phone",seek.getPhoneNumber());
        row.put("UserName",seek.getUsername());
        row.put("password",seek.getPassword());
        row.put("name",seek.getName());
        row.put("mail",seek.getMail());
        row.put("major",seek.getMajor());
        row.put("uniName",seek.getUniName());
        row.put("gradYear",seek.getGradYear());
        row.put("gradState",seek.getGradState());
        row.put("address",seek.getAddress());
        row.put("yearsOfExp",seek.getYearsOfExp());
        PortalDb=getWritableDatabase();
        PortalDb.insert("jobSeeker",null,row);
        PortalDb.close();
    }


    public void addVacancy(jobVacancy vacancy){
        ContentValues row=new ContentValues();
        row.put("tittle",vacancy.getTittle());
        row.put("jobType",vacancy.getJobType());
        row.put("expNeeded",vacancy.getExpNeeded());
        row.put("compName",vacancy.getCompName());
        row.put("compMail",vacancy.getCompMail());
        row.put("compAddress",vacancy.getCompAddress());
        //row.put("RecruiterUsername",seek.getYearsOfExp());
        PortalDb=getWritableDatabase();
        PortalDb.insert("jobSeeker",null,row);
        PortalDb.close();
    }


    public String validateSeekerData(String tableName,String userName , String password){
        PortalDb=getReadableDatabase();
        String[] rawdetails={"UserName"};
        String[] args={userName,password};
        Cursor c=PortalDb.query(tableName,rawdetails,"UserName=? and password = ?",args ,null,null,null);

        String UserName = "Not Found";
        if(c!=null){
            c.moveToFirst();
            if(c.getCount()>0){
                UserName= c.getString(0);
            }

        }
        PortalDb.close();

        System.out.println("UserName"+UserName);
        return UserName;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS jobSeeker");
        onCreate(db);
    }
}
