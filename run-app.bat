@echo off
echo Cleaning the project...
mvn clean

echo Setting Java version to 1.8...
mvn -B -U -DskipTests=true -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8 compile

echo Starting Spring Boot Application...
mvn spring-boot:run -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8

pause
