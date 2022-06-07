package com.academy.edu.springboot.student.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Account {
    private final String number;
    private final Integer balance;
}
