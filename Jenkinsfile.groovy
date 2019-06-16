pipeline {
    agent {
        label "Windows_Node"
    }
    evironment {
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
            evironment{
                DEBUG_FLAG = '-g'
            }
            steps {
                sh 'printenv'
            }
        }
    }
}