package com.complete.boot.camp.annotation.configuration;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// BeanNameAware is for bean life cycle, and it contains setBeanName() to override
// which will be executed first before bean is ready to use
@Component
@Scope("singleton")
//@Scope("prototype")
public class Doctor implements Staff, BeanNameAware {

    private String qualification;
    private Nurse nurse;

    public void assist() {
        System.out.println("Doctor is assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    // Bean Life Cycle Method

    @Override
    public void setBeanName(String name) {
        System.out.println("set BeanName is called before postConstructor and bean ready to use ");
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Post Construct is called and now bean ready to use call Doctor's assist method");
    }
}
