pipeline {
    agent any
    stages {
        stage('checkout git') {
            steps {
             echo 'Pulling ' 
                git branch : 'balkis',
                url : 'https://github.com/Armi64bit/devops_groupe4',
                credentialsId : 'balkis'
            }
        }
        
        stage('MVN clean') {
               steps {
                // Execute 'mvn clean' command
                sh 'mvn clean'
            }
        }
        stage('MVN compile') {
             steps {
                // Execute 'mvn compile' command
                sh 'mvn compile'
            }
        }
        stage('MVN install') {
             steps {
                // Execute 'mvn compile' command
                sh 'mvn install'
            }
        }
        stage('Sonarqube') {
            environment {
                // Define SonarQube credentials
               SONAR_USERNAME = credentials('sonar')

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
        stage('Docker Image') {
            steps {
                sh 'docker build -t balkis-devops .'
            }
        }
        
        stage('Docker Image Push') {
            steps {
                script {
                    sh 'echo "dockerdevops" | docker login --username "balkiss55" --password-stdin'
                    sh 'docker tag balkis-devops balkiss55/devops:latest'
                    sh 'docker push balkiss55/devops:latest'
                }
            }
        }

        
         stage('Docker Compose') {
            steps {
                sh 'docker compose up -d'
            }
        }
       
         stage('Email Notification'){
             steps{
             mail bcc: '', body: 'THE PIPELINE IS FULLY WORKING !', cc: '', from: '', replyTo: '', subject: 'EMAIL NOTIFICATION', to: 'balkisshmidi1999@gmail.com'
         }
             
         }

        
        
        
    }
}
