# Projet "Aluno Prioritario"

Le Ministère de l'Éducation portugais a contacté notre équipe avec l'idée d'utiliser la data et l'IA pour aider à remédier à la chute du niveau scolaire constaté à la suite de la fermeture des écoles. L'idée est de fournir un outil permettant aux conseillers pédagogiques de chaque établissement de prioriser les élèves à accompagner en fonction de la complexité et de la valeur (note finale) d'un tel accompagnement. 

Dans ce projet, une première version de l'outil est proposée afin qu'elle puisse être testée dans deux écoles pilotes. 
Ce dashboard pourrait se centrer autour d'un graphe permettant de visualiser l'ensemble des élèves de l'établissement suivant deux axes.


## Choix techniques

- Python
- Dash 
- Jenkins (outil d'intégration continue et de déploiement continu (CI/CD))
- Docker (conteneurisation)

L'utilisation de Python et de Dash permet de développer rapidement une application interactive et facile à utiliser pour les utilisateurs. 
Jenkins facilite l'automatisation du processus de déploiement et de mise à jour de l'application, tandis que Docker facilite le déploiement de l'application sur différents environnements et serveurs.


## Structure du projet

- `app1/`: dossier contenant un premier script `aluno_prioritario1.py`. permettant de lancer une première application permettant de visualiser l'ensemble des étudiants et la prédiction d'une variable symobilsant la complexité à les accompagner selon leur note finale mais aussi d'autres critères telles que l'implication des élèves, le soutien famiial etc... 
A terme, l'utilisateur de l'application pourra saisir les caractéristiques d'un identifiant.
Pour des contraintes de temps, l'inférence du modèle prédisant la notion de 'complexité' n'a pas encoe été réalisée et sera déployée dans une V2 permettant de mettre à jour le graphe de façon dynamique avec de nouvelles données saisies par l'utilisateur.

- `app2/`: dossier contenant un deuxième script `clusters.py`: La visualisation de données est basée sur un modèle de clustering KMeans appliqué à l'ensemble de données d'étudiants. Les variables d'entrée peuvent être sélectionnées à l'aide de menus déroulants dans le tableau de bord. La visualisation des données est affichée dans un graphique interactif, qui peut être mis à jour en temps réel en fonction des choix de l'utilisateur dans les menus déroulants. Le graphique affiche les clusters et les centres de cluster pour les variables d'entrée sélectionnées.

- `notebooks/`: dossier contenant les notebooks utilisés pour explorer les données contenant 2 sous dossiers `01_exploration/` et `02_models/`

## Installation

1. Cloner le dépôt git: `git clone https://github.com/sbouden/aluno_prioritario.git`
2. Naviguer dans le répertoire du projet: `cd aluno_prioritario`
3. cd app1
4. docker build -t ekinox-img .
5. docker run -p 8050:8050 ekinox-img
3. cd app2
4. docker build -t ekinox-img .
5. docker run -p 8050:8050 ekinox-img

## Utilisation

1. Placer les données dans le dossier `data` (voir lien dans la description du projet)
2. Dans app1: Lancer le script principal: `aluno_prioritario1.py`
3. Ouvrir votre navigateur web à l'adresse indiquée par le script (généralement http://localhost:8501)
