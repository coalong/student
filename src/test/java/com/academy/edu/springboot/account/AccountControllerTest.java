package com.academy.edu.springboot.account;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Order(1)
    void testGetAccount() throws Exception{
        this.mvc.perform(get("/account/{number}"))
    }

    @Test
    @Order(2)
    void testGetAccounts() throws Exception{
        this.mvc.perform(get("/accounts"))
    }

    @Test
    @Order(3)
    void testCreateAccount() throws Exception{
        this.mvc.perform(post("/account"))
    }

    @Test
    @Order(4)
    void testDeleteAccount() throws Exception{
        this.mvc.perform(delete("/account/{id}", "123"))

    }
}