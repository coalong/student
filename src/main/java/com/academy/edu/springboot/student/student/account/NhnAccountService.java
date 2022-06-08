package com.academy.edu.springboot.student.student.account;

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

    @Override
    public Account getAccount(String number) {
        return accountRepository.findById(number)
                .orElseThrow();
    }

    @Override
    public Account createAccount(Account account) {
        boolean present = accountRepository.findById(account.getNumber()).isPresent();
        if (present) throw new IllegalStateException("already exist" + account.getNumber());
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String number) {
        accountRepository.deleteById(number);
    }
}
