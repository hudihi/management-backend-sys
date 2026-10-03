package com.hudihi.sms.features.student.controller;

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
import com.hudihi.sms.features.student.dto.StudentRequest;
import com.hudihi.sms.features.student.dto.StudentResponse;
import com.hudihi.sms.features.student.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping (ApiConstants.API_BASE_PATH + "students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @Operation (summary = ApiConstants.CREATE_STUDENT_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.CREATED_201, description = ApiConstants.CREATE_STUDENT_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.BAD_REQUEST_400, description = ApiConstants.BAD_REQUEST_DESCRIPTION)
        }
    )
    @PostMapping("/register")
    public ResponseEntity<Void> registerStudents(@RequestBody StudentRequest request){
        studentService.registerStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation (summary = ApiConstants.UPDATE_STUDENT_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.SUCCESS_200, description = ApiConstants.UPDATE_STUDENT_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.NOT_FOUND_404, description = ApiConstants.NOT_FOUND_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.BAD_REQUEST_400, description = ApiConstants.BAD_REQUEST_DESCRIPTION)
        }
    )
    @PutMapping("/{studentId}/update")
    public ResponseEntity<Void> updateStudent(@PathVariable Long studentId, @RequestBody StudentRequest request){
        studentService.updateStudent(studentId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation (summary = ApiConstants.GET_STUDENT_BY_ID_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.SUCCESS_200, description = ApiConstants.GET_STUDENT_BY_ID_DESCRIPTION,
                content = {@Content (mediaType = "application/json",
                    schema = @Schema(implementation = StudentResponse.class)
                )}
            ),
            @ApiResponse (responseCode = ApiConstants.NOT_FOUND_404, description = ApiConstants.NOT_FOUND_DESCRIPTION)
        }
    )
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> getStudent(@Parameter(description = ApiConstants.SEARCH_ID_DESCRIPTION) @PathVariable Long studentId){
        StudentResponse response = studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation (summary = ApiConstants.UPDATED_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.SUCCESS_200, description = ApiConstants.UPDATED_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.NOT_FOUND_404, description = ApiConstants.NOT_FOUND_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.BAD_REQUEST_400, description = ApiConstants.BAD_REQUEST_DESCRIPTION)
        }
    )
    @PostMapping ("/{studentId}/enroll/{courseId}")
    public ResponseEntity<Void> enrollStudentInCourse(@Parameter(description = ApiConstants.SEARCH_ID_DESCRIPTION) @PathVariable Long studentId, @Parameter(description = ApiConstants.SEARCH_ID_DESCRIPTION) @PathVariable Long courseId){
        studentService.enrollStudentInCourse(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation (summary = ApiConstants.UPDATED_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.SUCCESS_200, description = ApiConstants.UPDATED_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.NOT_FOUND_404, description = ApiConstants.NOT_FOUND_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.BAD_REQUEST_400, description = ApiConstants.BAD_REQUEST_DESCRIPTION)
        }
    )
    @DeleteMapping ("/{studentId}/remove/{courseId}")
    public ResponseEntity<Void> removeStudentFromCourse(@Parameter(description = ApiConstants.SEARCH_ID_DESCRIPTION) @PathVariable Long studentId, @Parameter(description = ApiConstants.SEARCH_ID_DESCRIPTION) @PathVariable Long courseId){
        studentService.removeStudentFromCourse(studentId, courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation (summary = ApiConstants.UPDATED_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.SUCCESS_200, description = ApiConstants.UPDATE_STUDENT_COURSES_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.NOT_FOUND_404, description =  ApiConstants.NOT_FOUND_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.BAD_REQUEST_400, description = ApiConstants.BAD_REQUEST_DESCRIPTION)
        }
    )
    @PutMapping ("/{studentId}/updateCourse/{courseId}")
    public ResponseEntity<Void> updateStudentCourses(@Parameter(description = ApiConstants.SEARCH_ID_DESCRIPTION) @PathVariable Long studentId, @Parameter(description = ApiConstants.SEARCH_ID_DESCRIPTION) @PathVariable Long courseId){
        studentService.updateStudentCourses(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @Operation (summary = ApiConstants.DELETE_STUDENT_DESCRIPTION)
    @ApiResponses (
        value = {
            @ApiResponse (responseCode = ApiConstants.NO_CONTENT_204, description = ApiConstants.DELETE_STUDENT_DESCRIPTION),
            @ApiResponse (responseCode = ApiConstants.NOT_FOUND_404, description = ApiConstants.NOT_FOUND_DESCRIPTION)
        }
    )
    @DeleteMapping ("/{studentId}/delete")
    public ResponseEntity<Void> deleteStudent(@Parameter (description = ApiConstants.SEARCH_ID_DESCRIPTION) @PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
