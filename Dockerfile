FROM openjdk:11
WORKDIR /
ADD postagem-0.0.1-SNAPSHOT.jar postagem-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java - jar postagem-0.0.1-SNAPSHOT.jar
