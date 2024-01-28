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

-- Exemples de données de test supplémentaires pour la table annonces

INSERT INTO annonces (idUtilisateur, idModele, description_annonce, prix_annonce, date_annonce, idEnergie, idVitesse, idMoteur, etat_annonce)
VALUES
  (1, 1, 'Petite voiture économique', 9000.50, '2024-02-02 08:15:00', 1, 4, 1, 0),
  (2, 2, 'VUS tout-terrain pour les aventures', 28000.75, '2024-02-03 11:30:00', 1, 4, 1, 0),
  (3, 2, 'Cyclomoteur idéal pour la ville', 1500.25, '2024-02-04 14:45:00', 2, 3, 2, 0),
  (4, 1, 'Camionnette spacieuse avec attache de remorque', 18000.99, '2024-02-05 17:20:00', 2, 3, 2, 0),
  (5, 3, 'Motocross performante pour les amateurs de sensations fortes', 7500.50, '2024-02-06 20:10:00', 2, 2, 3, 0),
  (6, 4, 'Voiture électrique respectueuse de l environnement', 30000.25, '2024-02-07 23:00:00', 3, 2, 3, 0),
  (7, 3, 'Scooter rétro avec un style classique', 2000.75, '2024-02-08 09:30:00', 3, 1, 4, 0),
  (1, 1, 'Vélo électrique pour les trajets urbains', 1200.00, '2024-02-09 12:45:00', 4, 1, 4, 0),
  (2, 4, 'Voiture de luxe avec toutes les options', 50000.99, '2024-02-10 15:30:00', 4, 4, 1, 0),
  (3, 3, 'Moto custom avec un design unique', 11000.50, '2024-02-11 18:10:00', 1, 4, 1, 0),
  (4, 3, 'Compact hybride économe en carburant', 17000.25, '2024-02-12 21:20:00',1, 3, 2, 0),
  (5, 2, 'Véhicule utilitaire pour le transport de marchandises', 24000.75, '2024-02-13 10:15:00', 2, 3, 2, 0),
  (6, 4, 'Scooter sportif pour les déplacements rapides', 3000.50, '2024-02-14 13:40:00', 2, 2, 3, 0),
  (7, 1, 'Voiture décapotable pour des balades ensoleillées', 25000.99, '2024-02-15 16:50:00', 3, 2, 3, 0),
  (1, 3, 'Vélo tout-terrain robuste pour les amateurs de plein air', 800.75, '2024-02-16 19:30:00', 4, 1, 4, 0);


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
-- INSERT INTO annonces_favorites (idUtilisateur, idAnnonce, etat_favori) VALUES 
-- (1, 2, 0),
-- (2, 1, 0),
-- (3, 3, 0);


INSERT INTO annonces_favorites(idAnnonce,idUtilisateur) VALUES
    (1,2),
    (1,4),
    (1,5),
    (1,6),
    (1,7),

    (2,5),
    (2,4),
    (2,3),
    (2,2),

    (10,5),
    (10,4),
    (10,3),
    (10,2),

    (3,2),
    (3,3),
    (3,4),

    (4,2),
    (4,4);