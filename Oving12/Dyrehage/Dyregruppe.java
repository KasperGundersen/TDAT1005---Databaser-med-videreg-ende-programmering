/**
 * Øving 12 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly3.php
 */
import Dyrehage.Dyr;

import java.time.LocalDate;

public class Dyregruppe extends Dyr {
    private final String gruppenavn;
    private int antIndivider;

    public Dyregruppe(String gruppenavn, int antIndivider, String norskNavn, String latNavn, String latFamilie,
                      LocalDate ankommetDato, String adresse){
        super(norskNavn, latNavn, latFamilie,
        ankommetDato, adresse);
        this.gruppenavn = gruppenavn;
        this.antIndivider = antIndivider;
    }

    @Override
    public String getNorskNavn(){
        return "Gruppe av " + super.getNorskNavn();
    }

    public String getGruppenavn(){
            return gruppenavn;
    }

    public int getAntIndivider(){
        return antIndivider;
    }

    public void setAntIndivider(int nyAntIndivider){
        antIndivider = nyAntIndivider;
    }

    @Override
    public String toString(){
        return super.toString() + "\nGruppenavn: " + gruppenavn +
                "\nAntall individer: " + antIndivider;
    }
}
