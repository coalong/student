package com.academy.edu.springboot.student.account;


import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
}
