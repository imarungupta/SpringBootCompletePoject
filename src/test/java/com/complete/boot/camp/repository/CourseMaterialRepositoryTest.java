package com.complete.boot.camp.repository;


import com.complete.boot.camp.entity.Course;
import com.complete.boot.camp.entity.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository  materialRepository;
    private CourseMaterial material;

    @BeforeEach
    void setUp() {
        Course course = Course.builder().title("AWS").credit(7).build();

        material= CourseMaterial.builder().url("www.udmy.com").course(course).build();
    }
    @Test
    public void saveCourseMaterial(){
        materialRepository.save(material);
    }
}