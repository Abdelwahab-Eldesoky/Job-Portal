package com.example.jobportal;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;


import androidx.annotation.Nullable;

import java.util.ArrayList;

import java.util.List;

public class PortalDB extends SQLiteOpenHelper {
    private static String databaseName = "PortalDb";
    SQLiteDatabase PortalDb;

    public PortalDB(@Nullable Context context) {
        super(context, databaseName, null, 10);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("create DB");
        db.execSQL("create table jobSeeker (UserName text primary key,phone text , password text not null, name text not null , mail text not null , major text not null, uniName text not null , gradYear integer not null ,gradState text not null,address text,yearsOfExp integer not null , gender text)");

        db.execSQL("create table Recruiter(UserName text primary key, name text,password text not null)");

        db.execSQL("Create table jobVacancy(vacancyID integer primary key  , tittle text not null , jobType text not null , expNeeded integer, compName text ,compMail text, compAddress text,jobDescription text,RecruiterUsername text,Foreign key(RecruiterUsername) References Recruiter(UserName))");


        db.execSQL("create table applications(SeekerUsername text,ApplicationState text,JobID integer,Foreign key(SeekerUsername) References jobSeeker(UserName) , Foreign key(JobID) References JobVacancy(vacancyID),primary key(SeekerUsername,JobID))");
    }

