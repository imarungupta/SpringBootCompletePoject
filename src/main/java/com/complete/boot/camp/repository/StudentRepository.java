package com.complete.boot.camp.repository;


import com.complete.boot.camp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    List<Student> findDistinctByFirstNameAndLastName(String firstName,String lastName);
    List<Student> findByFirstNameOrLastName(String firstName,String lastName);

    // --------------------------------Interact with DB using JPQL---------------------------------
    // So here we can create the method according to the entity name but some time method does not support
    // and then in that we have to use JPA @Query annoation to interfact with DB and we can pass the JPQL
    // query inside @Query annotation
    @Query("select std from Student std where std.emailId= ?1")
    Student getStudentByEmailAddress (String emailId);
    // So here we'hv written JPQL and we are using Enity class 'Student' and its variable to wirte the query
    // not db Table and its colume that is why we have used emailId not email_address
    @Query("select std.firstName from Student std where std.emailId= ?1")
    String getStudentFirstNameByEmailAddress (String emailId);
    // Here we are fetching student first name from Student using emailId

    //-----------------------Interact with DB using Native query-----------------------------------
    @Query(
            value = "select * from tbl_student s where s.email_address= ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative (String emailId);
    @Query( value = "select s.first_name from tbl_student s where s.email_address= ?1", nativeQuery = true)
    String getStudentFirstNameByEmailAddressNative (String emailId);
    // Note in the above native query the firstName of Student class will become column as first_name in db
    // Define Native Named param insted of giving ?1
    @Query(
            value = "select * from tbl_student s where s.email_address= :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam (@Param("emailId") String emailId);
    // Updating the record using @Modifying and @Transaction for complete transaction
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address= ?2 ", nativeQuery = true)
    int updateStudentByEmailId(String firstName,String emailId);

}
