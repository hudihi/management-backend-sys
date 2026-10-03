package com.hudihi.sms.features.course.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import com.hudihi.sms.common.BaseAuditEntity;
import com.hudihi.sms.features.student.model.Student;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_code", nullable = false, unique = true)
    private String courseCode;

    @Column(name = "course_content", nullable = false)
    private String courseContent;

    @Column (name = "course_credits", nullable = false)
    private int courseCredits;

    @Column(name = "course_duration", nullable = false)
    private int courseDuration;

    @Column (name = "course_delivery_mode", nullable = false)
    private String courseDeliveryMode;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();


}
