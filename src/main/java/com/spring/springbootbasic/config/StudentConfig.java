package com.spring.springbootbasic.config;

import com.spring.springbootbasic.bean.Student;
import com.spring.springbootbasic.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {

            Student arjun = new Student(
                            "Arjuna",
                            LocalDate.of(1990, Month.JULY, 17),
                            "nagarjuna.a@gmail.com"
                    );
            Student vani = new Student(
                    "Vani",
                    LocalDate.of(1992, Month.APRIL, 22),
                    "amboji.vani@gmail.com"
            );

            studentRepository.saveAll(
                    List.of(arjun, vani)
            );

        };
    }
}
