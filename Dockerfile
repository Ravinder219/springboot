# ============================
# 1) Build Stage (Maven + Java 17)
# ============================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven config first (for layer caching)
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build JAR (skip tests)
RUN mvn clean package -DskipTests


# ============================
# 2) Runtime Stage (Java 17)
# ============================
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
