/**
 * Øving 12 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly3.php
 */
import Dyrehage.*;
import java.time.LocalDate;
import java.time.Period;

public class testRovdyr {
    public static void main(String[] args){

        Rovdyrfabrikk rov = new Rovdyrfabrikk();
        LocalDate ankommetD = LocalDate.of(2019, 02, 12);
        LocalDate fDato = LocalDate.of(1999, 03, 13);

        SkandinaviskeRovdyr[] dyrene = new SkandinaviskeRovdyr[4];

        dyrene[0] = rov.nyBinne("Gunnis", ankommetD, fDato, "Hjemme", 3);
        dyrene[1] = rov.nyHannbjørn("Mannebjørn for life", ankommetD, fDato, "Hos naboen");
        dyrene[2] = rov.nyUlvehann("Daimelaim", ankommetD, fDato, "AzylVeita");
        dyrene[3] = rov.nyUlvetispe("Audun", ankommetD, fDato, "Mooooooo", 4);

        String testNavn = dyrene[0].getNavn();
        LocalDate testDato = dyrene[0].getFdato();
        int testAlder = dyrene[0].getAlder();
        String testAdresse = dyrene[0].getAdresse();
        dyrene[1].flytt("Langtvekkistan");
        int testKull = dyrene[0].getAntKull();
        dyrene[3].leggTilKull(2);




        for (int i = 0; i<dyrene.length; i++) {
            System.out.println("\n" + dyrene[i].skrivUtInfo());
        }

        if(testNavn.equals("Gunnis")){
            System.out.println("\nTest 1: getNavn = Vellykket");
        }
        if(testDato.equals(fDato)){
            System.out.println("Test 2: getFdato = Vellykket");
        }
        if(testAlder == (Period.between(fDato, LocalDate.now()).getYears())){
            System.out.println("Test 3: getAlder = Vellykket");
        }
        if(testAdresse.equals("Hjemme")){
            System.out.println("Test 4: getAdresse = Vellykket");
        }
        if(dyrene[1].getAdresse().equals("Langtvekkistan")){
            System.out.println("Test 5: flytt = Vellykket");
        }
        if(testKull == 3){
            System.out.println("Test 6: getKull = Vellykket");
        }
        if(testKull == 6){
            System.out.println("Test 7: leggTilKull = Vellykket");
        }

    }
}
