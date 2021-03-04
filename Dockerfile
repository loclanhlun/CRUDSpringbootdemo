#FROM openjdk:8
#ADD target/docker-crud-spring-boot.jar docker-crud-spring-boot.jar

#EXPOSE 8085
#ENTRYPOINT ["java", "-jar", "docker-crud-spring-boot.jar"]

FROM openjdk:8-jdk-alpine
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/docker-spring-boot.jar"]