FROM eclipse-temurin:17-jdk

WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

COPY . .

RUN mvn clean package

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
