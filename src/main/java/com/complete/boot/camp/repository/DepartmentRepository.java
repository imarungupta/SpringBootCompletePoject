package com.complete.boot.camp.repository;


import com.complete.boot.camp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentName(String departmentName);

    //@Query(value = "",nativeQuery = true)
    public List<Department> findByDepartmentNameIgnoreCase(String departmentName);

    //Note: Usually we will get the result form jpa by using the correct naming convention but some
    // if we don't get correct result then we cna use JPQL or native SQL query as well.We just need to
    // @Query

    public List<Department> findByDepartmentIdOrDepartmentNameIgnoreCase(Long departmentId, String departmentName);
}
