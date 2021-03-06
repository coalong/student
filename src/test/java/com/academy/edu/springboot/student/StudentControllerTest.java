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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    void testGetStudents() throws Exception {
        this.mvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", equalTo("manty")));
    }

    @Test
    @Order(2)
    void testGetStudent() throws Exception {
        this.mvc.perform(get("/student/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("manty")))
                .andExpect(jsonPath("$.score", equalTo(100)));
    }

    @Test
    @Order(3)
    void testCreateStudent() throws Exception {
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
    void testDeleteStudent() throws Exception {
        this.mvc.perform(delete("/students/{id}", 4L))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}

/**
 * test ??????????????? ??? ??? ?????? ??????
 * 1. ORDER ???????????? ????????? ?????? ????????????
 * 2. transactional ????????? test ????????? ???????????? DB??? ?????? ?????????
 */