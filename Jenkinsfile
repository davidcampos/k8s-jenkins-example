pipeline {
    environment {
        registry = 'davidcampos/k8s-jenkins-example'
        registryCredential = 'dockerhub'
        name = "example-${env.BRANCH_NAME}"
        domain = 'localhost'
    }
    agent {
        kubernetes {
            defaultContainer 'jnlp'
            yamlFile 'build.yaml'
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
        stage('Docker Build') {
            steps {
                container('docker') {
                    sh 'docker build -t  $registry .'
                }
            }
        }
        stage('Docker Publish') {
            steps {
                container('docker') {
                    withDockerRegistry([credentialsId: "dockerhub", url: ""]) {
                        sh 'docker push $registry:latest'
                    }
                }
            }
        }
        stage('Kubernetes Deploy') {
            steps {
                container('helm') {
                    sh 'helm init --client-only --skip-refresh'
                    sh "helm upgrade --install --force --set name=${name} --set domain=${domain} ${name} ./helm"
                }
            }
        }
    }
}