
# 'Zaho chic api

Partie backend du projet Zaho chic. une boutique de la mode en ligne

# Techno

Spring Boot : Pour la logique backend et l'API REST.

MySQL : Base de données relationnelle.

Spring Security + JWT : Pour l'authentification et la gestion des tokens.

# Installation 

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants :

    Java 21

    Maven 

    MySQL 

    Postman
    
## git clone https://github.com/MitsinjoFehizoro/zaho-chic-api.git

## Configuration de la connexion à bdd dans application.properties

    spring.datasource.url=jdbc:mysql://localhost:3306/zaho_chic_db
    spring.datasource.username=nom_utilisateur
    spring.datasource.password=mot_de_passe
    spring.jpa.hibernate.ddl-auto=update

## Configurer CORS pour le frontend dans SecurityConfig.java

    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Ajout du front end

## Démarrer le serveur

# Endpoints

