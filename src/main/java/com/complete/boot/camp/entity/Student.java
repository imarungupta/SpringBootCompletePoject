package com.complete.boot.camp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student",
       uniqueConstraints = @UniqueConstraint(name = "emailId_unique", columnNames = "email_address"))
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;

    /*private String guardianName;
    private String guardianEmailId;
    private String guardianMobile;
    private Long departmentId;*/

    @ManyToOne(cascade = CascadeType.ALL) // It tells that if department is present then create and cascade it
    @JoinColumn(name = "department_id" , referencedColumnName = "departmentId")
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_material_id", referencedColumnName="courseMaterialId")
    private CourseMaterial courseMaterial;
}
