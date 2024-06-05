FROM amazoncorretto:17-alpine-jdk

MAINTAINER alex.samusev.81@gmail.com

COPY target/recipe-app-back-0.0.1-SNAPSHOT.jar recipe-app-back-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","recipe-app-back-0.0.1-SNAPSHOT.jar"]