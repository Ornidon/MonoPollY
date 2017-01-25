# MonoPollY - Gestion de sondages

## Introduction

Cette application a pour but de permettre à différents utilisateurs de créer et de participer à différents questionnaires et de voir différentes statistiques à propos de ceux-ci

Voici la liste des principales caractéristiques demandés :

- En tant qu'enquêteur, je peux poser des questions à une audience.
- En tant qu'auditeur, je peux répondre aux questions.
- En tant que participant, je peux voir les réponses de l'audience.
- En tant qu'invité je peux créer un compte et m'enregistrer.
- En tant qu'utilisateur enregistré je peux me connecter ou me déconnecter.
- En tant qu'auditeur je peux m'inscrire dans une salle (audience).
- En tant qu'enquêteur je peux créer une salle.
- En tant qu'enquêteur je peux créer des questions dans ma salle.

Voici le flux de navigation attendu pour cette application :

![Navigation flow](ressources/User Flow.png)

Les pages suivantes sont accessible lorsque l'utilisateur n'est pas authentifié :

  - Index
  - Login
  - Register

Les pages suivantes ne sont accessible que lorsque l'utilisateur est authentifié :

  - Polls

Un utilisateur est définit par :

  - Un nom d'utilisateur
  - Un mot de passe

## Pour déployer l'application

### Prérequis

Pour lancer et construire le projet du client il vous faut :

- node 4.6.1
- npm 2.15.9

Pour lancer et construire le projet du serveur il vous faut:

- java 1.8
- maven 3.3.9

### Déploiment client

1. Il vous faut cloner le répertoire (branche : frontend)
2. Ouvrir un terminal dans le répertoire cloné
3. Lancer les commandes suivantes :

  ```bash
  $> npm install
  $> npm run serve
  ```
4. Ouvrir votre navigateur
5. Aller à l'adresse `localhost:3000` 

### Construire un client déployable

1. Lancer la commande suivante:
```bash
  $> npm run build
  ```
2. le client sera dans le fichier /dist

**Remarque**: Seul le client est lancé. Pour lancer le serveur avec la base de donnée veuillez suivre la procédure de Déploiment serveur. Il est possible de changer l'adresse du serveur en éditant le fichier config.json

### Déploiment serveur

1. Il vous faut cloner le répertoire (branche : server)
2. Ouvrir un terminal dans le répertoire cloné
3. Lancer la commande suivante :

  ```bash
  $> ./start.sh
  ```
4. Ouvrir votre navigateur
5. Aller à l'adresse `localhost:8080/api` 

**Remarque**: Vous pouvez configurer le secret des JSON web token en éditant le fichier JWT.properties.

## Utilisation

1. Vous pouvez soit : 
- Déployer l'application vous même
- Ouvrir votre navigateur et vous rendre sur http://monopollytweb.herokuapp.com/ 
2. Connectez-vous.
3. Profitez ! 

## Technologies 
Pour ce projet nous utilisons les technologies suivantes :
 - Angular2
 - Typescript
 - WebPack
 - MySQL
 - SpringBoot

## Pour plus d'informations

Visitez notre page de présentation :

 - https://ornidon.github.io/MonoPollY/

## Auteurs
Ioannis Noukakis & Thbaut Loiseau
