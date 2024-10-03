FROM openjdk:17-jdk-slim

WORKDIR /APP

COPY build/libs/Project2Backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar --server.port=${PORT:-8080}"]