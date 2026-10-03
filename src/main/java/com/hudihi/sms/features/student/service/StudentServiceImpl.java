package com.hudihi.sms.features.student.service;

import com.hudihi.sms.features.course.model.Course;
import com.hudihi.sms.features.course.repository.CourseRepository;
import com.hudihi.sms.features.student.dto.StudentRequest;
import com.hudihi.sms.features.student.dto.StudentResponse;
import com.hudihi.sms.features.student.model.Student;
import com.hudihi.sms.features.student.repository.StudentRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void registerStudent(StudentRequest student) {
        Student newStudent = new Student();
        newStudent.setFirstName(student.firstName());
        newStudent.setLastName(student.lastName());
        newStudent.setStudentAge(student.studentAge());
        newStudent.setStudentEmail(student.studentEmail());
        studentRepository.save(newStudent);

    }

    @Override
    public void updateStudent(Long studentId, StudentRequest student) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student with ID " + studentId + " not found."));
        
        existingStudent.setFirstName(student.firstName() != null ? student.firstName() : existingStudent.getFirstName());
        existingStudent.setLastName(student.lastName() != null ? student.lastName() : existingStudent.getLastName());
        existingStudent.setStudentAge(student.studentAge() != 0 ? student.studentAge() : existingStudent.getStudentAge());
        existingStudent.setStudentEmail(student.studentEmail() != null ? student.studentEmail() : existingStudent.getStudentEmail());

        studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentResponse getStudentById(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (!student.isPresent()) {
            throw new RuntimeException("Student not found.");
        }
        return new StudentResponse(
            student.get().getFirstName(),
            student.get().getLastName(),
            student.get().getStudentAge(),
            student.get().getStudentEmail(),
            student.get().getCourses()
        );
    }

    @Override
    public void enrollStudentInCourse(Long studentId, Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        Optional<Student> student = studentRepository.findById(studentId);

        if (!course.isPresent()) {
            throw new RuntimeException("Course not found.");
        }
        if (!student.isPresent()) {
            throw new RuntimeException("Student not found.");
        }

        student.get().getCourses().add(course.get());
        course.get().getStudents().add(student.get());
    }

    @Override
    public void removeStudentFromCourse(Long studentId, Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        Optional<Student> student = studentRepository.findById(studentId);

        if(!course.isPresent()) {
            throw new RuntimeException("Course not found.");
        }

        if(!student.isPresent()){
            throw new RuntimeException("Student not found.");
        }

        student.get().getCourses().remove(course.get());
        course.get().getStudents().remove(student.get());
    }

    @Override
    public void updateStudentCourses(Long studentId, Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        Optional<Student> student = studentRepository.findById(studentId);

        if(!course.isPresent()) {
            throw new RuntimeException("Course not found.");
        }

        if(!student.isPresent()){
            throw new RuntimeException("Student not found.");
        }

        student.get().getCourses().clear();
        student.get().getCourses().add(course.get());
        course.get().getStudents().add(student.get());
    }
}
