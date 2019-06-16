pipeline {
    agent {
        label "Windows_Node"
    }
    environment {
        // Using returnStdout
        CC = """${sh(
            returnStdout: true,
            script: 'echo "clang"'
            )}"""
        // Using returnStatus
        EXIT_STATUS = """${sh(
            returnStatus: true,
            script: 'exit 1'
            )}"""
    }
    stages {
        stage('Example') {
            environment{
                DEBUG_FLAG = '-g'
            }
            steps {
                sh 'printenv'
            }
        }
    }
}