    public String validateData(String tableName, String userName, String password) {
        PortalDb = getReadableDatabase();

        String[] rowdetails = {"UserName"};
        String[] args = {userName, password};
        String UserName = "Not Found";

        Cursor c = PortalDb.query(tableName, rowdetails, "UserName=? and password = ?", args, null, null, null);

        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                UserName = c.getString(0);
            }
        }
        PortalDb.close();

        return UserName;
    }

    public Boolean addSeeker(jobSeeker seek) {
        PortalDb = getReadableDatabase();
        Cursor c = PortalDb.rawQuery("Select name from jobSeeker where UserName=? ", new String[]{seek.getUsername()});
        if (c.getCount() > 0) {
            return false;
        }

        ContentValues row = new ContentValues();
        row.put("phone", seek.getPhoneNumber());
        row.put("UserName", seek.getUsername());
        row.put("password", seek.getPassword());
        row.put("name", seek.getName());
        row.put("mail", seek.getMail());
        row.put("major", seek.getMajor());
        row.put("uniName", seek.getUniName());
        row.put("gradYear", seek.getGradYear());
        row.put("gradState", seek.getGradState());
        row.put("address", seek.getAddress());
        row.put("yearsOfExp", seek.getYearsOfExp());
        row.put("Gender", seek.getGender());
        PortalDb = getWritableDatabase();
        PortalDb.insert("jobSeeker", null, row);
        PortalDb.close();
        return true;
    }

    public void addApplication(String seekUsername, int jobId) {
        ContentValues row = new ContentValues();
        row.put("SeekerUsername", seekUsername);
        row.put("JobID", jobId);
        PortalDb = getWritableDatabase();
        PortalDb.insert("applications", null, row);
        PortalDb.close();
    }

    @SuppressLint("Range")
    public jobSeeker getUserInfo(String userName) {

        PortalDb = getReadableDatabase();
        String[] rowdetails = {"name,UserName,password", "phone", "mail", "address", "major", "uniName", "gradYear", "yearsOfExp", "gradState", "gender"};
        String[] args = {userName};
        Cursor c = PortalDb.query("jobSeeker", rowdetails, "UserName=?", args, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        jobSeeker seeker = new jobSeeker();
        seeker.setName(c.getString(c.getColumnIndex("name")));
        seeker.setUsername(userName);
        seeker.setPassword(c.getString(c.getColumnIndex("password")));
        seeker.setPhoneNumber(c.getString(c.getColumnIndex("phone")));
        seeker.setMail(c.getString(c.getColumnIndex("mail")));
        seeker.setAddress(c.getString(c.getColumnIndex("address")));
        seeker.setMajor(c.getString(c.getColumnIndex("major")));
        seeker.setUniName(c.getString(c.getColumnIndex("uniName")));
        seeker.setGradYear(Integer.parseInt(c.getString(c.getColumnIndex("gradYear"))));
        seeker.setYearsOfExp(Integer.parseInt(c.getString(c.getColumnIndex("yearsOfExp"))));
        seeker.setGradState(c.getString(c.getColumnIndex("gradState")));
        seeker.setGender(c.getString(c.getColumnIndex("gender")));

        c.close();
        ;
        PortalDb.close();
        return seeker;
    }

    public void updateInformaation(String username, ContentValues values) {
        PortalDb = getReadableDatabase();
        PortalDb.update("jobSeeker", values, "UserName=?", new String[]{username});
        PortalDb.close();
    }

    @SuppressLint("Range")
    public ArrayList<jobVacancy> ShowAllVacancies(String username) {

        ArrayList<jobVacancy> vacancies = new ArrayList<>();
        PortalDb = getReadableDatabase();
        Cursor c = PortalDb.rawQuery("select* from jobVacancy where not EXISTS (select SeekerUsername,JobID from applications where SeekerUsername=? and applications.JobID=jobVacancy.vacancyID)", new String[]{username});
        if (c != null) {
            c.moveToFirst();
        }
        for (int i = 0; i < c.getCount(); i++) {
            jobVacancy vacancy = new jobVacancy();
            vacancy.setVacancyID(Integer.parseInt(c.getString(c.getColumnIndex("vacancyID"))));
            vacancy.setCompMail(c.getString(c.getColumnIndex("compMail")));
            vacancy.setRecruiterName(c.getString(c.getColumnIndex("RecruiterUsername")));
            vacancy.setCompName(c.getString(c.getColumnIndex("compName")));
            vacancy.setTittle(c.getString(c.getColumnIndex("tittle")));
            vacancy.setJobType(c.getString(c.getColumnIndex("jobType")));
            vacancy.setCompAddress(c.getString(c.getColumnIndex("compAddress")));
            vacancy.setExpNeeded(Integer.parseInt(c.getString(c.getColumnIndex("expNeeded"))));
            vacancy.setDescription(c.getString(c.getColumnIndex("jobDescription")));
            vacancies.add(vacancy);
            c.moveToNext();
        }

        PortalDb.close();
        return vacancies;
    }

    public List<Pair<String, String>> showHistory(String username) {
        PortalDb = getReadableDatabase();
        List<Pair<String, String>> listOfHistory = new ArrayList<>();
        String name;
        Cursor c = PortalDb.rawQuery("select distinct jobVacancy.tittle,jobVacancy.compName ,applications.applicationState from jobVacancy inner join applications on SeekerUsername=? and  jobVacancy.vacancyID=applications.JobID", new String[]{username});
        if (c != null) {
            c.moveToFirst();
        }
        while (!c.isAfterLast()) {
            name = c.getString(0) + "\n" + c.getString(1);
            listOfHistory.add(new Pair<String, String>(name, c.getString(2)));
            c.moveToNext();
        }
        PortalDb.close();
        return listOfHistory;
    }

    public Boolean addRecruiter(Recruiter recruiter) {
        PortalDb = getReadableDatabase();
        Cursor c = PortalDb.rawQuery("Select name from Recruiter where UserName=? ", new String[]{recruiter.getUsername()});
        if (c.getCount() > 0) {
            return false;
        }
        ContentValues row = new ContentValues();

        row.put("UserName", recruiter.getUsername());
        row.put("password", recruiter.getPassword());
        row.put("name", recruiter.getName());

        PortalDb = getWritableDatabase();
        PortalDb.insert("Recruiter", null, row);
        PortalDb.close();
        return true;
    }

    public void addVacancy(jobVacancy vacancy) {
        ContentValues row = new ContentValues();
        row.put("vacancyID", vacancy.getVacancyID());
        row.put("tittle", vacancy.getTittle());
        row.put("jobType", vacancy.getJobType());
        row.put("expNeeded", vacancy.getExpNeeded());
        row.put("compName", vacancy.getCompName());
        row.put("compMail", vacancy.getCompMail());
        row.put("compAddress", vacancy.getCompAddress());
        row.put("RecruiterUsername", vacancy.getRecruiterName());
        row.put("jobDescription", vacancy.getDescription());
        PortalDb = getWritableDatabase();
        PortalDb.insert("jobVacancy", null, row);
        PortalDb.close();
    }

    @SuppressLint("Range")
    public ArrayList<jobSeeker> showJobApplicants(int jobId) {
        PortalDb = getReadableDatabase();
        Cursor c = PortalDb.rawQuery("select * from jobSeeker Inner join applications on jobSeeker.UserName=SeekerUsername where JobID=? and ApplicationState=?  ", new String[]{String.valueOf(jobId), "Pending"});
        if (c != null) {
            c.moveToFirst();
        }
        ArrayList<jobSeeker> applicants = new ArrayList<>();
        while (!c.isAfterLast()) {
            jobSeeker seeker = new jobSeeker();
            seeker.setUsername(c.getString(c.getColumnIndex("UserName")));
            seeker.setName(c.getString(c.getColumnIndex("name")));
            seeker.setPhoneNumber(c.getString(c.getColumnIndex("phone")));
            seeker.setGender(c.getString(c.getColumnIndex("gender")));
            seeker.setPassword(c.getString(c.getColumnIndex("password")));
            seeker.setMail(c.getString(c.getColumnIndex("mail")));
            seeker.setMajor(c.getString(c.getColumnIndex("major")));
            seeker.setUniName(c.getString(c.getColumnIndex("uniName")));
            seeker.setGradYear(Integer.parseInt(c.getString(c.getColumnIndex("gradYear"))));
            seeker.setGradState(c.getString(c.getColumnIndex("gradState")));
            seeker.setAddress(c.getString(c.getColumnIndex("address")));
            seeker.setYearsOfExp(Integer.parseInt(c.getString(c.getColumnIndex("yearsOfExp"))));
            applicants.add(seeker);
            c.moveToNext();
        }

        PortalDb.close();
        return applicants;
    }

    public ArrayList<String> showRecruiterJobs(String RecruiterUsername) {
        PortalDb = getReadableDatabase();
        Cursor c = PortalDb.rawQuery("select vacancyID from jobvacancy  where RecruiterUsername=?   ", new String[]{RecruiterUsername});
        if (c != null) {
            c.moveToFirst();
        }
        ArrayList<String> jobIdList = new ArrayList<>();
        while (!c.isAfterLast()) {
            jobIdList.add(c.getString(0));
            c.moveToNext();
        }

        PortalDb.close();
        return jobIdList;
    }


    public void setApplicationState(String username, String status, int jobID) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("ApplicationState", status);
        PortalDb = getReadableDatabase();
        PortalDb.update("applications", contentValues, "SeekerUsername=? and JobID=?", new String[]{username, String.valueOf(jobID)});
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
