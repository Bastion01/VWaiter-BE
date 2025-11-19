FROM openjdk:25-ea-21-jdk-oraclelinux9
ARG JAR_FILE=payment-service-application/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]