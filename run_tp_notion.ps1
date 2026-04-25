$ErrorActionPreference = "Stop"
Write-Host "=========================================="
Write-Host "Lancement automatique du TP Notion & Git"
Write-Host "=========================================="

Write-Host "`n[Etape 2] Initialisation du projet avec Git..."
cd c:\Users\iMaDes\Desktop\GL\Mes_Tps\Tp_Notion
git init

Write-Host "`nAjout du README.md et commit initial..."
Set-Content README.md "# Projet To-Do List`n`nProjet developpe dans le cadre du TP Notion et Git."
git add README.md
git commit -m "Initialisation du projet (README)"

Write-Host "`nConfiguration de la branche main et develop..."
git branch -M main
git checkout -b develop

Write-Host "`n[Etape 3] Creation de la branche feature/add-task..."
git checkout -b feature/add-task
Set-Content index.js "console.log('Ajout d une tache');"
git add index.js
git commit -m "Ajout de la fonctionnalite Ajouter une tache"

Write-Host "`nFusion dans develop..."
git checkout develop
git merge feature/add-task

Write-Host "`nCreation de la branche feature/delete-task..."
git checkout -b feature/delete-task
Add-Content index.js "`nconsole.log('Suppression d une tache');"
git add index.js
git commit -m "Ajout de la fonctionnalite Supprimer une tache"

Write-Host "`nFusion dans develop..."
git checkout develop
git merge feature/delete-task

Write-Host "`n=========================================="
Write-Host "Partie locale Git terminee !"
Write-Host "Il vous reste a configurer votre Notion et"
Write-Host "lier ce depot a GitHub (git remote add...)"
Write-Host "=========================================="
