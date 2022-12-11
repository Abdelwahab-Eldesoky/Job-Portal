package com.example.jobportal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class PortalDB extends SQLiteOpenHelper {
    private static String databaseName="PortalDb";
    SQLiteDatabase PortalDb;
    public PortalDB(@Nullable Context context) {
        super(context, databaseName, null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("create DB");
        db.execSQL("create table jobSeeker (UserName text primary key,phone text , password text not null, name text not null , mail text not null , major text not null, uniName text not null , gradYear integer not null ,gradState text not null,address text,yearsOfExp integer not null , gender text)");

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
        row.put("Gender",seek.getGender());
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

    public HashMap<String,String> getUserInfo(String userName){
        //UserName ,phone , password, name , mail , major , uniName , gradYear ,gradState ,address ,yearsOfExp
        PortalDb=getReadableDatabase();
        String[] rawdetails={"name,UserName,password","phone","mail","address","major","uniName","gradYear","yearsOfExp","gradState","gender"};
        String[] args={userName};
        Cursor c=PortalDb.query("jobSeeker",rawdetails,"UserName=?",args ,null,null,null);
        if(c!=null){
            c.moveToFirst();
        }
        System.out.println("tryyyyyyyy "+c.getString(0));
        System.out.println("yarabbbbbbbbbb");
        HashMap<String,String> data=new HashMap<>();
        data.put("name",c.getString(0));
        data.put("UserName",c.getString(1));
        data.put("password",c.getString(2));
        data.put("phone",c.getString(3));
        data.put("mail",c.getString(4));
        data.put("address",c.getString(5));
        data.put("major",c.getString(6));
        data.put("uniName",c.getString(7));
        System.out.println("uniName"+c.getString(7));
        data.put("gradYear",c.getString(8));
        data.put("yearsOfExp",c.getString(9));
        data.put("gradState",c.getString(10));
        data.put("gender",c.getString(11));
        PortalDb.close();
        return data;
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

        System.out.println("UserName "+UserName);
        return UserName;
    }
    public void updateInformaation (String username, ArrayList<EditText> editTexts,ArrayList<String> tobeUpdated){

        PortalDb=getReadableDatabase();
        ContentValues values=new ContentValues();
        for(int i=0;i<tobeUpdated.size();i++){
            values.put(tobeUpdated.get(i),editTexts.get(i).getText().toString());
            System.out.println(tobeUpdated.get(i) + " "+editTexts.get(i).getText().toString());
        }
        PortalDb.update("jobSeeker",values,"UserName=?",new String[]{username});
        PortalDb.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS jobSeeker");
        db.execSQL("DROP TABLE IF EXISTS Recruiter");
        db.execSQL("DROP TABLE IF EXISTS jobVacancy");
        db.execSQL("DROP TABLE IF EXISTS applications");
        onCreate(db);
    }
}
