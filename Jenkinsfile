pipeline {
    agent any

    tools {
        // Must match the name in Manage Jenkins -> Tools -> Maven
        maven 'maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                // Pulls code from the GitHub URL configured in the Jenkins Job UI
                checkout scm
            }
        }

        stage('Build & Unit Test') {
            steps {
                // 'mvn test' runs standard Unit Tests (ending in *Test.java)
                bat 'mvn clean test'
            }
        }

        stage('Integration Test') {
            steps {
                // 'mvn verify' triggers the Failsafe plugin for Integration Tests (ending in *IT.java)
                // We use -DskipTests=false to ensure integration tests aren't accidentally skipped
                bat 'mvn verify -DskipITs=false'
            }
        }
    }

    post {
        always {
            // This captures results from BOTH Surefire (Unit) and Failsafe (Integration) reports
            junit '**/target/*-reports/*.xml'
        }
        success {
            echo 'All Unit and Integration tests passed!'
        }
        failure {
            echo 'Build failed. Check the Console Output for test failures.'
        }
    }
}
