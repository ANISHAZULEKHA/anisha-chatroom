FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean package

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
