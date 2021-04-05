FROM openjdk:11
VOLUME /tmp
ADD ./target/ms-oauth-0.0.1-SNAPSHOT.jar oauth.jar
ENTRYPOINT ["java","-jar","/oauth.jar"]