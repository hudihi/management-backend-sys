package com.hudihi.sms.features.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hudihi.sms.features.student.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
