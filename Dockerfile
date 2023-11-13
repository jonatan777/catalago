
FROM openjdk:17-alpine
COPY ./target/catalago-0.0.1-SNAPSHOT.jar /usr/src/maruin/
WORKDIR /usr/src/maruin

EXPOSE 8176

CMD ["java", "-jar", "catalago-0.0.1-SNAPSHOT.jar"]
