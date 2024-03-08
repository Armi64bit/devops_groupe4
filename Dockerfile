FROM openjdk:17

ADD http://192.168.88.131:8081/repository/maven-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]