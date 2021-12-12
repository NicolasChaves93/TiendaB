FROM openjdk:11-jdk-slim
COPY "./target/tiendaB-0.0.1-SNAPSHOT.war" "app.war"
EXPOSE 8084
ENTRYPOINT ["java","-jar","app.war"]
