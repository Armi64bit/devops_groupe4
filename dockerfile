FROM openjdk:11
ADD target/DevOps_Project-2.1 project.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "project.jar"]