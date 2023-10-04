# Stage 1: Build the Spring Boot application
FROM maven:3.9.2-amazoncorretto-17 AS builder

# Set the working directory within the container
WORKDIR /app

# Copy the Maven project file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Create the final Docker image
FROM openjdk:17-jdk-alpine

# Set the working directory within the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port 6000 (or your desired port)
EXPOSE 6000

# Define the command to run the Spring Boot application
CMD ["java", "-jar", "app.jar", "--server.port=6000"]
