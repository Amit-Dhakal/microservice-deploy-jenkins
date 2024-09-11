FROM openjdk:17
EXPOSE 2001
ADD target/microservice-security-image.jar microservice-security-image
COPY libs/microservice-security-image.jar microservice-security-image
ENTRYPOINT ["java","-jar","microservice-security-image.jar"]
