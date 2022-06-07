package com.academy.edu.springboot.student.account;


import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccount(String number);

    Account createAccount(Account account);

    void deleteAccount(String number);


}
