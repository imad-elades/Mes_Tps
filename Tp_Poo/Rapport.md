# Rapport de TP - Programmation Orientée Objet (POO)

Ce rapport compile les réponses théoriques et les détails d'implémentation pour l'ensemble des exercices du TP 1.

---

## Exercice 1.1 – Programmation Orientée Objet (Gestion d'animaux)

### Partie 1 : Définitions théoriques
1. **Encapsulation** : L'encapsulation consiste à masquer les données internes d'un objet pour les protéger. Dans la classe `Animal`, l'attribut `nom` est déclaré avec le mot-clé `private`. Son accès de l'extérieur est contrôlé et rendu possible uniquement à travers la méthode publique `getNom()`.
2. **Héritage** : L'héritage permet à une classe d'acquérir les attributs et méthodes d'une autre classe. Les classes `Mammifere` et `Oiseau` héritent de la super-classe `Animal` en utilisant le mot-clé `extends`, ce qui leur permet de réutiliser la logique liée à l'attribut `nom`.
3. **Abstraction** : L'abstraction permet de définir des modèles conceptuels sans en détailler l'implémentation. La classe `Animal` est abstraite (`abstract`), ce qui signifie qu'elle ne peut pas être instanciée directement. Sa méthode `faireDuBruit()` est également abstraite, forçant ainsi les classes filles à en fournir une implémentation spécifique.
4. **Polymorphisme** : Le polymorphisme permet à des objets de types différents d'être traités uniformément. Dans la méthode `main()`, les variables `tigre` et `perroquet` sont déclarées de type `Animal`. Lors de l'appel à `faireDuBruit()`, la machine virtuelle Java exécute dynamiquement la méthode correspondant à l'instance réelle (soit `Mammifere`, soit `Oiseau`).

### Partie 2 : Compléter le code
5. **Méthode `voler()`** : La méthode a été ajoutée dans la classe `Oiseau` pour afficher le message "L'oiseau vole." lorsqu'elle est appelée.
6. **Modification du `main()`** : Le type de la variable `perroquet` a été modifié de `Animal` vers `Oiseau` (soit `Oiseau perroquet = new Oiseau("Perroquet");`) afin de permettre l'appel direct de la méthode spécifique `perroquet.voler()`.

### Partie 3 : Identification des mots-clés
7. Mots-clés utilisés dans le code Java :
   - **L'héritage** : `extends`
   - **La redéfinition de méthode** : `@Override`
   - **L'abstraction** : `abstract`

---

## Exercice 1.2 - Gestion des véhicules

### Partie 1 : Théorie et concepts
1. **Encapsulation** : Elle est implémentée dans la classe abstraite `Vehicule` où les attributs `marque`, `modele` et `annee` sont définis comme `private`. Les classes filles et les utilisateurs de ces objets doivent utiliser les getters publics (comme `getMarque()`) pour accéder à ces informations.
2. **Héritage** : Les classes `Voiture` et `Camion` héritent de `Vehicule` via `extends`. Elles utilisent l'instruction `super(marque, modele, annee);` dans leurs constructeurs pour appeler le constructeur de la classe parente et initialiser les attributs hérités.
3. **Polymorphisme** : Le polymorphisme est utilisé dans le programme principal `GestionTransport` lors de l'appel de la méthode `afficherDetails()`. Bien que stockés dans des références de type `Vehicule`, la méthode invoquée est celle définie dans les types réels (`Voiture`, `Camion` ou `Moto`).
4. **Abstraction** : La classe `Vehicule` est abstraite car elle représente un concept global. Il n'a pas de sens d'instancier un véhicule générique sans savoir s'il s'agit d'une voiture ou d'un camion, d'autant plus que l'implémentation de la méthode `afficherDetails()` dépend spécifiquement du type de véhicule (ex: nombre de portes pour une voiture, charge pour un camion).

### Partie 2 : Compléter le code
5. **Méthode `demarrer()`** : Une méthode concrète `demarrer()` a été ajoutée à la classe `Vehicule` pour afficher "Le véhicule démarre.". Les méthodes `afficherDetails()` des sous-classes font appel à cette méthode héritée avant d'afficher leurs propres caractéristiques.
6. **Création de la classe `Moto`** : Une nouvelle classe `Moto` a été implémentée. Elle hérite de `Vehicule`, possède un attribut `typeDeGuidon` (de type String), appelle le constructeur parent via `super()`, et redéfinit la méthode `afficherDetails()`.

### Partie 3 : Identification des mots-clés
7. Mots-clés identifiés :
   - **La redéfinition de méthode** : `@Override`
   - **L'héritage** : `extends`
   - **L'appel au constructeur parent** : `super`

---

## Exercice 1.3 - Programmation Orienté Objet (Comptes bancaires)

Une implémentation complète a été réalisée avec les contraintes suivantes :

1. **Classe de base `CompteBancaire`** :
   - Attributs `numeroCompte` et `solde` créés et encapsulés (en visibilité protégée pour l'héritage).
   - Méthode `deposer(double montant)` implémentée pour additionner un montant positif au solde.
   - Méthode `retirer(double montant)` implémentée intégrant une vérification logique pour empêcher le retrait si les fonds sont insuffisants.

2. **Classe dérivée `CompteEpargne`** :
   - Hérite de `CompteBancaire`.
   - Implémentation d'une méthode `calculerInterets(double taux)` qui ajoute un pourcentage du solde actuel au compte.

3. **Classe `CompteCourant`** :
   - Hérite directement de `CompteBancaire` sans comportement additionnel spécifique.

4. **Classe principale `Banque`** :
   - Le programme de test instancie les deux types de comptes, effectue des dépôts, simule un retrait valide et un retrait invalide, et calcule les intérêts annuels pour le compte épargne.
