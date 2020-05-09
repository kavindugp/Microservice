package com.example.krish.Controller;

import com.example.krish.Model.Student;
import com.example.krish.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/student")
    public ResponseEntity<Student> fetchStudent(@RequestParam int id) {

        Student student = studentService.fetchStudentById(id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(student);
        }
    }

    @GetMapping("/all")
    public List<Student> allUsers(){
        return studentService.findAllUsers();
    }

    @PutMapping("/update")
    public String editUser(@RequestBody Student student){
        return studentService.updateUser(student);

    }

    @DeleteMapping("/student/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }
}