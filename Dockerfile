FROM openjdk:21-jdk-slim
LABEL authors="esteban429"
WORKDIR /app
COPY target/curso-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"