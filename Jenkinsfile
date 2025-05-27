pipeline {
    agent any
       tools {
          maven 'Maven Apache' // El nombre debe coincidir
      }
    stages {
        stage('Build y Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
