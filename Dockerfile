# ============================
# 1) Build Stage (Maven)
# ============================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# ============================# ============================
# 1) Build Stage (Maven + Java 17)
# ============================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Build the JAR without running tests
RUN mvn clean package -DskipTests

# ============================
# 2) Runtime Stage (Java 17)
# ============================
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]

# 2) Runtime Stage
# ============================
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]
