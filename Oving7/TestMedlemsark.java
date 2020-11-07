/*
Øving 7 - TDAT1005 Databaser med videregående programmering(2019 vår)
http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly1.php
*/
import java.time.LocalDate;
import java.time.*;
import static javax.swing.JOptionPane.*;

class TestMedlemsark {
	public static void main(String[] args) {
		Personalia ole = new Personalia("Olsen", "Ole", "ole.olsen@dot.com", "ole");
    Personalia tove = new Personalia("Hansen", "Tove", "tove.hansen@dot.com", "tove");

    Medlemsarkiv ma = new Medlemsarkiv();

    LocalDate testdato = LocalDate.of(2008, 2, 10);

    int medlnr1 = ma.nyMedlem(ole, testdato);
    int medlnr2 = ma.nyMedlem(tove, testdato);
    System.out.println("nyttMedlem: " + medlnr1);
    System.out.println("nyttMedlem: " + medlnr2);

    ma.registrerPoeng(medlnr1, 100000);
    ma.registrerPoeng(medlnr2, 50000);

    System.out.println(ma.toString(testdato));

    ma.sjekkMedlemmer();

    ma.registrerPoeng(medlnr1, 5000);
    ma.registrerPoeng(medlnr2, 20000);

    System.out.println(ma.toString(testdato));

	}
}
