FROM openjdk:11
WORKDIR /app
COPY target/DevOps_Project-2.1.jar project.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "project.jar"]
