package com.academy.edu.springboot.student.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NhnAccountServiceTest {

    @Autowired
    AccountRepository repository;

    @Test
    void getAccounts() {
    }
}