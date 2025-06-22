# Quick Start Guide

Since you're having some issues with the batch files, here's a streamlined guide to run your application:

## In PowerShell (Recommended)

1. **Compile and package the application**:
   ```powershell
   mvn clean package
   ```

2. **Run the application**:
   ```powershell
   mvn spring-boot:run
   ```

## Application Access

- **Main API**: http://localhost:8080/api/students
- **H2 Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:testdb` (make sure it's exactly this)
  - Username: `sa`
  - Password: `password`
  - Make sure to click "Connect" button after entering these details

## Common Issues

### Java Version Issues
If you encounter an error about class version 61.0, it means the application was compiled with Java 17 but is being run with an older Java version. To fix:

1. Run this command to clean and recompile: 
   ```powershell
   mvn clean compile -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8
   ```

2. Then run the application:
   ```powershell
   mvn spring-boot:run
   ```

### H2 Database Connection Issues
If you see the error "Database not found" when connecting to the H2 console:

1. Make sure the application is running (you should see Spring Boot logs in the terminal)
2. Check that you're using the exact JDBC URL: `jdbc:h2:mem:testdb`
3. Try using `jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1` if the above doesn't work
4. Restart the application if needed
5. Make sure you're using username `sa` and password `password`

## Need Help?

For detailed instructions, see:
- ASSIGNMENT_GUIDE.md - Full project details
- JAVA_VERSION_GUIDE.md - Java version compatibility info
