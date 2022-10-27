pipeline{
    agent any

    stages{

       stage("sonar_quality_check"){
        
            steps{
                script{
                    withSonarQubeEnv(credentialsId: 'jenkins_token') {
                        // sh 'chmod +x gradlew'
                        // sh './gradlew sonarqube --stacktrace'
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