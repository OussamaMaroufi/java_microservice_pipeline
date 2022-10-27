pipeline{
    agent any

    stages{

       stage("sonar_quality_check"){
            agent { docker 'maven:3-alpine' } 
            steps{
                script{
                    withSonarQubeEnv(credentialsId: 'jenkins_token') {
                      sh "mvn sonar:sonar"
                    }

                     timeout(time: 1, unit: 'HOURS') {
                      def qg = waitForQualityGate()
                      if (qg.status != 'OK') {
                           error "Pipeline aborted due to quality gate failure: ${qg.status}"
                      }
                    }
                }
            }
          
        }
    
    stage("Build project"){
    agent { docker 'maven:3-alpine' } 
       steps {

            script{
                echo 'Hello, Maven'
                    sh 'mvn --version'
                    sh 'mvn clean install'
            }
        } 
    }

    stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t oussamamaaroufi1/spring-boot-api-img .'
                }
            }
    }

    stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u oussamamaaroufi1 -p ${dockerhubpwd}'

                    }
                   sh 'docker push oussamamaaroufi1/spring-boot-api-img'
                }
            }
        }
    }

    


    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}