-- Energies
INSERT INTO energies (nom_energie, etat_energie) VALUES 
('Essence', 1),
('Diesel', 1),
('Électrique', 1);

-- Vitesses
INSERT INTO vitesses (nom_vitesse, etat_vitesse) VALUES 
('Automatique', 1),
('Manuelle', 1),
('Semi-automatique', 1);

-- Moteurs
INSERT INTO moteurs (nom_moteur, etat_moteur) VALUES 
('4 cylindres', 1),
('6 cylindres', 1),
('8 cylindres', 1);

-- Catégories
INSERT INTO categories (nom_categorie, etat_categorie) VALUES 
('Berline', 1),
('SUV', 1),
('Coupé', 1);

-- Marques
INSERT INTO marques (nom_marque, lien_logo, etat_marque) VALUES 
('Toyota', 'lien_logo_toyota.png', 1),
('Honda', 'lien_logo_honda.png', 1),
('Ford', 'lien_logo_ford.png', 1);

-- Modèles
INSERT INTO modeles (idMarque, idCategorie, nom_modele, etat_modele) VALUES 
(1, 1, 'Camry', 1),
(2, 2, 'Civic', 1),
(3, 3, 'Mustang', 1);

-- Annonces
INSERT INTO annonces (idUtilisateur, idModele, description_annonce, prix_annonce, date_annonce, idEnergie, idVitesse, idMoteur, etat_annonce) VALUES 
(1, 1, 'Belle voiture en excellent état', 15000.00, NOW(), 1, 1, 1, 1),
(2, 2, 'Véhicule économe en carburant', 12000.00, NOW(), 2, 2, 2, 1),
(3, 3, 'Voiture de sport puissante', 25000.00, NOW(), 1, 1, 3, 1);

-- Commissions
INSERT INTO commissions (commission, date_insertion) VALUES 
(5.00, NOW()),
(7.50, NOW()),
(10.00, NOW());

-- Photos Annonces
INSERT INTO photos_annonces (idAnnonce, path, etat_photo) VALUES 
(1, 'photo1.jpg', 1),
(2, 'photo2.jpg', 1),
(3, 'photo3.jpg', 1);

-- Annonces Favorites
INSERT INTO annonces_favorites (idUtilisateur, idAnnonce, etat_favori) VALUES 
(1, 2, 1),
(2, 1, 1),
(3, 3, 1);
