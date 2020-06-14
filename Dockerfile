FROM openjdk:8-jdk-alpine

#WORKDIR /Users/phollakrit.k/Desktop/Test_Project/proto1

ARG JAR_FILE=target/proto1-0.1.jar

#RUN cd /Users/phollakrit.k/Desktop/Test_Project/proto1/target

COPY ${JAR_FILE} app.jar

EXPOSE 8443

ENTRYPOINT ["java","-jar","/app.jar"]./