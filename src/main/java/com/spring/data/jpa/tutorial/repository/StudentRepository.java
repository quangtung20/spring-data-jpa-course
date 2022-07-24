package com.spring.data.jpa.tutorial.repository;

import com.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByGuardianName(String guardianName);
    List<Student> findByLastNameNotNull();
    Student findByFirstNameAndLastName(String firstName,
                                       String lastName);
    List<Student> findByGuardianNameContaining(String guardianName);

    List<Student> findByOrderByGuardianNameDesc();

    @Query("select s from Student s")
    List<Student> getAllStudents();

    @Query("select s.emailId from Student s where s.firstName = ?1")
    String getFirstName(String firstName);

    @Query("select s from Student s where s.firstName = :firstName")
    List<Student> getFirstNameByParam(@Param("firstName") String firstName);


    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}
