package com.complete.boot.camp.xml.configation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLBasedConfigurationMain {
    public static void main(String[] args) {

        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");

        Doctor doctor= context.getBean(Doctor.class);
        doctor.assist();
        System.out.println(doctor.getQualification());
        Nurse nurse= context.getBean(Nurse.class);
        nurse.assist();
        System.out.println(nurse.getQualification());
        // Another way: using interface
        Staff staffDoctor= (Doctor)context.getBean("doctorXmlBean");
        staffDoctor.assist();
        Staff staffNurse= (Nurse)context.getBean("nurseXmlBean");
        staffNurse.assist();
    }
}
