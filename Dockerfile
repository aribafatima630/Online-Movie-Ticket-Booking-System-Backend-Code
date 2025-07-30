# -------- Build Stage --------
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copy pom.xml separately for dependency caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Package the application (skip tests)
RUN mvn clean package -DskipTests

# -------- Run Stage --------
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the built JAR file from build stage
COPY --from=build /app/target/QuickTickets.Management-0.0.1-SNAPSHOT.jar app.jar

# Expose the Spring Boot default port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]