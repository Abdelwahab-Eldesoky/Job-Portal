package com.example.jobportal;

public class User {
    private String name;
    private String username;

    private String password;
    private int SSN;

    public User() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }
    public boolean login(String username , String password){
        if(this.username.equals(username) && this.password.equals(password)){
            return true;
        }
        else
        {
            return false;
        }
    }
}
