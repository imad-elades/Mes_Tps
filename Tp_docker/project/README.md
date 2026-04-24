# Rapport de TP : Application Multi-Conteneurs avec Docker Compose

Ce rapport détaille les étapes réalisées lors de ce Travail Pratique (TP) portant sur la création d'une architecture multi-conteneurs utilisant Docker Compose. L'objectif était de déployer une application comprenant un frontend web, une base de données PostgreSQL et une interface d'administration pgAdmin.

## 1. Structure du Projet

Nous avons commencé par créer l'arborescence des dossiers et des fichiers nécessaires pour isoler les différentes parties du projet :

```
project/
├── backend/
│   └── db.env
├── frontend/
│   ├── .dockerignore
│   ├── Dockerfile
│   └── index.html
└── docker-compose.yml
```

## 2. Configuration du Frontend

Dans le dossier `frontend`, nous avons configuré un serveur web léger (Nginx) pour héberger une page web statique.

- **`index.html`** : Contient le code source de notre page web (ex: un message de bienvenue).
- **`Dockerfile`** : Permet de construire l'image Docker personnalisée pour le frontend. Il utilise l'image officielle `nginx:alpine` et copie le fichier `index.html` dans le répertoire par défaut d'Nginx (`/usr/share/nginx/html/`).
- **`.dockerignore`** : Permet d'exclure certains fichiers locaux (comme `*.log`) lors de la construction de l'image.

## 3. Configuration du Backend (Base de Données)

Dans le dossier `backend`, nous avons isolé la configuration des variables d'environnement de la base de données pour plus de sécurité.

- **`db.env`** : Fichier contenant les identifiants d'initialisation de PostgreSQL :
  ```env
  POSTGRES_USER=admin
  POSTGRES_PASSWORD=adminpassword
  POSTGRES_DB=myapp
  ```

## 4. Orchestration avec Docker Compose

Afin de lier tous ces éléments ensemble, nous avons rédigé le fichier **`docker-compose.yml`** à la racine du projet. Ce fichier orchestre le déploiement de trois services distincts :

1. **`frontend`** :
   - Construit l'image à partir du `Dockerfile` présent dans `./frontend`.
   - Expose le port interne `80` sur le port externe `8080` de la machine hôte.

2. **`db`** :
   - Utilise l'image officielle `postgres:13`.
   - Charge les identifiants depuis le fichier `./backend/db.env`.
   - **Persistance des données** : Monte un volume nommé `db-data` vers `/var/lib/postgresql/data` pour s'assurer que les données de la base ne soient pas perdues lors du redémarrage des conteneurs.

3. **`pgadmin`** :
   - Utilise l'image `dpage/pgadmin4`.
   - Expose l'interface sur le port externe `5050`.
   - Définit les identifiants de connexion par défaut (`admin@admin.com` / `admin`).
   - Déclare une dépendance `depends_on: - db` pour s'assurer que la base démarre avant l'interface.

*Tous ces services sont connectés entre eux via un réseau Docker interne nommé `app-network`.*

## 5. Déploiement et Vérifications

Une fois la configuration terminée, nous avons lancé l'ensemble de l'infrastructure en utilisant la commande suivante :
```bash
docker-compose up --build -d
```
Cette commande a permis de :
1. Construire l'image du frontend.
2. Télécharger les images PostgreSQL et pgAdmin.
3. Créer le réseau et le volume persistant.
4. Lancer les trois conteneurs en tâche de fond.

### Vérifications finales effectuées :
- **Frontend** : Nous avons accédé avec succès à la page web via `http://localhost:8080`.
- **pgAdmin** : Nous nous sommes connectés à l'interface via `http://localhost:5050` (identifiant: `admin@admin.com`, mot de passe: `admin`).
- **Connexion à la Base** : Au sein de pgAdmin, nous avons ajouté un nouveau serveur en utilisant les informations du conteneur DB :
  - **Host** : `db` (grâce à la résolution DNS du réseau `app-network`)
  - **Port** : `5432`
  - **Username** : `admin`
  - **Password** : `adminpassword`

## Conclusion

Ce TP a permis de mettre en pratique l'utilisation de Docker et Docker Compose pour orchestrer une architecture multi-tiers complète, de manière reproductible et isolée, tout en assurant la persistance des données et la configuration centralisée par variables d'environnement.
