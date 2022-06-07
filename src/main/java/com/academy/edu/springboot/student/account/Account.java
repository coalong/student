package com.academy.edu.springboot.student.account;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    private String number;
    private Integer balance;
}
