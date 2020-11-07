/**
Øving 5 - TDAT1005 Databaser med videregående programmering(2019 vår)
http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_relmod1.php

*/
DROP TABLE IF EXISTS Andelseier;
DROP TABLE IF EXISTS Leilighet;
DROP TABLE IF EXISTS Bygning;
DROP TABLE IF EXISTS Borettslag;

CREATE TABLE Borettslag(
  BorettslagNr INTEGER PRIMARY KEY,
  Navn VARCHAR(50),
  Adresse VARCHAR(70),
  AntallHus INTEGER,
  Etableringsar INTEGER
);

CREATE TABLE Bygning(
  BygningNr INTEGER PRIMARY KEY,
  Adresse VARCHAR(50),
  AntLeiligheter INTEGER,
  AntEtasjer INTEGER,
  BorettslagNr INTEGER,
  FOREIGN KEY BorettslagNr REFERENCES Borettslag(BorettslagNr)
);

CREATE TABLE Leilighet(
  LeilighetNr INTEGER PRIMARY KEY,
  AntRom INTEGER,
  Areal INTEGER,
  Etasje INTEGER,
  Eier INTEGER,
  Adresse VARCHAR(50),
  BygningNr INTEGER,
  (BygningNr) ON DELETE CASCADE;
  FOREIGN KEY BygningNr REFERENCES Bygning(BygningNr)
);

CREATE TABLE Andelseier(
  EierIndeks INTEGER,
  Navn VARCHAR(50),
  LeilighetNr INTEGER,
  FOREIGN KEY LeilighetNr INTEGER Leilighet(LeilighetNr)
);

ALTER TABLE Bygning
ADD FOREIGN KEY (BygningNr) REFERENCES Borettslag(BorettslagNr);
ALTER table Leilighet
ADD FOREIGN KEY (BygningNr) REFERENCES Bygning(BygningNr);
ALTER TABLE Andelseier
ADD FOREIGN KEY (Eier) REFERENCES Leilighet(LeilighetNr);

INSERT INTO Borettslag(BorettslagNr,Navn,Adresse,AntallHus,Etableringsar)
VALUES
(1, "Gundersens sameie", "Planetveien 1", 100, 1999);

// oppgave e) kan være lurt å la fremmednøklen mellom Andelseier og Leilighet kunne være null, fordi
// oppgaven sier at en Leilighet kan stå tom og man kan være medlem i Borettslaget uten å eie
// primærnøkler kan ikke være null
