Kotlin project to deploy on Kubernetes using Jenkins
===
Example project on how to automatically deploy a Kotlin REST service on Kubernetes using a Jenkins pipeline. 

Requirements
---
- Kotlin
- Maven
- Docker

Build
---
1. Build project
    ```
    mvn clean package
    ```
1. Build Docker image 
    ```
    docker build -t k8s-jenkins-example .
    ```