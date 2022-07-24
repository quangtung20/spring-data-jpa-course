package com.spring.data.jpa.tutorial.repository;

import com.spring.data.jpa.tutorial.entity.Course;
import com.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course1 = new Course("course2","url1");
        Course course2 = new Course("course2","url1");

        Teacher teacher = Teacher.builder()
                .firstName("tung2")
                .lastName("nam2")
//                .courses(List.of(course1, course2))
                .build();
        teacherRepository.save(teacher);
    }

    @Test
    public void getAllTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();
        System.out.println("teachers = " + teachers);
    }
}