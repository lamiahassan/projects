FROM openjdk:8
EXPOSE 8080
ADD target/phone-validator-docker.jar phone-validator-docker.jar
ENTRYPOINT ["java","-jar","/phone-validator-docker.jar"]
