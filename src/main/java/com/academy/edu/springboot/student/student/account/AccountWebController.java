package com.academy.edu.springboot.student.student.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AccountWebController {
    private final AccountService service;

}
