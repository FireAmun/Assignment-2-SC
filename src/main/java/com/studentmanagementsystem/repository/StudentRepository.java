package com.studentmanagementsystem.repository;

import com.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByCourse(String course);
    List<Student> findByYearOfStudy(int yearOfStudy);
}
