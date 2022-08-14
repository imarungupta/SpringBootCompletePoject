package com.complete.boot.camp.repository;

import com.complete.boot.camp.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    /*@Autowired
    EntityManager entityManager;*/
    @Autowired
    private StudentRepository studentRepository;
    Guardian guardian;
    Student student;
    List<Student> studentList;
    Department department;
    Course course;
    CourseMaterial courseMaterial;

    @BeforeEach
    void setUp() {
        course = Course.builder()
                .title("Spring Boot")
                .credit(10)
                .build();

        courseMaterial = CourseMaterial.builder()
                .url("www.udemy.com")
                .course(course)
                .build();

        department = Department.builder()
                .departmentName("IT")
                .departmentAddress("BLR")
                .departmentCode("IT-001")
                .build();

        guardian = Guardian.builder()
                .name("Nikhil")
                .emailId("nikhil@gmail.com")
                .mobile("102336544")
                .build();

        student = Student.builder()
                .firstName("arun")
                .lastName("Gupta")
                .emailId("arun@gmail.com")
                .guardian(guardian)
                .department(department)
                .courseMaterial(courseMaterial)
                .build();
        //entityManager.persist(student);
    }

    @Test
    public void saveStudent() {

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findStudentByFirstName() {
        List<Student> byFirstName = studentRepository.findByFirstName("");
        System.out.println("StudentList = " + byFirstName);
    }

    @Test
    public void findStudentByFirstNameContaining() {
        List<Student> byFirstName = studentRepository.findByFirstNameContaining("Ar");
        System.out.println("StudentList = " + byFirstName);
    }

    @Test
    public void findStudentByLastNameNotNull() {
        List<Student> byLastNameNotNull = studentRepository.findByLastNameNotNull();
        System.out.println("byLastNameNotNull = " + byLastNameNotNull);
    }

    @Test
    public void findStudentByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Nikhil");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student studentByEmailAddress = studentRepository.getStudentByEmailAddress("arun@gmail.com");
        System.out.println("studentByEmailAddress = " + studentByEmailAddress);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("arun@gmail.com");
        System.out.println("studentFirstName = " + studentFirstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student studentByEmailAddressNative = studentRepository.getStudentByEmailAddressNative("arun@gmail.com");
        System.out.println("studentByEmailAddressNative = " + studentByEmailAddressNative);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNative() {
        String studentFirstNameByEmailAddressNative = studentRepository.getStudentFirstNameByEmailAddressNative("arun@gmail.com");
        System.out.println("studentFirstNameByEmailAddressNative = " + studentFirstNameByEmailAddressNative);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student studentByEmailAddressNativeNamedParam = studentRepository.getStudentByEmailAddressNativeNamedParam("arun@gmail.com");
        System.out.println("studentByEmailAddressNativeNamedParam = " + studentByEmailAddressNativeNamedParam);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        int tarun = studentRepository.updateStudentByEmailId("Tarun", "arun@gmail.com");
        System.out.println("student1 = " + tarun);
        System.out.println("Student after update- " + student);
    }
}