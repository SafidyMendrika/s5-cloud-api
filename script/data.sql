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
INSERT INTO modeles (idMarque, nom_modele) VALUES
-- Toyota
(1, 'Corolla'),
(1, 'Camry'),
(1, 'RAV4'),
(1, 'Prius'),
(1, 'Highlander'),
(1, 'Tacoma'),
(1, 'Tundra'),
(1, '4Runner'),
(1, 'Avalon'),
(1, 'Yaris'),
(1, 'C-HR'),
(1, 'Sienna'),
(1, 'Sequoia'),
(1, 'Land Cruiser'),
(1, 'Supra'),

-- BMW
(2, '3 Series'),
(2, '5 Series'),
(2, 'X3'),
(2, 'X5'),
(2, '7 Series'),
(2, 'i3'),
(2, 'M3'),
(2, 'M5'),
(2, 'X1'),
(2, 'X7'),
(2, 'Z4'),

-- Mercedes-Benz
(3, 'C-Class'),
(3, 'E-Class'),
(3, 'S-Class'),
(3, 'A-Class'),
(3, 'GLC'),
(3, 'GLE'),
(3, 'GLA'),
(3, 'CLA'),
(3, 'GLS'),
(3, 'G-Class'),
(3, 'SL'),

-- Honda
(4, 'Accord'),
(4, 'Civic'),
(4, 'CR-V'),
(4, 'Pilot'),
(4, 'Odyssey'),
(4, 'Fit'),
(4, 'HR-V'),
(4, 'Ridgeline'),
(4, 'Insight'),

-- Ford
(5, 'Mustang'),
(5, 'F-150'),
(5, 'Explorer'),
(5, 'Escape'),
(5, 'Fusion'),
(5, 'Edge'),
(5, 'Focus'),
(5, 'Expedition'),
(5, 'Ranger'),
(5, 'Bronco'),


-- Audi
(6, 'A4'),
(6, 'A6'),
(6, 'Q5'),
(6, 'Q7'),
(6, 'Q3'),
(6, 'A3'),
(6, 'A8'),
(6, 'TT'),
(6, 'S4'),
(6, 'SQ5'),

-- Volkswagen
(7, 'Golf'),
(7, 'Passat'),
(7, 'Tiguan'),
(7, 'Atlas'),
(7, 'Jetta'),
(7, 'Arteon'),
(7, 'Touareg'),
(7, 'ID.4'),

-- Porsche
(8, '911'),
(8, 'Cayenne'),
(8, 'Panamera'),
(8, 'Macan'),
(8, '718 Boxster'),
(8, '718 Cayman'),
(8, 'Taycan'),
(8, 'Cayman GT4'),

-- Subaru
(9, 'Outback'),
(9, 'Forester'),
(9, 'Impreza'),
(9, 'Legacy'),
(9, 'Crosstrek'),
(9, 'BRZ'),
(9, 'WRX'),

-- Tesla
(10, 'Model S'),
(10, 'Model 3'),
(10, 'Model X'),
(10, 'Model Y'),

-- Lexus
(11, 'RX'),
(11, 'ES'),
(11, 'UX'),
(11, 'NX'),
(11, 'LS'),
(11, 'GX'),
(11, 'LX'),
(11, 'RC'),
(11, 'LC'),
(11, 'IS'),

-- Volvo
(12, 'XC90'),
(12, 'S60'),
(12, 'V60'),
(12, 'XC60'),
(12, 'XC40'),
(12, 'S90'),
(12, 'V90'),
(12, 'V40'), 
(12, 'C30'),

-- Chevrolet
(13, 'Camaro'),
(13, 'Malibu'),
(13, 'Equinox'),
(13, 'Traverse'),
(13, 'Blazer'),
(13, 'Colorado'),
(13, 'Silverado'),
(13, 'Tahoe'),
(13, 'Suburban'),
(13, 'Impala'),

-- Nissan
(14, 'Altima'),
(14, 'Maxima'),
(14, 'Rogue'),
(14, 'Murano'),
(14, 'Pathfinder'),
(14, 'Armada'),
(14, 'Sentra'),
(14, 'Titan'),
(14, '370Z'),
(14, 'GT-R'),

-- Hyundai
(15, 'Elantra'),
(15, 'Sonata'),
(15, 'Tucson'),
(15, 'Santa Fe'),
(15, 'Kona'),
(15, 'Palisade'),
(15, 'Accent'),
(15, 'Veloster'),
(15, 'Nexo'),
(15, 'Ioniq'),

-- Kia
(16, 'Sportage'),
(16, 'Sorento'),
(16, 'Telluride'),
(16, 'Soul'),
(16, 'Forte'),
(16, 'Rio'),
(16, 'Stinger'),
(16, 'Carnival'),
(16, 'K5'),
(16, 'Niro'),

-- Jaguar
(17, 'F-Type'),
(17, 'XE'),
(17, 'XF'),
(17, 'XJ'),
(17, 'E-PACE'),
(17, 'F-PACE'),
(17, 'I-PACE'),

-- Land Rover
(18, 'Range Rover'),
(18, 'Discovery'),
(18, 'Defender'),
(18, 'Range Rover Sport'),
(18, 'Range Rover Evoque'),
(18, 'Range Rover Velar'),

-- Mazda
(19, 'CX-5'),
(19, 'Mazda3'),
(19, 'MX-5'),
(19, 'CX-9'),
(19, 'Mazda6'),
(19, 'CX-3'),
(19, 'MX-30'),

-- Fiat
(20, '500'),
(20, '500X'),
(20, '500L'),
(20, '124 Spider'),
(20, 'Panda'),
(20, 'Tipo'),


