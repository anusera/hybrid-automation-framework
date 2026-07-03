pipeline {

    agent any

    tools {
        maven 'Maven_Home'
    }

    parameters {
        choice(
            name: 'TEST_SUITE',
            choices: ['smoke', 'sanity', 'regression'],
            description: 'Select the test suite to execute'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                bat "mvn clean test -Dgroups=${params.TEST_SUITE}"
            }
        }
    }

    post {
        always {
            publishHTML([
                reportDir: 'Reports',
                reportFiles: 'ExtentReport.html',
                reportName: 'Extent Report',
                keepAll: true,
                alwaysLinkToLastBuild: true
            ])
        }
    }
}