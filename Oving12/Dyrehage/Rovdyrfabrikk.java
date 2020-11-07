/**
 * Øving 12 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly3.php
 */
import java.time.LocalDate;

public class Rovdyrfabrikk {

    public Rovdyrfabrikk(){};
    public SkandinaviskeRovdyr nyBinne(String navn, LocalDate ankommetDato, LocalDate fDato, String adresse, int antallKull){
        return new Hunnindivid(navn, fDato, false, true, "GunnisGæng",
                80, "Brunbjørn", "Ursus arctos", "Ursidae", ankommetDato,
                adresse, antallKull);
    }
    public SkandinaviskeRovdyr nyHannbjørn(String navn, LocalDate ankommetDato, LocalDate fDato, String adresse){
        return new Hannindivid(navn, fDato, true, true, "GunnisGæng",
                80, "Brunbjørn", "Ursus arctos", "Ursidae", ankommetDato,
                adresse);
    }
    public SkandinaviskeRovdyr nyUlvetispe(String navn, LocalDate ankommetDato, LocalDate fDato, String adresse,  int antallKull){
        return new Hunnindivid(navn, fDato, false, true, "ZaimGæng",
                20, "Ulv", "Canis lupus", "Canidae", ankommetDato,
                adresse, antallKull);
    }
    public SkandinaviskeRovdyr nyUlvehann(String navn, LocalDate ankommetDato, LocalDate fDato, String adresse) {
        return new Hannindivid(navn, fDato, true, true, "ZaimGæng",
                20, "Ulv", "Canis lupus", "Canidae", ankommetDato,
                adresse);
    }
}
