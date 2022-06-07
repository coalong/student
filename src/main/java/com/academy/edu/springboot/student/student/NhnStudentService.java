package com.academy.edu.springboot.student.student;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
// @RequiredArgsConstructor 대상 되는 것 : private final인 변수
public class NhnStudentService implements StudentService{
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
