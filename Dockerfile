#FROM ubuntu:latest
#LABEL authors="USER"

#ENTRYPOINT ["top", "-b"]
#-----------------------------------
#FROM openjdk:17
#VOLUME /tmp
#EXPOSE 6500
#ADD ./target/userMicroservice-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM openjdk:17-jdk-alpine
COPY target/userMicroservice-0.0.1-SNAPSHOT.jar userMicroserviceApp.jar
ENTRYPOINT ["java", "-jar", "/userMicroserviceApp.jar"]