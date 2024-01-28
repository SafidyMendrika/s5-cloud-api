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
('Audi', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/audi.png?alt=media&token=181842bd-efb4-462a-8c87-e16116e94b9e', 0),
('Chevrolet', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/chev.png?alt=media&token=6a570fa0-1d8e-4c54-a647-7689da89cd9b', 0),
('Citroen', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/citr.png?alt=media&token=4a3ed23a-0e48-4d2e-aafc-19183b29ccb1', 0),
('Ford', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/ford.png?alt=media&token=1c21794a-10b0-484f-9555-967b93534f9e', 0),
('Great Wall', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/great.png?alt=media&token=2406b811-656b-49b0-a8a8-7a414331c42a', 0),
('Honda', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/honda.png?alt=media&token=6aff8028-0f40-4fd3-be02-5a4b997bb1b4', 0),
('Hyundai', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/hyu.png?alt=media&token=78898767-a930-4447-8138-762a8d952f4c', 0),
('Kia', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/kia.png?alt=media&token=f8b1efb8-789f-472c-b6c3-6a4f4b4a936f', 0),
('Mercedes', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/merco.png?alt=media&token=981f91fd-a0a0-4621-9d1d-45d8cb4fd1a2', 0),
('Nissan', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/niss.png?alt=media&token=77cd5a21-654a-454b-bf68-ab377f0e7ad4', 0),
('Opel', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/opel.png?alt=media&token=0903663c-ad74-40c3-af3b-1d4eec9203a4', 0),
('Peugeot', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/peu.png?alt=media&token=a0b5f6c1-de7d-4878-87a1-4d1999882661', 0),
('Porshe', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/porshe.png?alt=media&token=e30ef062-d7a0-484a-a94d-c11955e4eeb1', 0),
('Renault', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/ren.png?alt=media&token=ea9dedb9-def3-4f22-aa1f-9bb8176bec28', 0),
('Seat', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/seat.png?alt=media&token=b414dc35-f9e1-430e-8281-62f1c291dc31', 0),
('Subaru', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/sub.png?alt=media&token=9b772154-22de-43a3-9600-37027595b70b', 0),
('Suzuki', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/suz.png?alt=media&token=3fcb34de-65c6-42e6-a6ec-e9c3b98078b1', 0),
('Toyota', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/toy.png?alt=media&token=828beb17-203f-4d70-99ac-3048087af957', 0),
('Volkswagen', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/w.png?alt=media&token=93bc8029-f60b-4d0a-af58-3e31448692e9', 0),
('Volvo', 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/volvo.png?alt=media&token=971e7b48-0dc0-4ed5-89d6-10332ff7255a', 0);


INSERT INTO modeles (idMarque, idCategorie, nom_modele, etat_modele) VALUES
(1, 1, 'A1', 0),
(2, 1, 'Camaro', 0),
(3, 1, 'C3', 0),
(4, 2, 'Mustang', 0),
(5, 2, 'Haval H6', 0),
(6, 2, 'CR-V', 0),
(7, 3, 'Sonata', 0),
(8, 3, 'Sportage', 0),
(9, 3, 'E-Class', 0),
(10, 1, 'Rogue', 0),
(11, 1, 'Astra', 0),
(12, 2, '3008', 0),
(13, 2, '911', 0),
(14, 3, 'Megane', 0),
(15, 3, 'Ibiza', 0),
(16, 1, 'Outback', 0),
(17, 1, 'Swift', 0),
(18, 2, 'Camry', 0),
(19, 2, 'Golf', 0),
(20, 3, 'XC90', 0);



INSERT INTO annonces (idUtilisateur, idModele, description_annonce, prix_annonce, date_annonce, idEnergie, idVitesse, idMoteur, etat_annonce)
VALUES
(2, 1, 'Audi A1 en très bon état', 25000.00, '2024-01-28 10:00:00', 1, 2, 3, 0),
(3, 2, 'Chevrolet Camaro à vendre', 35000.00, '2024-01-29 11:15:00', 2, 1, 2, 0),
(4, 3, 'Citroen C3 à vendre, faible kilométrage', 18000.00, '2024-01-30 12:30:00', 3, 3, 1, 0),
(5, 4, 'Ford Mustang GT, année 2020', 42000.00, '2024-02-01 13:45:00', 1, 2, 2, 0),
(6, 5, 'Great Wall Haval H6 à saisir', 22000.00, '2024-02-02 14:30:00', 2, 1, 1, 0),
(7, 6, 'Honda CR-V, excellent état', 28000.00, '2024-02-03 15:15:00', 3, 3, 2, 0),
(2, 7, 'Hyundai Sonata à vendre', 20000.00, '2024-02-04 16:30:00', 1, 2, 3, 0),
(3, 8, 'Kia Sportage, faible consommation', 23000.00, '2024-02-05 17:45:00', 2, 1, 1, 0),
(4, 9, 'Mercedes-Benz E-Class, année 2021', 50000.00, '2024-02-06 18:30:00', 3, 3, 2, 0),
(5, 10, 'Nissan Rogue, 4 portes', 26000.00, '2024-02-07 19:15:00', 1, 2, 2, 0),
(6, 11, 'Opel Astra en parfait état', 19000.00, '2024-02-08 20:30:00', 2, 1, 1, 0),
(7, 12, 'Peugeot 3008, modèle récent', 27000.00, '2024-02-09 21:45:00', 3, 3, 2, 0),
(2, 13, 'Porsche 911 Carrera, année 2022', 80000.00, '2024-02-10 22:30:00', 1, 2, 2, 0),
(3, 14, 'Renault Megane, 5 portes', 21000.00, '2024-02-11 23:15:00', 2, 1, 1, 0),
(4, 15, 'Seat Ibiza, faible kilométrage', 17000.00, '2024-02-12 10:00:00', 3, 3, 2, 0),
(5, 16, 'Subaru Outback, idéal pour les aventures', 29000.00, '2024-02-13 11:15:00', 1, 2, 3, 0),
(6, 17, 'Suzuki Swift à vendre', 15000.00, '2024-02-14 12:30:00', 2, 1, 1, 0),
(7, 18, 'Toyota Camry, très bien entretenu', 24000.00, '2024-02-15 13:45:00', 3, 3, 2, 0),
(2, 19, 'Volkswagen Golf, modèle 2021', 28000.00, '2024-02-16 14:30:00', 1, 2, 2, 0),
(3, 20, 'Volvo XC90, 7 places', 55000.00, '2024-02-17 15:15:00', 2, 1, 1, 0);

-- Commissions
INSERT INTO commissions (commission, date_insertion) VALUES 
(5.00, NOW()),
(7.50, NOW()),
(10.00, NOW());


INSERT INTO photos_annonces (idAnnonce, path, etat_photo) VALUES
-- Annonce 1
(1, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/audi1.jpg?alt=media&token=28d862cb-7e82-432b-9163-35d96f400f41', 0),
(1, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/audi2.jpg?alt=media&token=69a1bba7-cf8d-4f3b-a1ee-770a62b8baf7', 0),
(1, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/audi3.jpg?alt=media&token=5f684242-141e-4a7c-904c-12fcd5727f1c', 0),
-- Annonce 2
(2, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/chev1.jpg?alt=media&token=5c536e5d-72c1-4f43-9eb4-869a3603932d', 0),
(2, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/chev2.jpg?alt=media&token=eb4df4ff-fff8-4db7-bf72-2aa347c0334c', 0),
(2, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/chev3.jpg?alt=media&token=36dfd0f5-d2b8-4dc6-a20d-157a019dd946', 0),
-- Annonce 3
(3, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/citr1.jpg?alt=media&token=1f40fba4-c080-4f1d-87a0-942884e78398', 0),
(3, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/citr2.jpg?alt=media&token=88bf9cf5-6e1b-4a63-8766-f39a768e0ede', 0),
(3, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/citr3.jpg?alt=media&token=4083468a-32d3-479e-b9ac-3df2c9c1dfef', 0),

(4, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/ford1.jpg?alt=media&token=f1c4a773-f2f4-496d-ad11-54fdd1edaab9', 0),
(4, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/ford2.jpg?alt=media&token=5ece377c-7479-402b-b8e6-81e80d2d9617', 0),
(4, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/ford3.jpg?alt=media&token=12436071-e373-4636-a6f4-ee2ec8b0be5d', 0),

(5, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/great1.jpg?alt=media&token=6bb35d18-bea6-424a-9607-e0fcad0f18bb', 0),
(5, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/great2.jpg?alt=media&token=a3b873a0-166b-4887-9c99-a4bd66cf8002', 0),
(5, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/great3.jpg?alt=media&token=8bed0748-a343-4379-862f-2aea028f3e7a', 0),

(6, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/honda1.jpg?alt=media&token=0210f267-0e54-4fb7-a26b-a8f7b6ca2748', 0),
(6, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/honda2.jpg?alt=media&token=bc9cceeb-b99d-4258-ba35-dfdeec113f6c', 0),
(6, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/honda3.jpg?alt=media&token=a89e504f-2bb8-4958-9024-fce1fba3f16b', 0),

(7, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/hyu1.jpg?alt=media&token=96d09412-b176-48f7-9f2f-8b028654d7bb', 0),
(7, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/hyu2.jpg?alt=media&token=94b48d2e-ded5-4603-97b1-88aff47c000f', 0),
(7, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/hyu3.jpg?alt=media&token=8a42d05a-2d76-4efe-a1f6-a5b823389560', 0),

(8, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/kia1.jpg?alt=media&token=9e3b67a3-40fc-4907-8f92-0f6934a44cad', 0),
(8, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/kia2.jpg?alt=media&token=abeeb0db-7a90-45b2-943b-1c7ed94cc9ea', 0),
(8, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/kia3.jpg?alt=media&token=9035a501-b6a0-4052-afb2-5217e8a4a62f', 0),

(9, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/merco1.jpg?alt=media&token=162b3b22-8355-42c9-a2f5-695d6daf1eea', 0),
(9, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/merco2.jpg?alt=media&token=72d76b59-427e-4b5a-a898-5dd86b1254a0', 0),
(9, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/merco3.jpg?alt=media&token=6b696831-8c89-41d6-b11b-26fcf15c9478', 0),

(10, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/niss1.jpg?alt=media&token=8dbe4d11-f65c-484a-a466-e8d1f99486e2', 0),
(10, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/niss2.jpg?alt=media&token=6ec3eee6-e462-4d11-a9e7-6db0382902ab', 0),
(10, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/niss3.jpg?alt=media&token=6b1e3232-1d0c-4916-9aa4-8d568c0e04a3', 0),

(11, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/opel1.jpg?alt=media&token=2a19c8ca-ab00-430e-8326-2ad9d476dbe5', 0),
(11, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/opel2.jpg?alt=media&token=918ba126-de43-41b5-87fa-7e4f116f5388', 0),
(11, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/opel3.jpg?alt=media&token=74a4a6aa-8365-4444-bf20-5b019b39cf2a', 0),

(12, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/peu1.jpg?alt=media&token=77121554-eb08-4252-a0e2-0db4678dcb89', 0),
(12, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/peu2.jpg?alt=media&token=1f31f052-3259-46ae-af63-ece9d2e7ca8d', 0),
(12, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/peu3.jpg?alt=media&token=2bb46975-19a3-46fa-bde2-86fe14976bb2', 0),

(13, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/porshe1.jpg?alt=media&token=0aa5545f-20a5-45bf-935b-79f716f81f43', 0),
(13, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/porshe2.jpg?alt=media&token=2fc6307f-3adf-4e5b-a40f-768846d9bd87', 0),
(13, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/porshe3.jpg?alt=media&token=982f9b89-04fa-4ae6-92c8-92b41345c9b6', 0),

(14, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/ren1.jpg?alt=media&token=601ae391-95b5-47ac-9c39-50472f76aba8', 0),
(14, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/ren2.jpg?alt=media&token=3d95b49c-376c-4b08-9cc4-d065de894c3e', 0),
(14, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/ren3.jpg?alt=media&token=1b20a824-719e-4ffe-b52a-7ab463348dcb', 0),

(15, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/seat1.jpg?alt=media&token=dace220e-3414-4c97-827f-0a677c4366d9', 0),
(15, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/seat2.jpg?alt=media&token=f9363a58-92d1-426f-b53f-9542fbee34df', 0),
(15, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/seat3.jpg?alt=media&token=00a20420-81a5-4c56-ab95-34a141a9318e', 0),

(16, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/sub1.jpg?alt=media&token=39964b98-3e06-40db-adde-8c73e63bbc0a', 0),
(16, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/sub2.jpg?alt=media&token=26449a15-1b53-41d9-b85b-ac5de86bb6c8', 0),
(16, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/sub3.jpg?alt=media&token=139cc7cd-6b6f-4c25-a9b3-6a2996602ae0', 0),

(17, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/suz1.jpg?alt=media&token=2811fbbe-4541-4c6e-99ee-7c20907a72cd', 0),
(17, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/suz2.jpg?alt=media&token=5b97b642-b34f-4d11-bd1e-c9c7c7ddb110', 0),
(17, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/suz3.jpg?alt=media&token=b9a46c11-8eab-4b16-9f51-2c45dfc25318', 0),

(18, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/toy1.jpg?alt=media&token=8de79675-ecdf-40a9-b52f-3794f8f6df4c', 0),
(18, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/toy2.jpg?alt=media&token=2ee43d28-e413-4ded-81f5-892306055312', 0),

(19, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/w1.jpg?alt=media&token=ee3a28e6-42cd-4b54-bb38-9d770a1e26aa', 0),
(19, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/w2.jpg?alt=media&token=5cd3de47-6765-467b-af8c-a8470444622f', 0),
(19, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/w3.jpg?alt=media&token=5d0348cd-3991-4be9-89df-0337f0af3f50', 0),

(20, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/volvo1.jpg?alt=media&token=91f6ac30-8419-4ff4-8195-319551505748', 0),
(20, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/volvo2.jpg?alt=media&token=6ad23a69-711e-4b0d-88db-12fa6bb28563', 0),
(20, 'https://firebasestorage.googleapis.com/v0/b/s5-cloud-api-file.appspot.com/o/volvo3.jpg?alt=media&token=6fce85d3-1885-44b4-990c-54dceeca3e24', 0);






