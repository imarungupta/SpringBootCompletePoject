package com.complete.boot.camp.service;

import com.complete.boot.camp.entity.Department;
import com.complete.boot.camp.exception.DepartmentNotFoundException;

import javax.validation.Valid;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(@Valid Department department);

    List<Department> getDpartmentsList();
    Department findDepartmentById(Long departmentId) throws DepartmentNotFoundException;
    void deleteDepartmentById(Long departmentId);
    Department updateDepartment(Department department, Long department1);
    List<Department> findDepartmentByName(String departmentName);
    List<Department> getByDepartmentIdOrDepartmentName(Long departmentId, String departmentName);
}
