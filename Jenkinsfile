pipeline {
    agent {
        docker {
            image 'maven:latest'
            args '-v /root/.m2:/root/.m2'
        }
    }
    // environment {
    //     SELENIUM_CONTAINER_NAME = 'selenium-edge'
    //     SELENIUM_STANDALONE_VERSION = '114.0'
    //     MAVEN_CONTAINER_NAME = 'maven'
    //     MAVEN_VERSION = 'latest'
    // }
    stages {
        // stage('Start Selenium Standalone') {
        //     steps {
        //         sh "docker run --name '${SELENIUM_CONTAINER_NAME}' -d --network=bridge -p 4444:4444 --shm-size='2g' selenium/standalone-edge:${SELENIUM_STANDALONE_VERSION}"
        //         }
        // }
        // stage('Get Selenium Container IP Address') {
        //     steps {
        //         container('jenkins-docker') {
        //             script {
        //                 HOST = sh(script: "docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' ${SELENIUM_CONTAINER_NAME}", returnStdout: true).trim()
        //                 env.HOST = HOST
        //             }
        //         }
        //     }
        // }
        stage('Run Test') {
            steps {
                sh 'mvn test -Dheadless=true'
                // sh "docker run --name ${MAVEN_CONTAINER_NAME} --network=bridge -v $PWD:/app -w /app maven:${MAVEN_VERSION} mvn test -Dheadless=true -Dremote=true -Dhost=${env.HOST}"
                // sh 'docker cp maven:/app/target/allure-results/ .'
                // sh "docker stop ${SELENIUM_CONTAINER_NAME} && docker rm ${SELENIUM_CONTAINER_NAME}"
                // sh "docker stop ${MAVEN_CONTAINER_NAME} && docker rm ${MAVEN_CONTAINER_NAME}"
                sh 'tar -czf test-result.tar.gz target/allure-results/'
            }
            post {
                always {
                    script {
                        archiveArtifacts artifacts: "test-result.tar.gz", allowEmptyArchive: true
                    }
                }
            }
        }
    }
}