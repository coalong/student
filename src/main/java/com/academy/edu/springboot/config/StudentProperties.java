package com.academy.edu.springboot.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "nhn-academy.student")
@Data
public class StudentProperties {

    private Integer age;

    private String myName;

}
