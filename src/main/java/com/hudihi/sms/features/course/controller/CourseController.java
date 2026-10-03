package com.hudihi.sms.features.course.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hudihi.sms.common.ApiConstants;
import com.hudihi.sms.features.course.dto.CourseRequest;
import com.hudihi.sms.features.course.dto.CourseResponse;
import com.hudihi.sms.features.course.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping (ApiConstants.API_BASE_PATH + "courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }


    @Operation (summary = ApiConstants.GET_ALL_COURSES_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.SUCCESS_200, description = ApiConstants.GET_ALL_COURSES_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.NOT_FOUND_404, description = ApiConstants.NOT_FOUND_DESCRIPTION)
        }
    )
    @GetMapping ("/all")
    public ResponseEntity<List<CourseResponse>> listCourses(){
        List<CourseResponse> courses = courseService.listCourses();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @Operation (summary = ApiConstants.GET_COURSE_BY_ID_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse( responseCode = ApiConstants.SUCCESS_200, description = ApiConstants.GET_COURSE_BY_ID_DESCRIPTION),
            @ApiResponse( responseCode = ApiConstants.NOT_FOUND_404, description = ApiConstants.NOT_FOUND_DESCRIPTION)
        }
    )
    @GetMapping ("/{courseId}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable Long courseId){
        CourseResponse course = courseService.getCourseById(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(course);
    }

    @Operation (summary = ApiConstants.CREATE_COURSE_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.CREATED_201, description = ApiConstants.CREATE_COURSE_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.BAD_REQUEST_400, description = ApiConstants.BAD_REQUEST_DESCRIPTION)
        }
    )
    @PostMapping ("/create")
    public ResponseEntity<Void> createCourse(@RequestBody CourseRequest request){
        courseService.createCourse(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation (summary = ApiConstants.UPDATE_COURSE_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.SUCCESS_200, description = ApiConstants.UPDATE_COURSE_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.NOT_FOUND_404, description = ApiConstants.NOT_FOUND_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.BAD_REQUEST_400, description = ApiConstants.BAD_REQUEST_DESCRIPTION)
        }
    )
    @PutMapping ("/{courseId}/update")
    public ResponseEntity<Void> updateCourse(@PathVariable Long courseId, @RequestBody CourseRequest request){
        courseService.updateCourse(courseId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation (summary = ApiConstants.DELETE_COURSE_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.NO_CONTENT_204, description = ApiConstants.DELETE_COURSE_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.NOT_FOUND_404, description = ApiConstants.NOT_FOUND_DESCRIPTION)
        }
    )
    @DeleteMapping ("/{courseId}/delete")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
