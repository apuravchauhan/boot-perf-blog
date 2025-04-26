# ✅ Use Eclipse Temurin JDK 21 as the base image
FROM eclipse-temurin:21-jdk AS build

# ✅ Set working directory
WORKDIR /app

# ✅ Copy the Spring Boot JAR into the container
COPY target/*.jar app.jar

# ✅ Expose the application port (Spring Boot default: 8080)
EXPOSE 8080

# ✅ Start Java WITH automatic container limits (No need for -XX:ActiveProcessorCount=1 in Java 21)
CMD ["java", "-jar", "app.jar"]