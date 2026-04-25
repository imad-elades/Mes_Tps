# Rapport du TP : Intégration Notion & Git

Ce rapport décrit de manière structurée l'ensemble des tâches réalisées lors de ce TP liant la gestion de projet sur Notion et le contrôle de version avec Git.

---

## 1. Mise en place de Notion (Étape 1)
- **Création de l'espace de travail** : Une nouvelle page intitulée "Projet To-Do List" a été créée sur Notion.
- **Tableau Kanban** : Mise en place d'un tableau avec 3 colonnes de base (`À faire`, `En cours`, `Terminé`) et création de 3 cartes représentant les fonctionnalités principales du projet web (Ajouter, Supprimer, Marquer).
- **Documentation & Rapport** : Ajout des sections textuelles décrivant les exigences de chaque fonctionnalité, ainsi qu'une section dédiée à la traçabilité des problèmes rencontrés.

## 2. Initialisation du Projet avec Git (Étape 2)
- **Création du dépôt** : Le dossier local `Tp_Notion` a été initialisé en tant que dépôt Git (`git init`).
- **Fichiers initiaux** : Un fichier `README.md` a été créé pour décrire le projet.
- **Gestion des branches principales** :
  - La branche principale a été renommée en `main` (`git branch -M main`).
  - Une branche de développement parallèle `develop` a été créée pour isoler le travail en cours (`git checkout -b develop`).
- **Lien avec GitHub** : Le dépôt local a été lié à un dépôt distant vierge sur GitHub (`git remote add origin`), puis les branches `main` et `develop` ont été poussées en ligne.

## 3. Suivi des Tâches dans Notion et Git (Étape 3)
La méthodologie de travail synchronisée a été appliquée :
1. Déplacement de la carte "Ajouter une tâche" dans la colonne `En cours` sur Notion.
2. Création d'une branche dédiée au développement de cette tâche : `git checkout -b feature/add-task`.
3. Développement de la fonctionnalité, ajout des fichiers, et validation (`git commit -m "Ajout de la fonctionnalité Ajouter une tâche"`).
4. Envoi de la branche vers GitHub (`git push origin feature/add-task`).
5. Une fois fusionnée dans `develop`, la carte correspondante a été déplacée dans la colonne `Terminé` sur Notion.
*(Cette même boucle a été répétée pour `feature/delete-task` et les autres cartes).*

## 4. Documentation des Problèmes (Étape 4)
- Lors de l'intégration des différentes branches `feature` sur `develop`, des conflits de fusion (Merge Conflicts) ont été volontairement ou involontairement provoqués.
- Ces problèmes ont été résolus localement (via VS Code) et ont été scrupuleusement documentés dans la section "Problèmes rencontrés" de la page Notion.
- Les liens des commits de résolution GitHub ont été attachés à cette documentation pour une traçabilité parfaite.

## 5. Collaboration et Feedback (Étape 5)
- Une fausse "réunion" de débriefing a été documentée sur Notion.
- Les points forts (progrès réalisés) et les axes d'amélioration (communication, design, tests) ont été notés afin de préparer les futures itérations du projet (Sprint Retrospective).

---
**Conclusion** :
Ce TP a permis d'assimiler un workflow professionnel standard (souvent basé sur GitFlow ou GitHub Flow) en liant chaque évolution de code (Git) à un outil de pilotage visuel et documentaire (Notion).
