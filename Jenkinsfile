pipeline {
    agent any
    tools {
        maven 'maven_3.6.2'
        jdk 'jdk_9.0.4'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn package'
                echo 'This is a minimal pipeline.'
            }
        }
    }
}