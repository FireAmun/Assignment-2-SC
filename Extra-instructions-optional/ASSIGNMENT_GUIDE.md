# Student Management System - Assignment Guide

## Project Overview
This is a Student Management System built using Spring Boot framework for Assignment 2 in Software Construction.

## Five Main Functionalities
1. **Create/Register students** - Adding new student records to the system
2. **View all students** - Displaying a list of all registered students
3. **View student details** - Seeing detailed information about a specific student
4. **Update student information** - Modifying existing student records
5. **Delete students** - Removing students from the system

## Two REST API Web Services
1. **Create Student API** - POST /api/students
2. **Get All Students API** - GET /api/students

## Setup Instructions

### Prerequisites
- Java 8 or later
- Maven 3.6 or later
- Postman (for API testing)

### Running the Application
1. Open a command prompt or PowerShell in the project directory
2. Run the application using one of these methods:
   - Using PowerShell script: `.\run-app.ps1`
   - Using batch file in Command Prompt: `run-app.bat`
   - Using batch file in PowerShell: `.\run-app.bat` or `& .\run-app.bat`
   - Using Maven directly: `mvn spring-boot:run`
3. The application will start on port 8080
4. Access the H2 database console at http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:mem:testdb
   - Username: sa
   - Password: password

## API Testing with Postman

Import the Postman collection file (`Student_Management_System_Postman_Collection.json`) and test the following endpoints:

### 1. Create a Student (POST)
- URL: http://localhost:8080/api/students
- Method: POST
- Body (JSON):
```json
{
  "name": "New Student",
  "email": "new.student@example.com",
  "phoneNumber": "+1234567890",
  "course": "Data Science",
  "yearOfStudy": 3
}
```

### 2. Get All Students (GET)
- URL: http://localhost:8080/api/students
- Method: GET

### 3. Get Student by ID (GET)
- URL: http://localhost:8080/api/students/{id}
- Method: GET
- Replace {id} with an actual student ID

### 4. Update Student (PUT)
- URL: http://localhost:8080/api/students/{id}
- Method: PUT
- Replace {id} with an actual student ID
- Body (JSON):
```json
{
  "name": "Updated Name",
  "email": "updated.email@example.com",
  "phoneNumber": "+9876543210",
  "course": "Computer Science",
  "yearOfStudy": 2
}
```

### 5. Delete Student (DELETE)
- URL: http://localhost:8080/api/students/{id}
- Method: DELETE
- Replace {id} with an actual student ID

## Video Recording Guidelines

For the assignment submission, record a video (less than 5 minutes) covering:

1. **Spring Boot Setup**
   - Briefly explain the project structure
   - Show the main configuration files (pom.xml, application.properties)
   - Mention the dependencies used

2. **REST API Setup**
   - Explain the controller class and its endpoints
   - Show the model class and its validation
   - Demonstrate the service layer and repository

3. **Postman Testing**
   - Show how to create a new student via API
   - Show how to retrieve the list of students
   - Show how to update and delete students

4. **Application Demo**
   - Show the application running
   - Demonstrate the H2 console to view the database

## Project Structure
```
student-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── studentmanagementsystem/
│   │   │           ├── controller/
│   │   │           │   └── StudentController.java
│   │   │           ├── model/
│   │   │           │   └── Student.java
│   │   │           ├── repository/
│   │   │           │   └── StudentRepository.java
│   │   │           ├── service/
│   │   │           │   └── StudentService.java
│   │   │           ├── config/
│   │   │           │   └── DataLoader.java
│   │   │           └── StudentManagementSystemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
├── pom.xml
└── README.md
```

