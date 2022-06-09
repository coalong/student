package com.academy.edu.springboot.student;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentRandomPortControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    // TODO randomPort 설정하는 부분 코드 작성
    @LocalServerPort
    private Integer randomPort;

    @Test
    @Order(1)
    void testGetStudents() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<List<Student>> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<List<Student>> students = restTemplate.exchange("/students",
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<List<Student>>() {
                });
        assertThat(students.getBody())
                .isEqualTo(new Student(1L, "manty", 100));
    }

    @Test
    @Order(2)
    void testGetStudent() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Student> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Student> student = restTemplate.exchange("/student/{id}",
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<Student>() {
                });
        assertThat(student.getBody())
                .isEqualTo(new Student(1L, "manty", 100));

    }

    @Test
    @Order(3)
    void testCreateStudent() {

    }

    @Test
    @Order(4)
    void testDeleteStudent() {

    }
}