# Build stage
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copy pom.xml first for better caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Production stage
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/QuickTickets.Management-0.0.1-SNAPSHOT.jar /app/QuickTickets.Management-0.0.1-SNAPSHOT.jar

# Expose port
EXPOSE 1000


# Verify file

# Verify file existence
RUN ls -l /app

ENTRYPOINT ["java", "-jar", "/app/QuickTickets.Management-0.0.1-SNAPSHOT.jar"]