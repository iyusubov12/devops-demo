pipeline {
    agent {
        kubernetes {
            label 'java-k8s-gradle-gcloud'  // all your pods will be named with this prefix, followed by a unique id
            idleMinutes 5  // how long the pod will live after no jobs have run on it
            yamlFile 'jenkins/k8s-build-agent/jenkins-agent.yaml'
            // path to the pod definition relative to the root of our project
            defaultContainer 'java-k8s-gradle-gcloud'
            // define a default container if more than a few stages use it, will default to jnlp container
        }
    }

    stages {

        stage('Gradle Build') {
            steps {
                sh './gradlew build'
            }
        }

    }
}
