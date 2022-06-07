package com.academy.edu.springboot.student.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {


	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}


/**
 * @SpringBootApplication 무슨 역할?
 *
 * - 아래 3가지 핵심 어노테이션
 * @SpringBootConfiguration -> 설정으로 사용할 수 있다.
 * @EnableAutoConfiguration -> 자동설정 기능을 활성화 한다. 클래스 패스에 라이브러리 존재하면 자동으로 Bean 등록
 * @ComponentScan -> 경로 스캔해서 Bean 등록
 */