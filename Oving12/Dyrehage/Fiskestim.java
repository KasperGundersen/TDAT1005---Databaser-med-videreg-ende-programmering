/**
 * Øving 12 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly3.php
 */

import Dyrehage.Dyregruppe;

import java.time.LocalDate;

public class Fiskestim extends Dyregruppe {
    private final int gejnnomsnitligLengde;
    private final boolean kanDeleAkvarium;

    public Fiskestim(String gruppenavn, int antIndivider, String norskNavn, String latNavn, String latFamilie,
                     LocalDate ankommetDato, String adresse, int gejnnomsnitligLengde, boolean kanDeleAkvarium) {
        super(gruppenavn, antIndivider, norskNavn, latNavn, latFamilie,
        ankommetDato, adresse);
        this.gejnnomsnitligLengde = gejnnomsnitligLengde;
        this.kanDeleAkvarium = kanDeleAkvarium;
    }

    public int getGejnnomsnitligLengde(){
        return gejnnomsnitligLengde;
    }

    public boolean getKanDeleAkvarium(){
        return kanDeleAkvarium;
    }
    @Override
    public String toString(){
        return super.toString() + "\n Gjennomsnittlengde: " + gejnnomsnitligLengde +
                "\n Kan de dele akvrium: " + (kanDeleAkvarium?" JA" : " NEI");
    }
}
