package com.hudihi.sms.features.course.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hudihi.sms.features.course.dto.CourseRequest;
import com.hudihi.sms.features.course.dto.CourseResponse;
import com.hudihi.sms.features.course.model.Course;
import com.hudihi.sms.features.course.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void createCourse(CourseRequest course) {
        Course newCourse = new Course();
        newCourse.setCourseName(course.courseName());
        newCourse.setCourseCode(course.courseCode());
        newCourse.setCourseContent(course.courseContent());
        newCourse.setCourseCredits(course.courseCredits());
        newCourse.setCourseDuration(course.courseDuration());
        newCourse.setCourseDeliveryMode(course.courseDeliveryMode());
        courseRepository.save(newCourse);
    }

    @Override
    public void updateCourse(Long courseId, CourseRequest course) {
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if(!existingCourse.isPresent()){
            throw new IllegalArgumentException("Course with ID " + courseId + " not found.");
        }
        existingCourse.get().setCourseCode(course.courseCode() != null ? course.courseCode() : existingCourse.get().getCourseCode());
        existingCourse.get().setCourseName(course.courseName() != null ? course.courseName() : existingCourse.get().getCourseName());
        existingCourse.get().setCourseContent(course.courseContent() != null ? course.courseContent() : existingCourse.get().getCourseContent());
        existingCourse.get().setCourseCredits(course.courseCredits() != 0 ? course.courseCredits() : existingCourse.get().getCourseCredits());
        existingCourse.get().setCourseDuration(course.courseDuration() != 0 ? course.courseDuration() : existingCourse.get().getCourseDuration());
        existingCourse.get().setCourseDeliveryMode(course.courseDeliveryMode() != null ? course.courseDeliveryMode() : existingCourse.get().getCourseDeliveryMode());
        courseRepository.save(existingCourse.get());
        
    }

    @Override
    public void deleteCourse(Long courseId) {
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if(!existingCourse.isPresent()){
            throw new RuntimeException("Course with ID " + courseId + " not found.");
        }
        courseRepository.deleteById(existingCourse.get().getId());
    }


    @Override
    public CourseResponse getCourseById(Long courseId) {
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if(!existingCourse.isPresent()){
            throw new RuntimeException("Course with ID " + courseId + " not found.");
        }
        Course course = existingCourse.get();
        return new CourseResponse(
            existingCourse.get().getId(),
            course.getCourseName(),
            course.getCourseCode(),
            course.getCourseContent(),
            course.getCourseCredits(),
            course.getCourseDuration(),
            course.getCourseDeliveryMode(),
            course.getCreatedAt(),
            course.getUpdatedAt()
        );
    }

    @Override
    public List<CourseResponse> listCourses() {
       List<Course> courses = courseRepository.findAll();
       if (courses.isEmpty()) {
        throw new RuntimeException();
       }
       List<CourseResponse> courseResponses =  courses.stream()
                                                    .map(course -> new CourseResponse(
                                                        course.getId(),
                                                        course.getCourseName(),
                                                        course.getCourseCode(),
                                                        course.getCourseContent(),
                                                        course.getCourseCredits(),
                                                        course.getCourseDuration(),
                                                        course.getCourseDeliveryMode(),
                                                        course.getCreatedAt(),
                                                        course.getUpdatedAt()
                                                    ))
                                                    .collect(Collectors.toList());
        return courseResponses;
    }
    
}
