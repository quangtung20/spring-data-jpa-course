package com.spring.data.jpa.tutorial.repository;

import com.spring.data.jpa.tutorial.entity.Course;
import com.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    CourseMaterialRepository courseMaterialRepository;


    @Autowired
    CourseRepository courseRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = new Course("course_title2","tranquangtung2");
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("google.com2")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
    
    @Test
    public void getAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }


}