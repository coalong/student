package com.academy.edu.springboot.student;

import java.util.List;

public class DummyStudentRepository implements StudentRepository{

    @Override
    public List<Student> findAll() {
        return null;
    }
}
