# H2 Database Troubleshooting

If you're experiencing issues connecting to the H2 database, here are detailed steps to resolve them:

## H2 Database Connection Error

### Issue Description
Error message: 
```
Database "C:/Users/User/test" not found, either pre-create it or allow remote database creation
```

### Solution Steps

1. **Verify the application is running properly**
   - Look for messages in the console that say the application started successfully
   - You should see something like: "Started StudentManagementSystemApplication in x.xxx seconds"

2. **Connect to H2 console with the right parameters**
   - Open your browser and navigate to: http://localhost:8080/h2-console
   - Use these exact settings:
     - Driver Class: `org.h2.Driver`
     - JDBC URL: `jdbc:h2:mem:testdb` (this is critical)
     - User Name: `sa`
     - Password: `password`

3. **Try alternative JDBC URLs if the above doesn't work**:
   - `jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1`
   - `jdbc:h2:mem:testdb;DB_CLOSE_ON_EXIT=FALSE`

4. **If still not working, try restarting**:
   - Stop the current application (press Ctrl+C in the terminal)
   - Clean the project: `mvn clean`
   - Start again: `mvn spring-boot:run`

5. **Last resort - create a file-based database**
   - Edit `application.properties`
   - Change the database URL: `spring.datasource.url=jdbc:h2:file:./data/testdb`

## Sample SQL Commands for Your Data

### Insert Your Information
```sql
INSERT INTO STUDENT (NAME, EMAIL, PHONE_NUMBER, COURSE, YEAR_OF_STUDY) 
VALUES ('Amar Hassan', 'amargouda@graduate.utm.my', '01164153312', 'Software Engineering', 4);
```

### Query Your Information
```sql
SELECT * FROM STUDENT WHERE EMAIL = 'amargouda@graduate.utm.my';
```

### Update Your Course Information
```sql
UPDATE STUDENT 
SET COURSE = 'Software Construction' 
WHERE EMAIL = 'amargouda@graduate.utm.my';
```

## H2 Console Screenshot Reference

When connecting to the H2 Console, your screen should look like this:

```
+-----------------------------------------+
| Login                                   |
+-----------------------------------------+
| Saved Settings: Generic H2 (Embedded)   |
| Setting Name:  Generic H2 (Embedded)    |
+-----------------------------------------+
| Driver Class:  org.h2.Driver            |
| JDBC URL:      jdbc:h2:mem:testdb       |
| User Name:     sa                       |
| Password:      [password]               |
+-----------------------------------------+
| [Connect]      [Test Connection]        |
+-----------------------------------------+
```

Make sure all fields match exactly as shown above, especially the JDBC URL.
