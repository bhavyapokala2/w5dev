pipeline {
    agent any
            stage('Compile') {
            steps {
                echo "Compiling Java files..."
                bat 'javac Factorial.java TestFactorial.java'
            }
        }
        stage('Test') {
            steps {
                echo "Running Test..."
                bat 'java TestFactorial'
            }
        }
        stage('Run'){
            steps{
                echo "Run"
                bat 'java Factorial'
            }
        }
        stage('Package JAR'){
            steps{
                echo "Build"
                bat 'jar cfm factorial.jar manifest.txt Factorial.class'
            }
        }
        stage('Archive JAR'){
            steps{
                echo "Deploy"
                archiveArtifacts artifacts:'factorial.jar'
            }
        }         
    }
    post {
        success {
            echo 'Build,test,run and JAR creation Successful and artifact is ready!'
        }
        failure {
            echo 'Build Failed!'
        }
    }
}
