package com.academy.edu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = StudentApplication.class)
@ConfigurationPropertiesScan
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }
    // arg 빼면 인자를 전달받을 수 없다.
}


/**
 * @SpringBootApplication 무슨 역할?
 * <p>
 * - 아래 3가지 핵심 어노테이션
 * @SpringBootConfiguration -> 설정으로 사용할 수 있다.
 * @EnableAutoConfiguration -> 자동설정 기능을 활성화 한다. 클래스 패스에 라이브러리 존재하면 자동으로 Bean 등록
 * @ComponentScan -> 경로 스캔해서 Bean 등록
 * <p>
 * Main Class
 * SpringApplication 실행 3가지 방법
 * 1. static 메소드 : 가장 일반적인 방법
 * 2. 생성자 사용 : static 메소드 내부에 동일한 구현
 * 3. 빌더 사  : 빌더로 여러 개의 web context를 구성할 수 있으며 parent-child 의 계층구조로 설정가능
 * @Conditional : 조건이 true일 때 Bean 동작
 */

/**
 * Main Class
 * SpringApplication 실행 3가지 방법
 * 1. static 메소드 : 가장 일반적인 방법
 * 2. 생성자 사용 : static 메소드 내부에 동일한 구현
 * 3. 빌더 사  : 빌더로 여러 개의 web context를 구성할 수 있으며 parent-child 의 계층구조로 설정가능
 */

/**
 * @Conditional : 조건이 true일 때 Bean 동작
 */