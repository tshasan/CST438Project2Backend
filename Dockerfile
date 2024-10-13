
# Stage 1
FROM openjdk:17-jdk-slim AS build
WORKDIR /Project2Backend
COPY Project2Backend/gradlew .
COPY Project2Backend/gradle gradle
COPY Project2Backend/build.gradle .
COPY Project2Backend/settings.gradle .
COPY Project2Backend/src src
RUN ./gradlew build

# Stage 2:
FROM openjdk:17-jdk-slim
WORKDIR /Project2Backend
COPY --from=build /Project2Backend/build/libs/Project2Backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT:-8080}"]

