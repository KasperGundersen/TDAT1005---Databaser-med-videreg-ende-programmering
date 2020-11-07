/*
Øving 6 - TDAT1005 Databaser med videregående programmering(2019 vår)
http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_relmod2.php
*/
-- Utgave tilpasset MySQL

-- Sletter tabeller

DROP TABLE IF EXISTS bok_forfatter;
DROP TABLE IF EXISTS forfatter;
DROP TABLE IF EXISTS bok;
DROP TABLE IF EXISTS forlag;
DROP TABLE IF EXISTS konsulent;

-- Oppretter tabeller med entitetsintegritet (primærnøkkel)

CREATE TABLE forlag(
 forlag_id INTEGER NOT NULL AUTO_INCREMENT,
 forlag_navn VARCHAR(30),
 adresse VARCHAR(30),
 telefon CHAR(15),
CONSTRAINT forlag_pk PRIMARY KEY(forlag_id));

CREATE TABLE bok(
 bok_id INTEGER NOT NULL AUTO_INCREMENT,
 tittel VARCHAR(30),
 utgitt_aar INTEGER,
 forlag_id INTEGER,
CONSTRAINT bok_pk PRIMARY KEY(bok_id));

CREATE TABLE forfatter(
 forfatter_id INTEGER NOT NULL AUTO_INCREMENT,
 fornavn VARCHAR(20),
 etternavn VARCHAR (30),
 fode_aar INTEGER,
 dod_aar INTEGER,
 nasjonalitet VARCHAR(20),
CONSTRAINT forfatter_pk PRIMARY KEY(forfatter_id));

CREATE TABLE bok_forfatter(
 bok_id INTEGER NOT NULL,
 forfatter_id INTEGER NOT NULL,
CONSTRAINT bok_forfatter_pk PRIMARY KEY(bok_id, forfatter_id));

CREATE TABLE konsulent(
  kons_id INTEGER NOT NULL AUTO_INCREMENT,
  fornavn VARCHAR(20),
  etternavn VARCHAR (30),
  epost VARCHAR(30),
CONSTRAINT konsulent_pk PRIMARY KEY(kons_id));

-- Legger på referanseintegritet (fremmednøkler)

ALTER TABLE bok
 ADD CONSTRAINT bok_fk FOREIGN KEY(forlag_id)REFERENCES forlag(forlag_id);

ALTER TABLE bok_forfatter
 ADD CONSTRAINT bok_forfatter_fk1 FOREIGN KEY(bok_id)REFERENCES bok(bok_id);

ALTER TABLE bok_forfatter
 ADD CONSTRAINT bok_forfatter_fk2 FOREIGN KEY(forfatter_id)REFERENCES forfatter(forfatter_id);

-- Legger inn data i tabellene

INSERT INTO forlag VALUES(DEFAULT,'Tapir','Trondheim', '73590000');
INSERT INTO forlag VALUES(DEFAULT,'Gyldendal','Oslo', '22220000');
INSERT INTO forlag VALUES(DEFAULT,'Cappelen','Oslo', '22200000');
INSERT INTO forlag VALUES(DEFAULT,'Universitetsforlaget','Oslo', '23230000');
INSERT INTO forlag VALUES(DEFAULT,'Achehaug','Oslo', '22000000');
INSERT INTO forlag VALUES(DEFAULT,'Oktober','Oslo', '22002200');
INSERT INTO forlag VALUES(DEFAULT,'Tiden','Oslo', '22232223');
INSERT INTO forlag VALUES(DEFAULT,'Harper Collins','USA',NULL);

INSERT INTO bok VALUES(DEFAULT,'Tåpenes',1995,7);
INSERT INTO bok VALUES(DEFAULT,'Rebecca',1981,3);
INSERT INTO bok VALUES(DEFAULT,'Gutter er gutter',1995,5);
INSERT INTO bok VALUES(DEFAULT,'Microserfs',1991,8);
INSERT INTO bok VALUES(DEFAULT,'Generation X',1995,8);
INSERT INTO bok VALUES(DEFAULT,'Klosterkrønike',1982,3);
INSERT INTO bok VALUES(DEFAULT,'Universet',1988,3);
INSERT INTO bok VALUES(DEFAULT,'Nålen',1978,3);
INSERT INTO bok VALUES(DEFAULT,'Markens grøde',1917,2);
INSERT INTO bok VALUES(DEFAULT,'Victoria',1898,2);
INSERT INTO bok VALUES(DEFAULT,'Sult',1890,2);
INSERT INTO bok VALUES(DEFAULT,'Benoni',1908,2);
INSERT INTO bok VALUES(DEFAULT,'Rosa',1908,2);
INSERT INTO bok VALUES(DEFAULT,'Et skritt',1997,2);
INSERT INTO bok VALUES(DEFAULT,'Den femte',1996,2);
INSERT INTO bok VALUES(DEFAULT,'Villspor',1995,2);
INSERT INTO bok VALUES(DEFAULT,'Silkeridderen',1994,2);
INSERT INTO bok VALUES(DEFAULT,'Den hvite hingsten',1992,2);
INSERT INTO bok VALUES(DEFAULT,'Hunder',1992,2);
INSERT INTO bok VALUES(DEFAULT,'Bridget Jones',1995,5);
INSERT INTO bok VALUES(DEFAULT,'Se terapeuten',1998,3);
INSERT INTO bok VALUES(DEFAULT,'Sa mor',1996,3);
INSERT INTO bok VALUES(DEFAULT,'Jubel',1995,3);
INSERT INTO bok VALUES(DEFAULT,'Tatt av kvinnen',1993,3);
INSERT INTO bok VALUES(DEFAULT,'Supernaiv',1996,3);

