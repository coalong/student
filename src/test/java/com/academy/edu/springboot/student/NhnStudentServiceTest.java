package com.academy.edu.springboot.student;

import com.academy.edu.springboot.student.student.Student;
import com.academy.edu.springboot.student.student.StudentRepository;
import com.academy.edu.springboot.student.student.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class NhnStudentServiceTest {

    // test에서는 @Autowire 써줘야한다.
    @Autowired
    StudentRepository repository;
    
    @Test
    void testStudentRepository() {
        Student student = new Student(1L, "zum", 100);
        repository.save(student);

        Optional<Student> actual = repository.findById(1L);

        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(student);
    }
}