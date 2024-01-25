-- Energies
INSERT INTO energies (nom_energie, etat_energie) VALUES 
('Essence', 0),
('Diesel', 0),
('Électrique', 0);

-- Vitesses
INSERT INTO vitesses (nom_vitesse, etat_vitesse) VALUES 
('Automatique', 0),
('Manuelle', 0),
('Semi-automatique', 0);

-- Moteurs
INSERT INTO moteurs (nom_moteur, etat_moteur) VALUES 
('4 cylindres', 0),
('6 cylindres', 0),
('8 cylindres', 0);

-- Catégories
INSERT INTO categories (nom_categorie, etat_categorie) VALUES 
('Berline', 0),
('SUV', 0),
('Coupé', 0);

-- Marques
INSERT INTO marques (nom_marque, lien_logo, etat_marque) VALUES 
('Toyota', 'lien_logo_toyota.png', 0),
('Honda', 'lien_logo_honda.png', 0),
('Ford', 'lien_logo_ford.png', 0);

-- Modèles
INSERT INTO modeles (idMarque, idCategorie, nom_modele, etat_modele) VALUES 
(1, 1, 'Camry', 0),
(2, 2, 'Civic', 0),
(3, 3, 'Mustang', 0);

-- Annonces
INSERT INTO annonces (idUtilisateur, idModele, description_annonce, prix_annonce, date_annonce, idEnergie, idVitesse, idMoteur, etat_annonce) VALUES 
(1, 1, 'Belle voiture en excellent état', 15000.00, NOW(), 1, 1, 1, 0),
(2, 2, 'Véhicule économe en carburant', 12000.00, NOW(), 2, 2, 2,0),
(3, 3, 'Voiture de sport puissante', 25000.00, NOW(), 1, 1, 3, 0);

-- Commissions
INSERT INTO commissions (commission, date_insertion) VALUES 
(5.00, NOW()),
(7.50, NOW()),
(10.00, NOW());

-- Photos Annonces
INSERT INTO photos_annonces (idAnnonce, path, etat_photo) VALUES 
(1, 'photo1.jpg', 0),
(2, 'photo2.jpg', 0),
(3, 'photo3.jpg', 0);

-- Annonces Favorites
INSERT INTO annonces_favorites (idUtilisateur, idAnnonce, etat_favori) VALUES 
(1, 2, 0),
(2, 1, 0),
(3, 3, 0);
