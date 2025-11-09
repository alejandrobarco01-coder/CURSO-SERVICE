# Etapa 1: Construcción con Maven
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos los archivos del proyecto
COPY pom.xml .
COPY src ./src

# Compilamos el proyecto (omitimos tests para acelerar)
ENV LANG=C.UTF-8
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final ligera
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiamos el jar compilado desde la primera etapa
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto del microservicio
EXPOSE 8081

# Comando de ejecución
ENTRYPOINT ["java", "-jar", "app.jar"]
