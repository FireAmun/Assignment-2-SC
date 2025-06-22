package com.studentmanagementsystem.service;

import com.studentmanagementsystem.model.Student;
import com.studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    // Functionality 1: Create/Register a student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    // Functionality 2: Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    // Functionality 3: Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    // Functionality 4: Update student details
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setCourse(studentDetails.getCourse());
        student.setYearOfStudy(studentDetails.getYearOfStudy());
        
        return studentRepository.save(student);
    }
    
    // Functionality 5: Delete student
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        studentRepository.delete(student);
    }
    
    // Additional methods
    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
    
    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }
    
    public List<Student> getStudentsByYear(int year) {
        return studentRepository.findByYearOfStudy(year);
    }
}
