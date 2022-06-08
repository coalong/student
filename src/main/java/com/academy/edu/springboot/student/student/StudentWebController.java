package com.academy.edu.springboot.student.student;

import com.academy.edu.springboot.student.student.config.StudentProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class StudentWebController {

    private final StudentService service;

    // FIXME 설정한 값 가져오기
    @Value("${nhn.student.name}")
    private String studentName;

    private StudentProperties properties;


    @GetMapping("/web/students/{id}")
    public String getStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", new Student(id,"zbum", 100));
        model.addAttribute("studentName", this.studentName);
        model.addAttribute("properties", properties);
        return "student";
    }
}
