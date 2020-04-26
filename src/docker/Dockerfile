FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY *.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
