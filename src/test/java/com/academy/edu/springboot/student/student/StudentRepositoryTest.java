package com.academy.edu.springboot.student.student;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class StudentRepositoryTest {

    // 왜 test에서는 autowire 주입방식?
    @Autowired
    StudentRepository repository;

    @Test
        // Junit8 부터 접근제한자 수정 필요없다.
    void testStudentRepository() {
        // data
        Student coalong = new Student(1L, "minay", 100);
        repository.save(coalong);

        Optional<Student> student = repository.findById(1L);

        // Assertions
        Assertions.assertThat(student).isPresent();
        Assertions.assertThat(student.orElse(null)).isEqualTo(coalong);
        // orElse(null)  이게 뭐지?
        // h2 DB 설정 안했는데 왜 되는거지? 기본 설정으로 다 잡아둔다.

    }
}