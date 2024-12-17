FROM openjdk:17-oracle

WORKDIR /app

COPY build/libs/console-app-students-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/default-students.txt /app/default-students.txt
COPY src/main/resources/application.properties /app/application.properties

CMD ["java","-jar","app.jar"]

