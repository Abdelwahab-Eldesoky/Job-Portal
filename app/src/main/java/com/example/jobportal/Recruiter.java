package com.example.jobportal;

public class Recruiter extends User{

    public Recruiter() {

    }

    public Boolean Register(PortalDB db,String name, String username, String password){
      this.setName(name);
      this.setUsername(username);
      this.setPassword(password);
      if(db.addRecruiter(this)){
          return true;
        }

      return false;
    }

    /*public jobVacancy addVacancy(String tittle,String jobType,int expNeeded,String compName,String compMail,String compAddress){
        jobVacancy vacancy=new jobVacancy(tittle,jobType,expNeeded,compName,compMail,compAddress,this.getUsername());
        return vacancy;
    }*/


}
