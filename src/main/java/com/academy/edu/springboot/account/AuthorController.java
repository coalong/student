package com.academy.edu.springboot.account;


import com.academy.edu.springboot.config.AuthorProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    //FIXME 의존성 주입
    private final AuthorProperties authorProperties;

    @GetMapping("/system/author")
    public SystemInfo getAuthor() {
        return new SystemInfo(authorProperties.getAuthor());
    }

    // FIXME 클래스 분리해서 생성, 깨지는 경우 있어서
    @RequiredArgsConstructor
    @Getter
    static class SystemInfo {
        private final String author;
    }
}
