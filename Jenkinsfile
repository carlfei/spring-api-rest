pipeline {
    agent {
        docker {
            //image 'maven:3.9.0-eclipse-temurin-11'
            image 'maven:8ed0e45480d3'
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
    }
}

