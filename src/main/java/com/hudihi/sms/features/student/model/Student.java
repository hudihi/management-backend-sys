package com.hudihi.sms.features.student.model;

import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Set;

import com.hudihi.sms.common.BaseAuditEntity;
import com.hudihi.sms.features.course.model.Course;


@EqualsAndHashCode (callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column (name ="first_name", nullable = false)
    private String firstName;

    @Column (name = "last_name", nullable = false)
    private String lastName;

    @Column (name = "student_age", nullable = false)
    private int studentAge;

    @Column (name = "student_email", nullable = false, unique = true)
    private String studentEmail;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable (
        name = "course_student",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn (name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();


    public void addCourse(Course course){
        courses.add(course);
        course.getStudents().add(this);
    }


    public void removeCourse(Course course){
        courses.remove(course);
        course.getStudents().remove(this);
    }

}
