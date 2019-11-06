FROM openjdk:8-jdk-alpine
EXPOSE 8090
ADD /target/k8s-jenkins-example-0.0.1-SNAPSHOT.jar k8s-jenkins-example.jar
ENTRYPOINT ["java", "-jar", "k8s-jenkins-example.jar"]