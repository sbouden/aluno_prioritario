pipeline {
   agent any
   stages {
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