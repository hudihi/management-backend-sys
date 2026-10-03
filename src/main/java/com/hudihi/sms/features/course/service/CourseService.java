package com.hudihi.sms.features.course.service;

import com.hudihi.sms.features.course.dto.CourseRequest;
import com.hudihi.sms.features.course.dto.CourseResponse;
import java.util.List;

public interface CourseService {
    void createCourse(CourseRequest request);
    void updateCourse(Long courseId, CourseRequest request);
    void deleteCourse(Long courseId);
    CourseResponse getCourseById(Long courseId);
    List<CourseResponse> listCourses();
}
