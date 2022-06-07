package com.academy.edu.springboot.student;

import com.academy.edu.springboot.student.student.Student;
import com.academy.edu.springboot.student.student.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class NhnStudentServiceTest {

    // test에서는 @Autowire 써줘야한다.
    @Autowired
    StudentService studentService;
    
    @Test
    void getStudents() {
        //test
        List<Student> students = studentService.getStudents();

        //Assertion
        Assertions.assertThat(students).hasSize(2);
    }
}