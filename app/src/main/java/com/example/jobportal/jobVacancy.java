package com.example.jobportal;

public class jobVacancy {

    private int vacancyID;
    private String tittle;
    private String jobType;
    private int expNeeded;
    private String compName;
    private String compMail;
    private String compAddress;
    private String recruiterName;

    public jobVacancy(String tittle, String jobType, int expNeeded, String compName, String compMail, String compAddress, String recruiterName) {

        this.tittle = tittle;
        this.jobType = jobType;
        this.expNeeded = expNeeded;
        this.compName = compName;
        this.compMail = compMail;
        this.compAddress = compAddress;
        this.recruiterName = recruiterName;
    }

    public int getVacancyID() {
        return vacancyID;
    }

    public void setVacancyID(int vacancyID) {
        this.vacancyID = vacancyID;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getExpNeeded() {
        return expNeeded;
    }

    public void setExpNeeded(int expNeeded) {
        this.expNeeded = expNeeded;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompMail() {
        return compMail;
    }

    public void setCompMail(String compMail) {
        this.compMail = compMail;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getRecruiterName() {
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName) {
        this.recruiterName = recruiterName;
    }

}
