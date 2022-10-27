pipeline{
    agent any

    stages{

        


    //    stage("sonar_quality_check"){
    //         agent { docker 'maven:3-alpine' } 
    //         steps{
    //             script{
    //                 withSonarQubeEnv(credentialsId: 'jenkins_token') {
    //                     // sh 'chmod +x gradlew'
    //                     // sh './gradlew sonarqube --stacktrace'
    //                 }

    //                  timeout(time: 1, unit: 'HOURS') {
    //                   def qg = waitForQualityGate()
    //                   if (qg.status != 'OK') {
    //                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
    //                   }
    //                 }
    //             }
    //         }
          
    //     }
    agent { docker 'maven:3-alpine' } 
    stage("Build project"){
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