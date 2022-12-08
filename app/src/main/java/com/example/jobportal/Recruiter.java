package com.example.jobportal;

public class Recruiter extends User{

    public Recruiter(String name, String username, String password) {
        super(name, username, password);
    }

    public void Register(String name, String username, String password){
       new Recruiter(name, username, password);
    }

    public jobVacancy addVacancy(String tittle,String jobType,int expNeeded,String compName,String compMail,String compAddress){
        jobVacancy vacancy=new jobVacancy(tittle,jobType,expNeeded,compName,compMail,compAddress,this.getUsername());
        return vacancy;
    }

}
