pipeline {
    agent any
    parameters {
        string(name: 'Greeting', defaultValue: 'HELLO', description: 'How should I greet the world?')
    }
    stages {
        stage('Example') {
            steps {
                echo "${params.Greeting} World!"
            }
        }
    }
}