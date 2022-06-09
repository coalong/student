package com.academy.edu.springboot.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @Transactional
class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Order(1)
    void testGetStudents() throws Exception{
        this.mvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", equalTo("manty")));
    }

    @Test
    @Order(2)
    void testGetStudent() throws Exception{
        this.mvc.perform(get("/student/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("manty")))
                .andExpect(jsonPath("$.score", equalTo(100)));
    }

    @Test
    @Order(3)
    void testCreateStudent() throws Exception{
        Student young = new Student(5L, "mini", 100);
        String requestBody = new ObjectMapper().writeValueAsString(young);
        this.mvc.perform(
                post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(5)));
    }

    @Test
    @Order(4)
    void testDeleteStudent() throws Exception{
        this.mvc.perform(delete("/students/{id}"))
                .andExpect(status().isOk());
    }
}

/**
 * test 일관성있게 할 수 있게 방법
 * 1. ORDER 사용해서 한번에 모든 실행하게
 * 2. transactional 걸어서 test 끝나면 롤백되서 DB에 저장 안되게
 */