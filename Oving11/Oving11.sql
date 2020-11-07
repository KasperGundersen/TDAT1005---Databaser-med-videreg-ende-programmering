/*
Øving 11 - TDAT1005 Databaser med videregående programmering(2019 vår)
http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_sql2.php
*/

--Oppgave 1. a) List ut all informasjon (ordrehode og ordredetalj) om ordrer for leverandør nr 44
SELECT * FROM ordrehode NATURAL JOIN ordredetalj WHERE levnr = 44


-- Oppgave 1. b) Finn navn og by ("LevBy") for leverandører som kan levere del nummer 1.
SELECT navn, levby FROM prisinfo JOIN levinfo USING(levnr) WHERE delnr = 1
--Svar: Kontorekspressen AS og Kontorustyr AS


--Oppgave 1. c) Finn nummer, navn og pris for den leverandør som kan levere del nummer 201 til billigst pris.
SELECT levinfo.navn, levinfo.levnr, prisinfo.pris FROM levinfo JOIN prisinfo ON levinfo.levnr = prisinfo.levnr ORDER BY prisinfo.pris LIMIT 1
-- Kontordata AS, Nummer = 82, pris = 0.35

-- Oppgave 1. d) Lag fullstendig oversikt over ordre nr 16
SELECT DISTINCT ordredetalj.ordrenr, ordrehode.dato, delinfo.delnr, delinfo.beskrivelse, ordredetalj.kvantum,
 prisinfo.pris, (pris*kvantum) AS begrenset_beløp FROM ordrehode JOIN ordredetalj
 ON ordrehode.ordrenr = ordredetalj.ordrenr JOIN prisinfo ON prisinfo.levnr JOIN delinfo
 ON delinfo.delnr WHERE ordrehode.ordrenr = 16


-- Oppgave 1. e) Finn delnummer og leverandørnummer for deler som...
SELECT DISTINCT ordredetalj.delnr, ordrehode.levnr FROM ordrehode JOIN ordredetalj
ON ordrehode.ordrenr = ordredetalj.ordrenr JOIN prisinfo ON prisinfo.delnr
WHERE prisinfo.pris > (prisinfo.katalognr = 'X7770')
--Svar: fikk 15 resultater

--Oppgave 1 f) I) Tenk deg at tabellen levinfo skal deles i to....
CREATE TABLE byerOgFylker(
    byer VARCHAR(50) NOT null,
    fylker VARCHAR(50) NOT null,
    CONSTRAINT byerOgFylker_pk PRIMARY KEY(byer)
  );
CREATE TABLE nyLevinfo(
    levnr Integer NOT null,
    navn varchar(30) not null,
    adresse varchar(30) NOT null,
    postnr integer,
    byer varchar(30) NOT null,
    CONSTRAINT nyLevinfo_pk PRIMARY KEY(levnr),
    CONSTRAINT nyLevinfo_pk FOREIGN KEY(byer) REFERENCES byerOgFylker(byer)
    );

-- Oppgave 1. f) II)
CREATE VIEW litenLevinfo AS SELECT levnr, navn, adresse, levby, postnr FROM nyLevinfo
CREATE VIEW litenByOgFylke AS SELECT byer, fylker FROM byerOgFylker
--insert funket ikke, sletting går ikke

--Oppgave 1. g) Finn ut hvilke byer en i tilfelle ikke får leverandør i
SELECT levinfo.levby FROM levinfo LEFT JOIN prisinfo ON prisinfo.levnr = levinfo.levnr
WHERE prisinfo.delnr is null AND levinfo.levby
NOT IN (SELECT levby FROM levinfo, prisinfo WHERE levinfo.levnr = prisinfo.levnr)

-- Oppgave 1. h) Finn leverandørnummer for den leverandør som kan levere ordre nr 18 til lavest totale beløp
CREATE VIEW ordre18 AS SELECT DISTINCT levinfo.navn, levinfo.levnr, prisinfo.delnr, ordredetalj.ordrenr, (prisinfo.pris*ordredetalj.kvantum) AS totPris FROM levinfo, prisinfo, ordredetalj WHERE levinfo.levnr = prisinfo.levnr AND prisinfo.delnr = ordredetalj.delnr AND ordredetalj.ordrenr = 18;
