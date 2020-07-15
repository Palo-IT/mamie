FROM openjdk:14
COPY build/libs/*.jar app.jar
RUN mkdir -p ~/FakeLoad
ENTRYPOINT ["java","-jar","/app.jar"]