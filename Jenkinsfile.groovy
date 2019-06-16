pipeline {
    agent {
        label "Windows_Node"
    }
    environment {
        // Using returnStdout
        CC = """${bat(
            returnStdout: true,
            script: 'echo "clang"'
            )}"""
        // Using returnStatus
        EXIT_STATUS = """${bat(
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
                echo 'printenv'
                echo "env.DEBUG_FLAG"
                echo 'env.EXIT_STATUS'
                echo 'env.CC'
            }
        }
    }
}