package com.complete.boot.camp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_department")
public class Department {

    @Id
    @SequenceGenerator(name = "department_seq", sequenceName = "department_seq" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    private Long departmentId;

    @NotNull(message = "Department can not blank")
    @Size(min = 2, max = 5)
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    //private final Logger logger= LoggerFactory.getLogger(Department.class);

}
