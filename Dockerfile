
FROM openjdk:17-alpine

COPY ./target/catalago-0.0.1-SNAPSHOT.jar /usr/src/maruin/

WORKDIR /usr/src/e-commerce

EXPOSE 8189

CMD ["java", "-jar", "catalago-0.0.1-SNAPSHOT.jar"]
