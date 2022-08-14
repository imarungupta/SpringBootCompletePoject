package com.complete.boot.camp.service;


import com.complete.boot.camp.entity.Department;
import com.complete.boot.camp.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@DataJpaTest
class DepartmentServiceTest {

    @Autowired
    EntityManager entityManager;
    @MockBean
    private DepartmentRepository repository;
    @Autowired
    private DepartmentService service;

   // String departmentName = "IT";
    List<Department> departmentList=null;
    
    @BeforeEach
    void setUp() {

       /* String departmentName = "IT";
        departmentList = service.findDepartmentByName(departmentName);
        Department department1 = Department.builder()
                .departmentName("IT")
                .departmentAddress("BLR").departmentCode("IT-006").departmentId(1L).build();
        Department department2 = Department.builder()
                .departmentName("IT")
                .departmentAddress("BLR").departmentCode("IT-006").departmentId(1L).build();
        departmentList.add(department1);
        departmentList.add(department2);
        entityManager.persist(departmentList);*/
    }
    @Test
    @DisplayName("Test")
    public void whenValidDepartmentName_thenReturnDepartmentList() {

        Mockito.when(repository.findByDepartmentNameIgnoreCase("IT")).thenReturn(departmentList);
        assertEquals(2,departmentList.size());
    }
    @Test
    public void whenValidDepartmentIdOrName_thenReturnDeparmentList(){
        String departmentName = "IT";
        Long departmentId =0L;
        departmentList = service.getByDepartmentIdOrDepartmentName(departmentId, departmentName);
       /* Department department1 = Department.builder()
                .departmentName("IT")
                .departmentAddress("BLR").departmentCode("IT-006").departmentId(1L).build();
        Department department2 = Department.builder()
                .departmentName("IT")
                .departmentAddress("BLR").departmentCode("IT-006").departmentId(1L).build();
        departmentList.add(department1);
        departmentList.add(department2);*/
        Mockito.when(repository.findByDepartmentIdOrDepartmentNameIgnoreCase(departmentId,departmentName))
                .thenReturn(departmentList);
        assertEquals(2,departmentList.size());
    }
    @Test
    public void whenValidDepartmentIdAndEntityValue_thenReturnUpdatedDepartment(){

        Department department1 = Department.builder()
                .departmentName("IT")
                .departmentAddress("BLR").departmentCode("IT-006").departmentId(1L).build();
        entityManager.persist(department1);
        Long departmentId =1l;
        Department mockDbDept = repository.findById(departmentId).get();
        //Optional<Department> departmentopt = repository.findById(departmentId);
        //Department mockDbDept = new Department();
        //Optional<Department>departmentopt = Optional.ofNullable(repository.findById(departmentId).orElse(new Department()));
       // Department mockDbDept = departmentopt.get();
        mockDbDept.setDepartmentName(department1.getDepartmentName());
        mockDbDept.setDepartmentCode(department1.getDepartmentCode());
        mockDbDept.setDepartmentAddress(department1.getDepartmentAddress());
        mockDbDept.setDepartmentId(department1.getDepartmentId());
//        if(Objects.equals(mockDbDept.getDepartmentId(),department1)){
//            if(Objects.nonNull(department1.getDepartmentName()) && !"".equalsIgnoreCase(department1.getDepartmentName())){
//                mockDbDept.setDepartmentName(department1.getDepartmentName());
//            }
//            if(Objects.nonNull(department1.getDepartmentCode()) && !"".equalsIgnoreCase(department1.getDepartmentCode())){
//                mockDbDept.setDepartmentCode(department1.getDepartmentCode());
//            }
//            if(Objects.nonNull(department1.getDepartmentAddress()) && !"".equalsIgnoreCase(department1.getDepartmentAddress())){
//                mockDbDept.setDepartmentAddress(department1.getDepartmentAddress());
//            }
//        }
        Mockito.when(repository.save(mockDbDept)).thenReturn(mockDbDept);
        assertEquals(mockDbDept,service.updateDepartment(department1,departmentId));
    }
}