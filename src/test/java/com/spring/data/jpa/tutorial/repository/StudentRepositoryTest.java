package com.spring.data.jpa.tutorial.repository;

import com.spring.data.jpa.tutorial.entity.Guardian;
import com.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("tung3")
                .lastName("quang3")
                .emailId("tranquang3@gmail.com")
//                .guardianEmail("dieu@gmail.com")
//                .guardianMobile("0981605944")
//                .guardianName("dieu")
                .build(); // cu phap khi khai bao @Buider o entity

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = new Guardian("dieu2","dieu2@gmail.com","09816059442");
        Student student = Student.builder()
                .firstName("tung2")
                .lastName("quang2")
                .emailId("tranquang2@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void getStudentByFirstName(){
        String name = "tung";
        List<Student> students = studentRepository.findByFirstName(name);
        System.out.println(students);
    }

    @Test
    public void getStudentByFirstNameContaining(){
        String name = "tung";
        List<Student> students = studentRepository.findByFirstNameContaining(name);
        System.out.println(students);
    }

    @Test
    public void getStudentByGuardianName(){
        String name = "dieu";
        List<Student> students = studentRepository.findByGuardianName(name);
        System.out.println(students);
    }

    @Test
    public void getByFirstNameAndLastName(){
        String firstName = "tung";
        String lastName = "quang";
        Student student = studentRepository.findByFirstNameAndLastName(firstName,lastName);
        System.out.println(student);
    }

    @Test
    public void getStudentByGuardianNameContaining(){
        String guardianName = "di";
        List<Student> students = studentRepository.findByGuardianNameContaining(guardianName);
        System.out.println(students);
    }

    @Test
    public void getStudentDesc(){
        List<Student> students = studentRepository.findByOrderByGuardianNameDesc();
        System.out.println(students);
    }
    
    @Test
    public void getAllStudent(){
        List<Student> students = studentRepository.getAllStudents();
        System.out.println("students = " + students);
    }
    
    @Test
    public void getFirstName(){
        String getFirstName = studentRepository.getFirstName("tung");
        System.out.println("getFirstName = " + getFirstName);
    }

    @Test
    public void getFirstNameByParam(){
        List<Student> students = studentRepository.getFirstNameByParam("tung");
        System.out.println("getFirstName = " + students);
    }

    @Test
    public void updateStudent(){
        System.out.println(studentRepository.updateStudentNameByEmailId("nam","tranquang@gmail.com"));
    }

}


