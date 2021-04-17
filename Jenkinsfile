pipeline {
agent any
stages {
stage('Clean') {
steps {
sh 'mvn clean'
// bat 'mvn clean' // for windows
}
}
stage('Test') {
steps {
sh 'mvn test'
// bat 'mvn test' // for windows
}
}
}
post {
always {
allure([
includeProperties: false,
jdk : '',
properties : [],
reportBuildPolicy: 'ALWAYS',
results : [[path: 'target/allure-results']]
])
}
}
}