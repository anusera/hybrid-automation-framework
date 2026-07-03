pipeline {

    agent any

    tools {
        maven 'Maven_Home'
    }

    parameters {
        choice(
            name: 'TEST_SUITE',
            choices: ['regression', 'smoke', 'sanity'],
            description: 'Select the test suite to execute'
        )
    }
    
    triggers {
    cron('0 23 * * *')
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
                alwaysLinkToLastBuild: true,
            	allowMissing: false
            ])
        }
    }
}