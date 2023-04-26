pipeline {
   agent any
   stages {

      stage('Install Docker') {
         
         // install docker macos
         stage('Install Docker') {
            steps {
               sh '#!/bin/bash\nset -e\n\nif ! command -v docker &> /dev/null\nthen\n    echo "Docker n\'est pas installé. Installation en cours ..."\n    # Installation de Homebrew si nécessaire\n    if ! command -v brew &> /dev/null\n    then\n        echo "Homebrew n\'est pas installé. Installation en cours ..."\n        /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"\n    fi\n    # Installation de Docker\n    brew install docker\n    # Lancement de Docker\n    open /Applications/Docker.app\n    echo "Docker est installé et en cours d\'exécution."\nelse\n    echo "Docker est déjà installé."\nfi'
               sh 'chmod +x docker_install.sh'
               sh './docker_install.sh'
            }
         }
         // pour un utilisateur linux
         // steps {
         //    sh 'curl -fsSL https://get.docker.com -o get-docker.sh'
         //    sh 'sudo sh get-docker.sh'
         //    sh 'docker --version'
         // }
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