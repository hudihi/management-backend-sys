package com.hudihi.sms.features.student.service;

import com.hudihi.sms.features.student.dto.StudentRequest;
import com.hudihi.sms.features.student.dto.StudentResponse;

public interface StudentService {
    void registerStudent(StudentRequest student);
    void updateStudent(Long studentId, StudentRequest student);
    void deleteStudent(Long studentId);
    StudentResponse getStudentById(Long studentId);
    void enrollStudentInCourse(Long studentId, Long courseId);
    void removeStudentFromCourse(Long studentId, Long courseId);
    void updateStudentCourses(Long studentId, Long courseId);
}
