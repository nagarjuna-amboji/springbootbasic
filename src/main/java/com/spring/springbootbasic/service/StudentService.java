package com.spring.springbootbasic.service;

import com.spring.springbootbasic.bean.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Arjuna",
                        LocalDate.of(1990, 07, 17),
                        21,
                        "nagarjuna.a@gmail.com"
                )
        );
    }
}