INSERT INTO forfatter VALUES(DEFAULT,'John','Tool',1937, 1969, 'USA');
INSERT INTO forfatter VALUES(DEFAULT,'Ken','Follet',NULL, NULL, 'Britisk');
INSERT INTO forfatter VALUES(DEFAULT,'Stephen','Hawking',NULL, NULL, 'Britisk');
INSERT INTO forfatter VALUES(DEFAULT,'Jose','Saramago',1942, NULL, 'Portugisisk');
INSERT INTO forfatter VALUES(DEFAULT,'Douglas','Coupland',1961, NULL, 'Canadisk');
INSERT INTO forfatter VALUES(DEFAULT,'Nick','Hornby',1857, NULL, 'Britisk');
INSERT INTO forfatter VALUES(DEFAULT,'Knut','Hamsun',1859, 1952, 'Norsk');
INSERT INTO forfatter VALUES(DEFAULT,'Henning','Mankell',1948, NULL, 'Svensk');
INSERT INTO forfatter VALUES(DEFAULT,'Helen','Fielding',NULL, NULL, 'Britisk');
INSERT INTO forfatter VALUES(DEFAULT,'Hal','Sirowitz',NULL, NULL, 'USA');
INSERT INTO forfatter VALUES(DEFAULT,'Lars S.','Christensen',NULL, NULL, 'Norsk');
INSERT INTO forfatter VALUES(DEFAULT,'Erlend','Loe',NULL, NULL, 'Norsk');

INSERT INTO bok_forfatter VALUES(1, 1);
INSERT INTO bok_forfatter VALUES(2, 2);
INSERT INTO bok_forfatter VALUES(3, 6);
INSERT INTO bok_forfatter VALUES(4, 5);
INSERT INTO bok_forfatter VALUES(5, 5);
INSERT INTO bok_forfatter VALUES(6, 4);
INSERT INTO bok_forfatter VALUES(7, 3);
INSERT INTO bok_forfatter VALUES(8, 2);
INSERT INTO bok_forfatter VALUES(9, 7);
INSERT INTO bok_forfatter VALUES(10, 7);
INSERT INTO bok_forfatter VALUES(11, 7);
INSERT INTO bok_forfatter VALUES(12, 1);
INSERT INTO bok_forfatter VALUES(13, 1);
INSERT INTO bok_forfatter VALUES(14, 8);
INSERT INTO bok_forfatter VALUES(15, 8);
INSERT INTO bok_forfatter VALUES(16, 8);
INSERT INTO bok_forfatter VALUES(17, 8);
INSERT INTO bok_forfatter VALUES(18, 8);
INSERT INTO bok_forfatter VALUES(19, 8);
INSERT INTO bok_forfatter VALUES(20, 9);
INSERT INTO bok_forfatter VALUES(21, 10);
INSERT INTO bok_forfatter VALUES(22, 10);
INSERT INTO bok_forfatter VALUES(23, 11);
INSERT INTO bok_forfatter VALUES(24, 12);
INSERT INTO bok_forfatter VALUES(25, 12);

INSERT INTO konsulent VALUES(DEFAULT, 'Anne', 'Hansen', 'anne.hansen@xxx.com');
INSERT INTO konsulent VALUES(DEFAULT, 'Bjørn', 'Jensen', 'bjornj@yyy.com');
INSERT INTO konsulent VALUES(DEFAULT, 'Anne', 'Ås', 'anne.as@zzz.com');

-- 1 a) SELECT * FROM `bok` WHERE `utgitt_aar` > 1990
--    SELECT DISTINCT `bok_id`, `tittel` FROM `bok`

-- 1 b)  SELECT * FROM forlag, bok
--   Den lagde et kryssprodukt mellom bok og forlag. Det ble 200 resultater. Det vil si 25 bøker multiplisert med 8 forlag

-- 1 c) SELECT * FROM forlag, bok WHERE forlag.forlag_id = bok.forlag_id     (equijoin) den nye tabellen oppgir all forlagsinformasjon til hver bok
--    SELECT * FROM forlag NATURAL JOIN bok      (NATURAL JOIN) returnerer en sammenslått tabell uten at det er like atributter, dvs forlag_id står kun 1 gang

-- 1 d)  SELECT forlag_id FROM forlag UNION SELECT bok_id FROM bok; forlag_id og bok_id er unionkompatible fordi de har samme antall atributter og er samme type


-- 2 a) SELECT DISTINCT forlag_navn FROM forlag;    Brukte Projeksjon

-- 2 b) SELECT forlag_id FROM forlag LEFT JOIN bok USING (forlag_id) WHERE bok.forlag_id is null
-- 1, 4, 6. Brukte left join og USING

-- 2 c) SELECT * FROM forfatter WHERE fode_aar = 1948
--     13, Henning Mankell 1948, Svensk

-- 2 d) SELECT forlag_navn, adresse FROM forlag LEFT JOIN bok USING (forlag_id) WHERE bok.tittel = 'Generation X'
-- Harper Collins, USA

-- 2 e) SELECT tittel FROM bok NATURAL JOIN forfatter NATURAL JOIN bok_forfatter WHERE etternavn = 'Hamsun'
--     Markens grøde, Victoria, Sult

-- 2 f) SELECT bok.tittel, bok.utgitt_aar, forlag.forlag_navn, forlag.adresse, forlag.telefon from bok NATURAL JOIN forlag NATURAL JOIN bok_forfatter
