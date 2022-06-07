package com.academy.edu.springboot.student.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NhnAccountService implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
