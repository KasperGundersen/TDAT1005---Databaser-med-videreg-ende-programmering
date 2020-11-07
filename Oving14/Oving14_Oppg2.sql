/*
Øving 14 - TDAT1005 Databaser med videregående programmering(2019 vår)
http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_normalisering.php
*/

create table kunde(
kunde_id integer not null,
navn varchar (50),
adresse varchar (50),
eiendoms_id INTEGER not null,
constraint kunde_pk primary key (kunde_id),
constraint kunde_fk foreign key (eiendoms_id) references
eiendom(eiendoms_id)
);

create table eier(
eier_id INTEGER not null,
navn varchar (50),
adresse varchar (50),
telefon INTEGER not null,
constraint eier_pk primary key (eier_id)
);

create table eiendom(
eiendoms_id integer not null,
adresse varchar (50),
eier_id integer,
constraint eiendom_pk primary key (eiendoms_id),
constraint eiendom_fk foreign key (eier_id) references
eier(eier_id)
);

create table utleierforhold(
fra_uke integer not null,
til_uke integer not null,
eiendom_id INTEGER not null,
kunde_id integer not null,
pris integer not null,
constraint utleierforhold_pk primary key (fra_uke, kunde_id, eiendom_id)
)