FROM openjdk:8
COPY ./target/postagem-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/src/postagem/
WORKDIR /usr/src/postagem
EXPOSE 8080
CMD ["java", "-jar", "postagem-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]