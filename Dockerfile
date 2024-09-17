# Use an official Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Define build arguments
ARG POSTGRESQL_URL
ARG POSTGRESQL_PORT
ARG POSTGRESQL_SCHEMA
ARG POSTGRESQL_USER
ARG POSTGRESQL_PASSWORD

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use an official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Set environment variables
# Set environment variables
ENV POSTGRESQL_URL=${POSTGRESQL_URL}
ENV POSTGRESQL_PORT=${POSTGRESQL_PORT}
ENV POSTGRESQL_SCHEMA=${POSTGRESQL_SCHEMA}
ENV POSTGRESQL_USER=${POSTGRESQL_USER}
ENV POSTGRESQL_PASSWORD=${POSTGRESQL_PASSWORD}

# Copy the packaged jar file from the build stage
COPY --from=build /app/target/quick-cloth-data-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]