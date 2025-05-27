pipeline {
    agent any

    tools {
        maven 'Maven Apache'
    }
    stages {
        stage('Build y Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
