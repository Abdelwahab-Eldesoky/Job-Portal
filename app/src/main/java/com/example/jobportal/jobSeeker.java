package com.example.jobportal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class jobSeeker extends User{
    private String phoneNumber;
    private String mail;
    private String major;
    private String uniName;
    private String gradYear;
    private String gradState;
    private String address;
    private String Gender;
    private  int yearsOfExp;
    PortalDB db;

    public jobSeeker() {

    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getGradYear() {
        return gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    public String getGradState() {
        return gradState;
    }

    public void setGradState(String gradState) {
        this.gradState = gradState;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    public void Register(String name, String username, String password, int SSN,String phoneNumber, String mail, String major, String uniName, String gradYear, String gradState, String address, String gender, int yearsOfExp){
    this.setName(name);
    this.setUsername(username);this.setPassword(password);
    this.setSSN(SSN);this.setPhoneNumber(phoneNumber);
    this.setMail(mail);this.setMajor(major);
    this.setYearsOfExp(yearsOfExp);
    this.setGender(gender);this.setAddress(address);
    this.setGradState(gradState);this.setGradYear(gradYear);
    this.setUniName(uniName);


    }
}
