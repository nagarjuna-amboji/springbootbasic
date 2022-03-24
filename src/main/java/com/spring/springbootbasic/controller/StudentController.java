package com.spring.springbootbasic.controller;

import com.spring.springbootbasic.bean.Student;
import com.spring.springbootbasic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "ping")
    public String ping() {
        return "It's Working..!";
    }

    @GetMapping("students")
    public List<Student> getStudents() {
       return studentService.getStudents();
    }

    @PostMapping(path = "student/add")
    public String addNewStudent(@RequestBody Student student) throws IllegalAccessException {
        String str = null;
        String email = studentService.addNewStudent(student);
        return email;
    }

    @DeleteMapping(path="student/{id}")
    public Long deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return id;
    }

    @PutMapping("student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }
}
