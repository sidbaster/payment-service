FROM openjdk:26-ea-15-jdk-oraclelinux9

ARG JAR_FILE=payment-system-0.0.1-SNAPSHOT.jar

WORKDIR /app

COPY target/${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]