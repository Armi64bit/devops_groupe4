pipeline {
    agent any
  tools {
        git 'git'
    }
    stages {
        stage('checkout git') {
            steps {
                echo 'Pulling ' 
                git branch: 'bahaa',
                url: 'https://github.com/Armi64bit/devops_groupe4',
                credentialsId: 'armi'
            }
        }

        stage('Clean') {
            steps {
                script {
                    sh 'mvn clean'
                }
            }
        }

        stage('Compile') {
            steps {
                script {
                    sh 'mvn compile'
                }
            }
        }

        stage('Unit Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Sonarqube') {
            environment {
                // Define SonarQube credentials
                SONAR_USERNAME = credentials('logson')
            }
            steps {
                sh "mvn test jacoco:report"
                sh "mvn sonar:sonar -Dsonar.login=${SONAR_USERNAME} -Dsonar.projectKey=devops_groupe4 -Dsonar.projectName='devops_groupe4'"
            }
        }

        stage('Deploy') {
            steps {
                script {
                   
                                               sh 'mvn deploy -DskipTests -Dusername=admin -Dpassword=nexus'
            
                }
            }
        }
    }
}
