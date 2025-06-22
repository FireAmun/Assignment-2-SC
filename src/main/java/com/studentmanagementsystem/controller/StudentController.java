package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.model.Student;
import com.studentmanagementsystem.service.StudentService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    // REST API 1: Create a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student newStudent = studentService.createStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
    
    // REST API 2: Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // Get a specific student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Update student information
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        try {
            Student updatedStudent = studentService.updateStudent(id, student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Search students by name
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam String name) {
        List<Student> students = studentService.searchStudentsByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // Get students by course
    @GetMapping("/course/{course}")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable String course) {
        List<Student> students = studentService.getStudentsByCourse(course);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // Get students by year
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Student>> getStudentsByYear(@PathVariable int year) {
        List<Student> students = studentService.getStudentsByYear(year);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
