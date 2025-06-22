package com.studentmanagementsystem.config;

import com.studentmanagementsystem.model.Student;
import com.studentmanagementsystem.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(StudentRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Student(null, "John Doe", "john.doe@example.com", "+1234567890", "Computer Science", 2));
                repository.save(new Student(null, "Jane Smith", "jane.smith@example.com", "+1987654321", "Business", 3));
                repository.save(new Student(null, "Adam Johnson", "adam.johnson@example.com", "+1122334455", "Engineering", 1));
                repository.save(new Student(null, "Emily Davis", "emily.davis@example.com", "+1555666777", "Medicine", 4));
                repository.save(new Student(null, "Michael Lee", "michael.lee@example.com", "+1888999000", "Computer Science", 2));
            }
        };
    }
}
