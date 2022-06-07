package com.academy.edu.springboot.student.account;

import java.util.List;

public class DummyAccountRepository implements AccountRepository{

    @Override
    public List<Account> findAll() {
        return null;
    }
}
