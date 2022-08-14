package com.complete.boot.camp.annotation.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnotationBasedConfigurationMain {
    public static void main(String[] args) {

        //ApplicationContext  context= new ClassPathXmlApplicationContext("SpringAnnotation.xml");
        ApplicationContext context= new AnnotationConfigApplicationContext(BeanConfiguration.class);

        Doctor doctor= context.getBean(Doctor.class);
        doctor.assist();
        doctor.setQualification("MBBS");
        System.out.println(doctor.getQualification());
        System.out.println(doctor);
        // The above line will print: Doctor{qualification='MBBS'}
        // Creating another bean to check singleton
        Doctor doctor1= context.getBean(Doctor.class);
        System.out.println(doctor1);
        // Now creted another object but this also will give the same ,even though here we have not set qualification
        // Doctor{qualification='MBBS'}, While if it is prototype then we will get : Doctor{qualification=null}
        Nurse nurse= context.getBean(Nurse.class);
        nurse.assist();
    }
}
