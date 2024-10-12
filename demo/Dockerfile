
FROM maven:3.8.6-openjdk-17-slim AS build
WORKDIR /app


COPY pom.xml .
RUN mvn dependency:go-offline


COPY src ./src
RUN mvn clean package -DskipTest


FROM openjdk:17-jdk-slim
WORKDIR /app


COPY --from=build /app/target/quiz-api.jar /app/quiz-api.jar

EXPOSE 8080


ENTRYPOINT ["java", "-jar", "/app/quiz-api.jar"]
