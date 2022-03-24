package com.spring.springbootbasic.service;

import com.spring.springbootbasic.bean.Student;
import com.spring.springbootbasic.repository.StudentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public String addNewStudent(Student student) throws IllegalAccessException {
        boolean isExists = studentRepository.findByEmail(student.getEmail()).isPresent();
        if (isExists) {
            throw new IllegalAccessException("Email Id already exists");
        }
        studentRepository.save(student);
        return student.getEmail();
    }

    public Long deleteStudent(Long id) {
        boolean exists = studentRepository.findById(id).isPresent();
        if (!exists) {
            throw new IllegalStateException("Id does not exists.");
        }
        studentRepository.deleteById(id);
        return id;
    }

    public Student updateStudent(Long id, Student student) {

        Student studentPersist = studentRepository.findById(id).orElseThrow(() ->
                new IllegalStateException(" Student Id does not exists.")
        );

        studentPersist.setName(student.getName());
        studentPersist.setDob(student.getDob());
        studentPersist.setEmail(student.getEmail());

        final Student updatedStudent = studentRepository.save(studentPersist);
        return updatedStudent;
    }
}
