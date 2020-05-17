pipeline {

    agent {
        kubernetes {
            label 'java-k8s-gradle-gcloud-helm'
            // all your pods will be named with this prefix, followed by a unique id
            idleMinutes 5  // how long the pod will live after no jobs have run on it
            yamlFile 'jenkins-agnets/k8s-build-agent/jenkins-agent.yaml'
            // path to the pod definition relative to the root of our project
            defaultContainer 'java-k8s-gradle-gcloud-helm'
            // define a default container if more than a few stages use it, will default to jnlp container
        }
    }

    stages {

        stage('Test') {
            steps {
                sh 'echo hello form container'
            }
        }

        stage('Auth in Google Container Registry') {
            steps {
                withCredentials([
                        file(credentialsId: 'ingress-lms-276014', variable: 'GCLOUD_SECURITY_FILE')
                ]) {
                    sh('echo "Activate account"')
                    sh('gcloud -q auth activate-service-account --key-file ${GCLOUD_SECURITY_FILE}')
                    sh('gcloud -q config set project ingress-lms-276014')
                    sh('gcloud -q auth configure-docker')
                }
            }
        }

        stage('Build') {
            steps {
                sh "mkdir -p /tmp"
                sh "./gradlew build"
            }
        }

        stage('Docker Push') {
            steps {
                sh "./gradlew dockerPush"
            }
        }

    }
}