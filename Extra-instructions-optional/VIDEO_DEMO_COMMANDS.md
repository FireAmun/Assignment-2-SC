# SQL Commands for Video Demo

Use these commands during your video presentation to demonstrate both the H2 database console and the REST API functionality.

## H2 Console Demo Commands

### 1. View All Students
```sql
SELECT * FROM STUDENT;
```

### 2. Insert Your Personal Information
```sql
INSERT INTO STUDENT (NAME, EMAIL, PHONE_NUMBER, COURSE, YEAR_OF_STUDY) 
VALUES ('Amar Hassan', 'amargouda@graduate.utm.my', '01164153312', 'Software Engineering', 4);
```

### 3. Query Students by Course
```sql
SELECT * FROM STUDENT WHERE COURSE = 'Software Engineering';
```

### 4. Update Your Course Details
```sql
UPDATE STUDENT 
SET COURSE = 'Software Construction SCSJ4383' 
WHERE EMAIL = 'amargouda@graduate.utm.my';
```

### 5. Delete a Student Record
```sql
-- First add a test student that we can delete
INSERT INTO STUDENT (NAME, EMAIL, PHONE_NUMBER, COURSE, YEAR_OF_STUDY) 
VALUES ('Test Student', 'test.delete@example.com', '0000000000', 'Test Course', 1);

-- Then delete that student
DELETE FROM STUDENT WHERE EMAIL = 'test.delete@example.com';
```

## REST API Demo with Postman

### 1. GET All Students
- Method: GET
- URL: http://localhost:8080/api/students
- Expected result: List of all students in JSON format

### 2. POST Create New Student (Your Information)
- Method: POST
- URL: http://localhost:8080/api/students
- Body (raw JSON):
```json
{
  "name": "Amar Hassan",
  "email": "amargouda@graduate.utm.my",
  "phoneNumber": "01164153312",
  "course": "Software Engineering",
  "yearOfStudy": 4
}
```
- Expected result: Newly created student record with ID assigned

### 3. GET Student by ID
- Method: GET
- URL: http://localhost:8080/api/students/{id}
- Replace {id} with the ID from the previous response
- Expected result: Single student record matching that ID

### 4. PUT Update Student
- Method: PUT
- URL: http://localhost:8080/api/students/{id}
- Replace {id} with the ID from the previous response
- Body (raw JSON):
```json
{
  "name": "Amar Hassan",
  "email": "amargouda@graduate.utm.my",
  "phoneNumber": "01164153312",
  "course": "Software Construction SCSJ4383",
  "yearOfStudy": 4
}
```
- Expected result: Updated student record

### 5. DELETE Student
- Method: DELETE
- URL: http://localhost:8080/api/students/{id}
- Use an ID that's safe to delete
- Expected result: 204 No Content status code

### 6. Search Students by Name
- Method: GET
- URL: http://localhost:8080/api/students/search?name=Amar
- Expected result: List of students with "Amar" in their name

### 7. Get Students by Course
- Method: GET
- URL: http://localhost:8080/api/students/course/Software%20Engineering
- Expected result: List of students in the Software Engineering course
