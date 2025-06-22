# Student Management System

This is a Spring Boot application for managing student records. It provides five main functionalities, with two of them exposed as REST APIs.

## Functionalities

1. **Create Student**: Register a new student with their details
2. **Get All Students**: View a list of all registered students
3. **Get Student by ID**: View details of a specific student
4. **Update Student**: Modify existing student information
5. **Delete Student**: Remove a student from the system

## REST APIs

The following functionalities are exposed as REST APIs:

1. **Create Student API**: POST /api/students
2. **Get All Students API**: GET /api/students

## Other APIs

3. **Get Student by ID**: GET /api/students/{id}
4. **Update Student**: PUT /api/students/{id}
5. **Delete Student**: DELETE /api/students/{id}
6. **Search Students**: GET /api/students/search?name={name}
7. **Get Students by Course**: GET /api/students/course/{course}
8. **Get Students by Year**: GET /api/students/year/{year}

## Technology Stack

- Spring Boot 3.2.1
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Validation API

## Setup Instructions

1. Clone this repository
2. Make sure you have Java 8 or later and Maven installed
3. Run the setup script to prepare the project:
   ```
   # In Command Prompt
   setup-project.bat
   
   # In PowerShell
   .\setup-project.bat
   ```
4. Run the application using the provided batch file:
   ```
   # In Command Prompt
   run-app.bat
   
   # In PowerShell
   .\run-app.bat
   ```
5. Or manually using the Maven command:
   ```
   mvn clean spring-boot:run -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8
   ```
5. Access the H2 console at http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:mem:testdb
   - Username: sa
   - Password: password

## Testing with Postman

1. Import the Postman collection included in this repository
2. Test the following endpoints:
   - Create Student: POST http://localhost:8080/api/students
   - Get All Students: GET http://localhost:8080/api/students
   - Get Student by ID: GET http://localhost:8080/api/students/{id}
   - Update Student: PUT http://localhost:8080/api/students/{id}
   - Delete Student: DELETE http://localhost:8080/api/students/{id}

