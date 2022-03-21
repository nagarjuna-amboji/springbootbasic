package com.spring.springbootbasic.controller;

import com.spring.springbootbasic.bean.Student;
import com.spring.springbootbasic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
