package com.hudihi.sms.features.student.dto;

import com.hudihi.sms.features.course.model.Course;
import java.util.Set;


public record StudentResponse(String firstName, String lastName, int studentAge, String studentEmail, Set<Course> courses) {
    
}
