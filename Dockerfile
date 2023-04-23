FROM java:11
WORKDIR /
ADD postagem-0.0.1-SNAPSHOT.jar ./target/postagem-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java - jar postagem-0.0.1-SNAPSHOT.jar
