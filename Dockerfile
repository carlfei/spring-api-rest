FROM maven:3.8.5-openjdk-17 AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package
#pull base image
FROM eclipse-temurin:17
#maintainer
MAINTAINER jus@yahoooo.com
#expose port 8080
EXPOSE 8080
#default command
CMD java -jar /data/accessing-data-0.0.1-SNAPSHOT.jar
COPY --from=maven_build /tmp/target/accessing-data-0.0.1-SNAPSHOT.jar /data/accessing-data-0.0.1-SNAPSHOT.jar