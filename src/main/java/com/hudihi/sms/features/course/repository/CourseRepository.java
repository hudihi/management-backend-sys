package com.hudihi.sms.features.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hudihi.sms.features.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}