-- Peugeot
(21, '208'),
(21, '308'),
(21, '2008'),
(21, '3008'),
(21, '5008'),
(21, '108'),
(21, '508'),
(21, '807'), -- Modèle précédent
(21, '4007'), -- Modèle précédent
(21, 'RCZ'),

-- Citroën
(22, 'C3'),
(22, 'C4'),
(22, 'C5'),
(22, 'Berlingo'),
(22, 'Jumpy'),
(22, 'Spacetourer'),
(22, 'DS3'),  -- Modèle précédent
(22, 'DS4'),  -- Modèle précédent
(22, 'DS5'),  -- Modèle précédent

-- Aston Martin
(23, 'Vantage'),
(23, 'DB11'),
(23, 'DBS Superleggera'),
(23, 'Rapide AMR'),
(23, 'Valkyrie'),
(23, 'DBX'),

-- Ferrari
(24, '488'),
(24, 'F8 Tributo'),
(24, 'Portofino'),
(24, 'Roma'),
(24, 'SF90 Stradale'),
(24, 'GTC4Lusso'),
(24, 'Monza SP1/SP2'),

-- Lamborghini
(25, 'Huracán'),
(25, 'Aventador'),
(25, 'Urus'),

-- Rolls-Royce
(26, 'Phantom'),
(26, 'Ghost'),
(26, 'Wraith'),
(26, 'Dawn'),
(26, 'Cullinan'),

-- Bentley
(27, 'Continental GT'),
(27, 'Flying Spur'),
(27, 'Bentayga'),

-- Maserati
(28, 'Ghibli'),
(28, 'Quattroporte'),
(28, 'Levante'),
(28, 'GranTurismo'),  -- Modèle précédent
(28, 'GranCabrio'),  -- Modèle précédent

-- Alfa Romeo
(29, 'Giulia'),
(29, 'Stelvio'),
(29, 'Giulietta'),  -- Modèle précédent
(29, '4C'),  -- Modèle précédent

-- McLaren
(30, 'Artura'),
(30, 'GT'),
(30, '720S'),
(30, '570S'),
(30, 'Speedtail'),
(30, 'Sabre'),

-- Bugatti
(31, 'Chiron'),
(31, 'Divo'),
(31, 'La Voiture Noire'),

-- Lotus
(32, 'Evora'),
(32, 'Exige'),
(32, 'Elise'),
(32, 'Emira'),

-- Genesis
(33, 'G70'),
(33, 'G80'),
(33, 'G90'),
(33, 'GV70'),
(33, 'GV80'),

-- Infiniti
(34, 'Q50'),
(34, 'Q60'),
(34, 'QX50'),
(34, 'QX60'),
(34, 'QX80'),

-- Acura
(35, 'ILX'),
(35, 'TLX'),
(35, 'RLX'),
(35, 'MDX'),
(35, 'RDX'),


-- MINI
(36, 'Cooper'),
(36, 'Countryman'),
(36, 'Clubman'),
(36, 'Convertible'),
(36, 'Paceman'),

-- GMC
(37, 'Sierra'),
(37, 'Canyon'),
(37, 'Acadia'),
(37, 'Terrain'),
(37, 'Yukon'),

-- Ram
(38, '1500'),
(38, '2500'),
(38, '3500'),
(38, 'ProMaster'),
(38, 'ProMaster City'),

-- Jeep
(39, 'Wrangler'),
(39, 'Grand Cherokee'),
(39, 'Cherokee'),
(39, 'Renegade'),
(39, 'Compass'),

-- Dodge
(40, 'Charger'),
(40, 'Challenger'),
(40, 'Durango'),
(40, 'Journey'),
(40, 'Grand Caravan'),

-- Chrysler
(41, '300'),
(41, 'Voyager'),
(41, 'Pacifica'),

-- Buick
(42, 'Encore'),
(42, 'Envision'),
(42, 'Enclave'),
(42, 'Regal TourX'), -- Modèle précédent
(42, 'Cascada'),  -- Modèle précédent

-- Cadillac
(43, 'CT4'),
(43, 'CT5'),
(43, 'XT4'),
(43, 'XT5'),
(43, 'XT6'),

-- Lincoln
(44, 'Navigator'),
(44, 'Aviator'),
(44, 'Corsair'),
(44, 'Nautilus'),
(44, 'Continental'),  -- Modèle précédent

-- Volkswagen Commercial Vehicles
(45, 'Transporter'),
(45, 'Crafter'),
(45, 'Amarok'),


-- Dacia
(46, 'Sandero'),
(46, 'Duster'),
(46, 'Logan'),
(46, 'Dokker'),
(46, 'Lodgy'),

-- Seat
(47, 'Ibiza'),
(47, 'Leon'),
(47, 'Ateca'),
(47, 'Tarraco'),
(47, 'Arona'),

-- Skoda
(48, 'Octavia'),
(48, 'Superb'),
(48, 'Kodiaq'),
(48, 'Karoq'),
(48, 'Enyaq iV'),

-- Mahindra
(49, 'Thar'),
(49, 'Scorpio'),
(49, 'XUV500'),
(49, 'Bolero'),
(49, 'Alturas G4'),

-- BYD
(50, 'Han'),
(50, 'Tang'),
(50, 'Song'),
(50, 'Yuan'),
(50, 'e2');


-- Insertion des voitures
INSERT INTO voitures (idCategorie, idModele, nom_voiture, etat_voiture)
VALUES 
(1, 1, 'Toyota Corolla 2022', 0),
(2, 2, 'Honda Civic 2021', 0),
(3, 1, 'Toyota Camry 2020', 0);

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
