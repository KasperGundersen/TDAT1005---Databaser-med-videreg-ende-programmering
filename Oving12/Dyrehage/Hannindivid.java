/**
 * Øving 12 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly3.php
 */
import java.time.LocalDate;

public class Hannindivid extends Individ {


    public Hannindivid(String navn, LocalDate fdato, boolean hanndyr, boolean farlig, String gruppenavn, int antIndivider,
                       String norskNavn, String latNavn, String latFamilie,
                       LocalDate ankommetDato, String adresse) {
        super(navn, fdato, hanndyr, farlig, gruppenavn, antIndivider,
                norskNavn, latNavn, latFamilie,
                ankommetDato, adresse);
    }

    @Override
    public int getAntKull(){
        return 0;
    }
    @Override
    public void leggTilKull(int antall){};
    @Override
    public void leggTilNyttKull(){};
}
