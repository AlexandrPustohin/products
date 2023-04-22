FROM openjdk:17-oracle
ARG JAR_FILE=target/products-0.0.1-SNAPSHOT.jar
EXPOSE 8089
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]