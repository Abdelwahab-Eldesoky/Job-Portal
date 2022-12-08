package com.example.jobportal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class jobSeeker extends User{
    private String phoneNumber;
    private String mail;
    private String major;
    private String uniName;
    private int gradYear;
    private String gradState;
    private String address;
    private String Gender;
    private  int yearsOfExp;
    private String SSN;
    static PortalDB helper;

    public jobSeeker(String name, String username, String password, String phoneNumber, String mail, String major, String uniName, int gradYear, String gradState, String address, String gender, int yearsOfExp, String SSN) {
        super(name, username, password);
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.major = major;
        this.uniName = uniName;
        this.gradYear = gradYear;
        this.gradState = gradState;
        this.address = address;
        this.Gender = gender;
        this.yearsOfExp = yearsOfExp;
        this.SSN = SSN;
    }

    public jobSeeker(Context context ) {
        helper =new PortalDB(context);
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

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
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
    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void Register(PortalDB db,String name, String username, String password, String SSN,String phoneNumber, String mail, String major, String uniName, int gradYear, String gradState, String address, String gender, int yearsOfExp){
    this.setName(name);
    this.setUsername(username);this.setPassword(password);
    this.setSSN(SSN);this.setPhoneNumber(phoneNumber);
    this.setMail(mail);this.setMajor(major);
    this.setYearsOfExp(yearsOfExp);
    this.setGender(gender);this.setAddress(address);
    this.setGradState(gradState);this.setGradYear(gradYear);
    this.setUniName(uniName);

    db.addSeeker(this);


    }
    public static String login(PortalDB db , String username , String password){

        String validate=String.valueOf(db.validateSeekerData(username,password));
        if(validate=="Not Found"){
            System.out.println("not found");
            return "Not Found";
        }
        System.out.println("validate  "+ validate);
        return validate;
    }
}
