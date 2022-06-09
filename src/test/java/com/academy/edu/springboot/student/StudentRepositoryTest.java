package com.academy.edu.springboot.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


// TestEntityManager를 주입 받아오는 어노테이션
@DataJpaTest
// 실제 Database 접근하여 테스트하도록 설정
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findAll() {
        Student aymin = new Student(1L, "aymin", 100);
        testEntityManager.persist(aymin);

        List<Student> actual = studentRepository.findAll();
        assertThat(actual).contains(aymin);
    }
}