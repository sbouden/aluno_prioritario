pipeline {
   agent any
   stages {

      stage('Install Docker') {
         steps {
            sh 'curl -fsSL https://get.docker.com -o get-docker.sh'
            sh 'sudo sh get-docker.sh'
            sh 'docker --version'
         }
      }

      stage('Build and Deploy') {
         steps {
            // Clone le repository Git
            git branch: 'apps', url: 'https://github.com/sbouden/aluno_prioritario.git'

            // Aller dans app1 et construire l'image Docker
            dir('app1') {
               sh 'docker build -t img-app1 .'
            }

            // Lance le container Docker
            sh 'docker run -p 8050:8050 img-app1'
         }
      }
   }
}