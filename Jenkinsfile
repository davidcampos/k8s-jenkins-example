pipeline {
    environment {
        registry = 'davidcampos/k8s-jenkins-example'
        registryCredential = 'dockerhub'
    }
    agent {
        kubernetes {
            defaultContainer 'jnlp'
            yamlFile 'pod.yaml'
        }
    }
    stages {
        stage('Build') {
            steps {
                container('maven') {
                    sh 'mvn package'
                }
            }
        }
        stage('Docker') {
            steps {
                container('docker') {
                    sh 'docker build -t  $registry .'
                }
            }
        }
    }
}