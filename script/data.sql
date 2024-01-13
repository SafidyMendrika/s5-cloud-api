-- Insertion des utilisateurs
INSERT INTO utilisateurs (nom_utilisateur, email_utilisateur, password_utilisateur, statut_utilisateur, etat_utilisateur) 
VALUES 
('John', 'john@email.com', 'john', 0, 0),
('Alex', 'alex@email.com', 'alex', 0, 0),
('Logan', 'logan@email.com', 'logan', 0, 0),
('root', 'root@email.com', 'root', 10, 0);

INSERT INTO marques (nom_marque) VALUES 
('Toyota'), 
('BMW'), 
('Mercedes-Benz'), 
('Honda'), 
('Ford'), 
('Audi'), 
('Volkswagen'), 
('Porsche'), 
('Subaru'), 
('Tesla'), 
('Lexus'), 
('Volvo'), 
('Chevrolet'), 
('Nissan'), 
('Hyundai'), 
('Kia'), 
('Jaguar'), 
('Land Rover'), 
('Mazda'), 
('Fiat'), 
('Peugeot'), 
('Citroën'), 
('Aston Martin'), 
('Ferrari'), 
('Lamborghini'), 
('Rolls-Royce'), 
('Bentley'), 
('Maserati'), 
('Alfa Romeo'), 
('McLaren'), 
('Bugatti'), 
('Lotus'), 
('Genesis'), 
('Infiniti'), 
('Acura'), 
('MINI'), 
('GMC'), 
('Ram'), 
('Jeep'), 
('Dodge'), 
('Chrysler'), 
('Buick'), 
('Cadillac'), 
('Lincoln'), 
('Volkswagen Commercial Vehicles'), 
('Dacia'), 
('Seat'), 
('Skoda'), 
('Mahindra'), 
('BYD');


INSERT INTO categories (nom_categorie) VALUES 
('Compacte'), 
('Berline'), 
('SUV'), 
('Coupé'), 
('Cabriolet'), 
('Monospace');


-- Ajout des modèles pour les 10 premières marques
INSERT INTO modeles (idMarque,idCategorie, nom_modele) VALUES
-- Toyota
(1,1, 'Corolla'),
(1,2, 'Camry'),
(1,3, 'RAV4'),
(1,4, 'Prius'),
(1,5, 'Highlander'),
(1,6, 'Tacoma'),
(1,2, 'Tundra'),
(1,3, '4Runner'),
(1,4, 'Avalon'),
(1,1, 'Yaris'),
(1,5, 'C-HR'),
(1,6, 'Sienna'),
(1,1, 'Sequoia'),
(1,2, 'Land Cruiser'),
(1,3, 'Supra');

-- Insertion des voitures
INSERT INTO voitures ( idModele, nom_voiture, etat_voiture)
VALUES 
( 1, 'Toyota Corolla 2022', 0),
( 2, 'Honda Civic 2021', 0),
( 1, 'Toyota Camry 2020', 0);

-- Insertion des annonces
INSERT INTO annonces (idutilisateur, idvoiture, description_annonce, date_validation, date_annonce, etat_annonce)
VALUES 
(1, 1, 'Belle voiture compacte à vendre', NULL, '2024-01-12 10:00:00', 0),
(2, 2, 'Super offre sur cette Honda Civic', '2024-01-12 11:30:00', '2024-01-10 15:45:00', 0),
(1, 3, 'Toyota Camry à vendre à prix réduit', NULL, '2024-01-11 09:20:00', 0);

-- Insertion des favoris
INSERT INTO annonces_favorites (idUtilisateur, idAnnonce, etat_favori)
VALUES 
(1, 2, 0),
(2, 1, 0),
(3, 3, 0);

-- Insertion des sessions
INSERT INTO sessions (idUtilisateur, code, token, date_expiration)
VALUES 
(1, 1234, 'token_utilisateur1', '2023-12-15'),
(2, 5678, 'token_utilisateur2', '2023-12-12'),
(3, 9876, 'token_utilisateur3', '2023-12-10');


INSERT INTO photos_annonces (idAnnonce, path)
VALUES
(1, 'photo1'),
(1, 'photo2'),
(1, 'photo3'),
(1, 'photo4');
