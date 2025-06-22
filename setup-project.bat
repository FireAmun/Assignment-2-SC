@echo off
echo ======================================
echo  Student Management System Setup
echo ======================================

echo [1/4] Checking Java version...
java -version
echo.

echo [2/4] Cleaning project...
call mvn clean
echo.

echo [3/4] Compiling with Java 8 compatibility...
call mvn -B -U -DskipTests=true -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8 compile
echo.

echo [4/4] Creating a runnable JAR file...
call mvn -B -DskipTests=true -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8 package

echo ======================================
echo Setup complete! You can now:
echo 1. Run the application with: java -jar target\studentmanagementsystem-0.0.1-SNAPSHOT.jar
echo 2. Or use run-app.bat to start it directly
echo ======================================

pause
