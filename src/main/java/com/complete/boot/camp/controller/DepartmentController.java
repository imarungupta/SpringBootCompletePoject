package com.complete.boot.camp.controller;

import com.complete.boot.camp.entity.Department;
import com.complete.boot.camp.exception.DepartmentNotFoundException;
import com.complete.boot.camp.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/")
    public Department saveDepartment(@RequestBody @Valid Department department){
        logger.info("Inside the saveDepartment of Controller class");
        return service.saveDepartment(department);
    }

    @GetMapping("/")
    public List<Department> getDpartmentsList(){
        logger.info("Inside the getDpartmentsList of Controller class");
        return service.getDpartmentsList();
    }
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return service.findDepartmentById(departmentId);
    }
    @GetMapping("/name/{name}")
    public List<Department> findDepartmentByName(@PathVariable("name") String departmentName){
        return service.findDepartmentByName(departmentName);
    }
    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        logger.info("Inside the deleteDepartmentById of Controller class");
        service.deleteDepartmentById(departmentId);
        return "Record is deleated with id: "+departmentId;
    }
    @PutMapping("/{id}")
    public Department updateDepartment(@RequestBody @Valid Department department, @PathVariable("id") Long departmentId){
        logger.info("Inside the updateDepartment of Controller class");
        return service.updateDepartment(department,departmentId);
    }
    @GetMapping("/IdOrName/{id},{name}")
    public List<Department> getByDepartmentIdOrDepartmentName
            (@PathVariable("id") Long departmentId, @PathVariable("name") String departmentName){
        logger.info("Inside the getByDepartmentIdOrDepartmentName of Controller class");
        return service.getByDepartmentIdOrDepartmentName(departmentId,departmentName);
    }
}
