package com.example.krish.Service;

import com.example.krish.Model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student save(Student student);

    Student fetchStudentById(int id);

    List<Student> findAllUsers();

    String updateUser(Student userDao);

    void delete(int id);
}
