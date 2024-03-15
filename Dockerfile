FROM openjdk:17
RUN wget http://192.168.26.134:8081/service/rest/repository/browse/maven-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "DevOps_Project-2.1.jar"]
