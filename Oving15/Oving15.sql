/*
Øving 15 - TDAT1005 Databaser med videregående programmering(2019 vår)
http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_datamod1.php
*/

create table Oppdrag(
oppdrag_nr integer not null,
start_dato DATE not null,
slutt_dato date not null,
bed_id INTEGER not null,
kandidat_id integer not null,
kvalifikasjons_id integer not null,
constraint oppdrag_pk primary key (oppdrag_nr),
constraint oppdrag_fk foreign key (bed_id) references
Bedrift(bed_id),
CONSTRAINT oppdrag_fk1 FOREIGN KEY (kandidat_id)
REFERENCES Kandidat(kandidat_id),
CONSTRAINT oppdrag_fk2 FOREIGN KEY (kvalifikasjons_id)
REFERENCES Kvalifikasjon(kvalifikasjons_id)
);

create table Bedrift(
bed_id INTEGER not null,
bed_navn varchar (50),
bed_epost varchar (50),
bed_telefon INTEGER not null,
constraint Bedrift_pk primary key (bed_id)
);

create table Kandidat(
kandidat_id integer not null,
fornavn varchar (50),
etternavn varchar (50),
telefon integer not null,
epost varchar (50),
constraint Kandidat_pk primary key (kandidat_id)
);

create table Kvalifikasjon(
kvalifikasjons_id integer not null,
navn_kval varchar (50),
kvalifikasjons varchar (200),
constraint Kvalifikasjon_pk primary key (kvalifikasjons_id)
);

create table Kobling(
kvalifikasjons_id integer,
kandidat_id integer,
constraint kobling_pk primary key (kvalifikasjons_id, kandidat_id),
constraint Kobling_fk foreign key (kvalifikasjons_id)
REFERENCES Kvalifikasjon(kvalifikasjons_id),
constraint Kobling_fk1 foreign key (kandidat_id)
REFERENCES Kandidat(kandidat_id)
);



insert into Kandidat(kandidat_id, fornavn, etternavn, telefon, epost) values(1,'Kasper', 'Gundersen', 94808833, 'lol@live.no');
insert into Kandidat(kandidat_id, fornavn, etternavn, telefon, epost) values(2,'Max', 'Gira', 99908833, 'yaha@shot.no');
insert into Kandidat(kandidat_id, fornavn, etternavn, telefon, epost) values(3,'Helene', 'Gjengedal', 46961063, 'bommelom@hei.com');
insert into Kandidat(kandidat_id, fornavn, etternavn, telefon, epost) values(4,'Emir', 'Der', 12312312, 'shakabra@surf.wey');


insert into Kvalifikasjon(kvalifikasjons_id, navn_kval, kvalifikasjons) values(5,'Ingen', 'Trenger ingen kvalifikasjoner');
insert into Kvalifikasjon(kvalifikasjons_id, navn_kval, kvalifikasjons) values(6,'Over 30', 'Trenger noen gamle');
insert into Kvalifikasjon(kvalifikasjons_id, navn_kval, kvalifikasjons) values(7,'Arbeidserfaring', 'Trenger noen som har jobbet før');

insert into Bedrift(bed_id, bed_navn, bed_epost, bed_telefon) values(980100,'Bedrift','dette er en mail', 90454934);

insert into Oppdrag(oppdrag_nr, start_dato, slutt_dato, bed_id, kandidat_id, kvalifikasjons_id) values(10, 2019-02-26, 2019-02-28,980100,1, 5);
insert into Oppdrag(oppdrag_nr, start_dato, slutt_dato, bed_id, kandidat_id, kvalifikasjons_id) values(3, 2019-02-10, 2019-02-20,980100,2, 7);

insert into Kobling(kvalifikasjons_id, kandidat_id) values(5, 1);
insert into Kobling(kvalifikasjons_id, kandidat_id) values(6, 1);
insert into Kobling(kvalifikasjons_id, kandidat_id) values(7, 3);
insert into Kobling(kvalifikasjons_id, kandidat_id) values(5, 3);

-- d)

-- 1. Lag en liste over alle bedriftene. Navn, telefon og epost til bedriften skal skrives ut.
SELECT * FROM `Bedrift`

-- 2. Lag en liste over alle oppdragene.
-- Skriv ut: oppdragets nummer, bed_navn og bed_telefon
SELECT Oppdrag.oppdrag_nr, Bedrift.bed_navn, Bedrift.bed_telefon
FROM Oppdrag JOIN Bedrift ON Oppdrag.bed_id = Bedrift.bed_id

--3. Lag en liste over kandidater og kvalifikasjoner.
-- Skriv ut: Kandidatnavn og kvalifikasjonsbeskrivelse, kandidat_id og kvalifikasjon_id.
SELECT distinct Kandidat.kandidat_id, Kandidat.fornavn, Kandidat.etternavn,
Kvalifikasjon.kvalifikasjons_id, Kvalifikasjon.kvalifikasjons
FROM Kandidat JOIN Kobling USING(kandidat_id)
JOIN Kvalifikasjon USING(kvalifikasjons_id)

--4.
SELECT distinct Kandidat.kandidat_id, Kandidat.fornavn, Kandidat.etternavn,
 Kvalifikasjon.kvalifikasjons_id, Kvalifikasjon.kvalifikasjons
 FROM Kandidat left JOIN Kobling USING(kandidat_id)
 JOIN Kvalifikasjon USING(kvalifikasjons_id)

-- 5.Skriv ut jobbhistorikken til en bestemt vikar, gitt kandidatnr.
-- Vikarnavn, sluttdato, oppdragsnr og bedriftsnavn skal med.
SELECT Kandidat.fornavn, Kandidat.etternavn, Oppdrag.slutt_dato,
Oppdrag.oppdrag_nr, Bedrift.bed_navn
FROM Kandidat JOIN Oppdrag USING(kandidat_id)
JOIN Bedrift USING(bed_id) WHERE Kandidat.kandidat_id = 2

