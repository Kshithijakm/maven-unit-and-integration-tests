pipeline {
    agent any

    tools {
        maven 'maven3' 
    }

    stages {
        stage('Build & Unit Test') {
            steps {
                // This runs the standard unit tests
                bat 'mvn clean test'
            }
        }

        stage('Integration Test') {
            steps {
                // 'verify' is the magic command that triggers the Failsafe plugin
                bat 'mvn verify -DskipTests=false'
            }
        }
    }

    post {
        always {
            // This captures results from both Surefire and Failsafe
            junit '**/target/*-reports/*.xml'
        }
    }
}
