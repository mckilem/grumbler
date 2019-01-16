FROM openjdk:8-jdk-alpine
COPY /target/com.angrybeard.grumbler-app.jar /home/com.angrybeard.grumbler-app.jar
CMD ["java","-jar","/home/com.angrybeard.grumbler-app.jar"]