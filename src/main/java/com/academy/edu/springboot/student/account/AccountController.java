package com.academy.edu.springboot.student.account;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;

    @GetMapping("/account/{number}")
    public Account getAccount(@PathVariable String number) {
        return service.getAccount(number);
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return service.getAccounts();
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @DeleteMapping("/accoubt/{number}")
    public String deleteAccount(@PathVariable String number) {
        service.deleteAccount(number);
        return "{\"result\":\"ok\"}";
    }
}
