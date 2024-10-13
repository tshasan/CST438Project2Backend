
# Stage 1: Build the application
FROM openjdk:17-jdk-slim AS build
WORKDIR /Project2Backend

# Copy necessary files for the build
COPY Project2Backend/gradlew .
COPY Project2Backend/gradle gradle
COPY Project2Backend/build.gradle .
COPY Project2Backend/settings.gradle .
COPY Project2Backend/src src

# Run the build process
RUN chmod +x gradlew && ./gradlew build

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim
WORKDIR /Project2Backend

# Copy the built JAR file from the previous stage
COPY --from=build /Project2Backend/build/libs/Project2Backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Use environment variable for server port
ENTRYPOINT ["java", "-jar", "app.jar"]
CMD ["--server.port=8080"]
