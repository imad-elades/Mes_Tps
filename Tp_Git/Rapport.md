# Rapport de TP : Pratique Avancée avec Git & Node.js

Ce rapport décrit les étapes réalisées lors du TP de maîtrise de l'outil de versionnement Git, couplé à la gestion d'un petit projet Node.js.

---

## Étape 1 : Initialisation du projet
Nous avons commencé par créer l'environnement de base pour notre code.
- Initialisation d'un dépôt Git local avec `git init`.
- Initialisation d'un projet Node.js avec `npm init -y` pour générer un fichier `package.json`.
- Création des fichiers essentiels : `README.md` (description du projet), `.gitignore` (pour exclure le lourd dossier `node_modules` du versionnement) et un fichier principal `index.js`.
- Un premier **commit** a été réalisé pour sauvegarder cette structure de base.

## Étape 2 : Gestion des branches
Pour implémenter de nouvelles fonctionnalités sans impacter le code principal, nous avons manipulé les branches :
- Création et basculement sur une nouvelle branche nommée `dev` via `git checkout -b dev`.
- Implémentation d'une fonction d'**addition** dans `index.js`.
- Sauvegarde de cette évolution par un commit dédié sur cette même branche.

## Étape 3 : Fusion (Merge)
Une fois la fonctionnalité d'addition stable sur `dev`, nous l'avons intégrée à la branche principale.
- Retour sur la branche `main` avec `git checkout main`.
- Fusion de la branche `dev` dans `main` grâce à la commande `git merge dev`. `main` contient désormais la fonction d'addition.

## Étape 4 : Conflits et Résolution
Dans le cadre du développement collaboratif, deux modifications sur la même portion de code créent des conflits. Nous l'avons simulé et résolu :
1. **Création du conflit** :
   - Sur une nouvelle branche `feature`, nous avons ajouté une fonction de **soustraction**.
   - En parallèle, sur la branche `main`, nous avons ajouté des **commentaires de documentation** à la fonction d'addition.
2. **La tentative de fusion** : L'exécution de `git merge feature` sur `main` a provoqué un conflit car Git ne sait pas quelle modification privilégier.
3. **Résolution manuelle** : Nous avons édité `index.js`, supprimé les marqueurs de conflit (`<<<<<<<`, `=======`, `>>>>>>>`), et combiné les deux versions pour conserver à la fois les commentaires (de `main`) et la soustraction (de `feature`). Un commit a validé cette résolution.

## Partie 5 : Rebase
Le "Rebase" permet de garder un historique linéaire, contrairement au "Merge" qui crée des commits de croisement.
- Nous avons créé une branche `bugfix` pour gérer les entrées non valides (NaN) dans notre addition.
- Après avoir commit cette correction, nous sommes revenus sur `main` pour exécuter `git rebase bugfix`.
- **Résultat** : L'historique de `main` a été réécrit pour se placer "au-dessus" du commit de `bugfix`, rendant la lecture de l'historique de Git parfaitement linéaire et plus propre.

## Partie 6 : Cherry-pick
Le "Cherry-pick" est une méthode chirurgicale permettant de sélectionner un commit spécifique d'une branche pour l'appliquer sur une autre.
- Nous avons récupéré l'identifiant (hash) du commit contenant notre correctif `bugfix`.
- En nous plaçant sur la branche `feature` (qui ne possédait pas encore cette correction), nous avons utilisé `git cherry-pick [hash_du_commit]`.
- Suite à un conflit mineur (dû aux commentaires présents sur le correctif mais absents sur la branche feature initiale), nous l'avons résolu pour appliquer proprement ce patch spécifique.

---

### Conclusion
Ce TP a permis d'explorer les cas d'utilisation réels et avancés de Git :
- Développer en isolation via les **branches**.
- Joindre le travail via **merge**.
- Réagir face aux collisions inévitables en équipe via la **résolution de conflits**.
- Optimiser et organiser la lisibilité de l'historique grâce au **rebase** et au **cherry-pick**.
