package com.complete.boot.camp.xml.configation;

public class Nurse implements Staff{
    private String qualification;
    public Nurse(String qualification){
        this.qualification=qualification;
    }
    @Override
    public void assist() {
        System.out.println("Nurse is assisting");
    }
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

}
