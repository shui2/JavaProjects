DROP DATABASE IF EXISTS manifestacijedb;
CREATE DATABASE manifestacijedb;
USE manifestacijedb;

CREATE TABLE grad (
	ptt INT,
	naziv VARCHAR(50) NOT NULL UNIQUE,
	
	PRIMARY KEY(ptt)
);

CREATE TABLE manifestacije (
	id INT AUTO_INCREMENT,
	naziv VARCHAR(50) NOT NULL,
	brPosetioca INT NOT NULL,
	grad INT NOT NULL,
	
	PRIMARY KEY(id),
	FOREIGN KEY(grad) REFERENCES grad(ptt)
);

INSERT INTO grad VALUES (1000, 'City1');
INSERT INTO grad VALUES (2000, 'City2');
INSERT INTO grad VALUES (3000, 'City3');

INSERT INTO manifestacije (naziv, brPosetioca, grad) VALUES ('Manifestation1', 10000, 1000);
INSERT INTO manifestacije (naziv, brPosetioca, grad) VALUES ('Manifestation2', 5000, 2000);
INSERT INTO manifestacije (naziv, brPosetioca, grad) VALUES ('Manifestation3', 7500, 2000);
INSERT INTO manifestacije (naziv, brPosetioca, grad) VALUES ('Manifestation4', 4500, 3000);
INSERT INTO manifestacije (naziv, brPosetioca, grad) VALUES ('Manifestation5', 9000, 1000);