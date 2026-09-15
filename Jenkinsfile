pipeline {
    agent any

    stages {

        stage('Compile') {
            steps {
                echo "Compiling Java files..."
                bat 'javac factorial.java testFactorial.java'
            }
        }

        stage('Test') {
            steps {
                echo "Running Test..."
                bat 'java TestFactorial'
            }
        }

        stage('Run') {
            steps {
                echo "Run"
                bat 'java factorial'
            }
        }

        stage('Package JAR') {
            steps {
                echo "Build"
                bat 'jar cfm factorial.jar manifest.txt factorial.class'
            }
        }

        stage('Archive JAR') {
            steps {
                echo "Deploy"
                archiveArtifacts artifacts: 'factorial.jar'
            }
        }
    }

    post {
        success {
            echo 'Build, test, run and JAR creation successful and artifact is ready!'
        }

        failure {
            echo 'Build Failed!'
        }
    }
}
