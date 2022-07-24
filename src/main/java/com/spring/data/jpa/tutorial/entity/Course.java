package com.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    // Thiet ke 1 1 se mappedBy o bang a cua b
    // va dat them 1 truong id cua bang a cho bang b => neu bang b lay du lieu bang a
    // se lay theo id cua bang a (a_id) luu trong bang b
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private String credit;

    @OneToOne(
            mappedBy = "course" // dung quan he 2 chieu => dung mappedBy, ko the khai bao nguoc lai dc
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="teacher_id",
            referencedColumnName ="teacherId"
    )
    private Teacher teacher;


    public Course(String title, String credit) {
        this.title = title;
        this.credit = credit;
    }

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudents(Student student){
        if(students==null){
            students = new ArrayList<>();
            students.add(student);
        }
    }
}
