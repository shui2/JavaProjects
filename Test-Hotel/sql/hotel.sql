DROP DATABASE IF EXISTS hoteldb;
CREATE DATABASE hoteldb;
USE hoteldb;

CREATE TABLE sobe (
	id INT AUTO_INCREMENT,
	tip VARCHAR(50) NOT NULL,
	kreveti INT NOT NULL,
	cena DOUBLE NOT NULL,
	
	PRIMARY KEY(id)
);

CREATE TABLE rezervacije (
	id INT AUTO_INCREMENT,
	soba INT NOT NULL,
	ulazak DATETIME NOT NULL,
	izlazak DATETIME NOT NULL,
	gost VARCHAR(50) NOT NULL,
	
	PRIMARY KEY(id),
	FOREIGN KEY(soba) REFERENCES sobe(id)
);

INSERT INTO sobe (tip, kreveti, cena) VALUES ('Studio', 2, 2000);
INSERT INTO sobe (tip, kreveti, cena) VALUES ('Suite', 1, 2500);
INSERT INTO sobe (tip, kreveti, cena) VALUES ('Family room', 4, 3500);
INSERT INTO sobe (tip, kreveti, cena) VALUES ('Interconnected rooms', 2, 2500);
INSERT INTO sobe (tip, kreveti, cena) VALUES ('Interconnected rooms', 2, 2000);
INSERT INTO sobe (tip, kreveti, cena) VALUES ('Suite', 2, 3000);

INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (6, '2017-11-01 12:00:00', '2017-11-10 10:00:00', 'Petar Petrovic');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (3, '2017-11-05 13:00:00', '2017-11-10 08:00:00', 'Marko Markovic');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (6, '2017-11-19 03:00:00', '2017-11-22 03:00:00', 'Jovan Jovanovic');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (3, '2017-11-10 12:30:00', '2017-11-20 07:00:00', 'Petar Petrovic');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (4, '2017-11-10 12:00:00', '2017-12-02 08:00:00', 'Marko Markovic');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (5, '2017-11-10 12:00:00', '2017-12-02 08:00:00', 'Marko Markovic');