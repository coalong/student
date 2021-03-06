package com.academy.edu.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.nhn.account")
@Data
public class AuthorProperties {

    private String author;

}
