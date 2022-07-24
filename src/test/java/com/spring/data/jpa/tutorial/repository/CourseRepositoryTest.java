package com.spring.data.jpa.tutorial.repository;

import com.spring.data.jpa.tutorial.entity.Course;
import com.spring.data.jpa.tutorial.entity.Student;
import com.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;
    @Test
    public void getAllCourses(){

        Pageable pageable = PageRequest.of(0,2);
        List<Course> courses = courseRepository.findAll(pageable).getContent();

        Long totalElements = courseRepository.findAll(pageable).getTotalElements();
        System.out.println("totalElements = " + totalElements);

        int totalPages = courseRepository.findAll(pageable).getTotalPages();
        System.out.println("totalPages = " + totalPages);

        System.out.println("courses = " + courses);
    }

    @Test
    public void testPagination(){
        Pageable pageable = PageRequest.of(0,2, Sort.by("courseId").descending());
        List<Course> courses = courseRepository.findAll(pageable).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void test(){
        Pageable pageable = PageRequest.of(0,2, Sort.by("courseId").descending());
        List<Course> courses = courseRepository.findByTitleContaining("1",pageable).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit("12")
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}