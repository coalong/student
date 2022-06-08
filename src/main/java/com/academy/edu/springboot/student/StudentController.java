package com.academy.edu.springboot.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable long id) {
        service.deleteStudent(id);
        return "{\"result\":\"ok\"}";
    }
}
