
FROM openjdk:17
WORKDIR /app
COPY /aos/target/aos-0.0.1-SNAPSHOT.jar /app/aos.jar
EXPOSE 8000
CMD ["java", "-jar", "/app/aos.jar"]

