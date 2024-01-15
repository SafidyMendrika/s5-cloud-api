CREATE DATABASE gascar;


\c gascar;

-- etat
-- 0 : créer
-- -10: supprimer

CREATE TABLE utilisateurs(
    id_utilisateur SERIAL PRIMARY KEY,
    nom_utilisateur VARCHAR(255) NOT NULL,
    email_utilisateur VARCHAR(255) NOT NULL,
    password_utilisateur VARCHAR(255) NOT NULL,
    statut_utilisateur INTEGER DEFAULT 0,
    etat_utilisateur INTEGER DEFAULT 0
);


CREATE TABLE categories(
    id_categorie SERIAL PRIMARY KEY,
    nom_categorie VARCHAR(255) NOT NULL,
    etat_categorie INTEGER DEFAULT 0
);


CREATE TABLE marques(
    id_marque SERIAL PRIMARY KEY,
    nom_marque VARCHAR(255) NOT NULL,
    etat_marque INTEGER DEFAULT 0
);


CREATE TABLE modeles(
    id_modele SERIAL PRIMARY KEY,
    idMarque INTEGER REFERENCES marques(id_marque),
    idCategorie INTEGER REFERENCES categories(id_categorie),
    nom_modele VARCHAR(255) NOT NULL,
    etat_modele INTEGER DEFAULT 0
);


CREATE TABLE voitures(
    id_voiture SERIAL PRIMARY KEY,
    idModele INTEGER REFERENCES modeles(id_modele),
    nom_voiture VARCHAR(255) NOT NULL,
    etat_voiture INTEGER DEFAULT 0
);



CREATE TABLE annonces(
    id_annonce SERIAL PRIMARY KEY,
    idUtilisateur INTEGER REFERENCES utilisateurs(id_utilisateur),
    idVoiture INTEGER REFERENCES voitures (id_voiture),
    description_annonce VARCHAR(255) NOT NULL,
    prix_annonce DOUBLE PRECISION NOT NULL,
    date_validation TIMESTAMP,
    date_annonce TIMESTAMP NOT NULL,
    etat_annonce INTEGER DEFAULT 0
);


CREATE TABLE photos_annonces(
    id_photo SERIAL PRIMARY KEY,
    idAnnonce INTEGER REFERENCES annonces(id_annonce),
    path VARCHAR(255) NOT NULL,
    etat_photo INTEGER DEFAULT 0
);


CREATE TABLE annonces_favorites(
    id_favori SERIAL PRIMARY KEY,
    idUtilisateur INTEGER REFERENCES utilisateurs(id_utilisateur),
    idAnnonce INTEGER REFERENCES annonces(id_annonce),
    etat_favori INTEGER DEFAULT 0
);



CREATE TABLE sessions(
    id_session SERIAL PRIMARY KEY,
    idUtilisateur INTEGER REFERENCES utilisateurs(id_utilisateur),
    code INTEGER UNIQUE,
    token VARCHAR(255) UNIQUE,
    date_expiration TIMESTAMP NOT NULL
);




