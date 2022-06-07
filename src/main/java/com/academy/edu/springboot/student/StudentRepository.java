package com.academy.edu.springboot.student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
}
