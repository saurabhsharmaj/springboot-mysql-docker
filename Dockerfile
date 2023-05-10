FROM openjdk:17-jdk-slim
WORKDIR /opt
ENV PORT 8082
EXPOSE 8082
COPY target/demo-0.0.1-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar