package com.complete.boot.camp.service;

import com.complete.boot.camp.entity.Department;
import com.complete.boot.camp.exception.DepartmentNotFoundException;
import com.complete.boot.camp.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;
    private final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Override
    public Department saveDepartment(@Valid Department department) {
        logger.info("inside the saveDepartment of DepartmentServiceImpl");
        repository.save(department);
        return department;
    }

    @Override
    public List<Department> getDpartmentsList() {
        logger.info("inside the getDepartmentsList of DepartmentServiceImpl");
        return repository.findAll();
    }

    @Override
    public Department findDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        logger.info("inside the findDepartmentById of DepartmentServiceImpl");
        Optional<Department> deptById = repository.findById(departmentId);
        if(!deptById.isPresent()){
            throw new DepartmentNotFoundException("Department is Not found ");
        }else{
            return deptById.get();
        }
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {

        logger.info("inside the deleteDepartmentById of DepartmentServiceImpl");
        repository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {

        logger.info("inside the updateDepartment of DepartmentServiceImpl");
        Department deptDB = repository.findById(departmentId).get();
        if(Objects.equals(deptDB.getDepartmentId(), departmentId)){
            if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
                deptDB.setDepartmentName(department.getDepartmentName());
            }
            if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
                deptDB.setDepartmentAddress(department.getDepartmentAddress());
            }
            if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
                deptDB.setDepartmentCode(department.getDepartmentCode());
            }
        }else
            throw new IllegalArgumentException();
        repository.save(deptDB);
        return deptDB;
    }

    @Override
    public List<Department> findDepartmentByName(String departmentName) {

        logger.info("inside the findDepartmentByName of DepartmentServiceImpl");
        //return repository.findByDepartmentName(departmentName);
        return repository.findByDepartmentNameIgnoreCase(departmentName);
    }
    @Override
    public List<Department> getByDepartmentIdOrDepartmentName(Long departmentId, String departmentName) {

        logger.info("inside the getByDepartmentIdOrDepartmentName of DepartmentServiceImpl");
        return repository.findByDepartmentIdOrDepartmentNameIgnoreCase(departmentId,departmentName);
    }
}
