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
                    sh 'mvn clean package'
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