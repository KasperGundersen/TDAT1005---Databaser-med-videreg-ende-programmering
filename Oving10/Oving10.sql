
/**
 * Øving 10 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_sql1.php
 */


-- Oppgave 1.Finn alle borettslag etablert i årene 1975-1985.
SELECT * FROM borettslag WHERE etabl_aar BETWEEN 1975 AND 1985
-- Svar: Tertitten, etabl_aar: 1980


-- Oppgave 2. Skriv ut en liste over andelseiere
SELECT fornavn, etternavn, ", ansiennitet: " , ansiennitet, "aar" FROM andelseier ORDER BY ansiennitet


-- Oppgave 3 I Hvilket åt ble det eldste borettslaget etablert?
SELECT MIN(etabl_aar) FROM borettslag WHERE etabl_aar
-- Svar: 1980


-- Oppgave 4. Finn adressene til alle bygninger som innneholder leiligheter med minst tre rom
SELECT bygn_adr FROM bygning NATURAL JOIN leilighet WHERE ant_rom >= 3
-- svar: Åsveien 100a


-- Oppgave 5. Finn antall bygninger i botettslaget "Tertitten"
SELECT COUNT(*) FROM bygning WHERE bolag_navn = 'Tertitten'
-- Svar: 4

-- Oppgave 6. Lag en liste som viser antall bygninger i hvert enkelt borettslag.
SELECT borettslag.bolag_navn, COUNT(bygning.bygn_id) FROM bygning RIGHT OUTER JOIN borettslag ON borettslag.bolag_navn = bygning.bolag_navn
 GROUP BY borettslag.bolag_navn ORDER BY borettslag.bolag_navn
-- 0, 1, 4

-- Oppgave 7.Finn antall leiligheter i borettslaget "Tertitten".
SELECT COUNT(leilighet.leil_nr) FROM leilighet NATURAL JOIN bygning WHERE bygning.bolag_navn = "Tertitten"
--Svar = 4

-- Oppgave 8. Hvor høyt kan du bo i borettslaget "Tertitten"?
SELECT max(leilighet.etasje) FROM leilighet NATURAL JOIN bygning WHERE bygning.bolag_navn = "Tertitten"
-- Svar: 3.etasje

-- Oppgave 9. Finn navn og nummer til andelseiere som ikke har leilighet.
SELECT andelseier.fornavn, andelseier.etternavn, andelseier.and_eier_nr FROM andelseier NATURAL JOIN leilighet WHERE leilighet.and_eier_nr = null
--

-- Oppgave 10. Finn antall andelseiere pr borettslag, sortert etter antallet
SELECT borettslag.bolag_navn, COUNT(andelseier.and_eier_nr) AS antall FROM borettslag
LEFT JOIN andelseier ON andelseier.bolag_navn = borettslag.bolag_navn GROUP BY bolag_navn ORDER BY antall
-- Lerken = 0, Sisiken = 1, Tertitten = 4

-- Oppgave 11. Skriv ut en liste over alle andelseiere.
SELECT andelseier.fornavn, andelseier.etternavn, leilighet.leil_nr FROM andelseier
LEFT JOIN leilighet ON leilighet.and_eier_nr = andelseier.and_eier_nr


-- Oppgave 12. Hvilke borettslag har leiligheter med eksakt 4 rom?
SELECT borettslag.bolag_navn FROM borettslag JOIN leilighet WHERE leilighet.ant_rom = 4
-- Fikk ikkke noe resultat. Fordi ikke noe borettslag har leiligheter med nøyaktig 4 rom


-- Oppgave 13. Skriv ut en liste over antall andelseiere pr postnr og poststed, begrenset til de som bor i leiligheter tilknyttet et borettslag.
SELECT poststed.postnr, poststed.poststed, COUNT(leilighet.and_eier_nr) FROM poststed
LEFT JOIN bygning ON poststed.postnr = bygning.postnr
JOIN leilighet ON leilighet.bygn_id GROUP BY poststed.postnr
