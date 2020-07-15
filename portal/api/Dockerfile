FROM openjdk:14
COPY build/libs/*.jar app.jar
RUN mkdir -p ~/Portal
ENTRYPOINT ["java","-jar","/app.jar"]