package com.academy.edu.springboot.config;

import com.academy.edu.springboot.account.AuthorController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AuthorController.class)
class AuthorPropertiesTest {

    @Autowired
    MockMvc mvc;

    @InjectMocks
    AuthorProperties authorProperties = new AuthorProperties("a0");

    @Test
    void testGetAuthor() throws Exception {
        // TODO
    }
}