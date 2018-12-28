FROM maven:3.5.3-alpine
WORKDIR /usr/src
COPY . .
RUN mvn clean install && mv ./target/worker-0.0.1-SNAPSHOT.jar worker-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "worker-0.0.1-SNAPSHOT.jar"]