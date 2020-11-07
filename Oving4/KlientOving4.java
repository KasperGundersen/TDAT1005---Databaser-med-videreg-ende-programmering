/**
 * Øving 4 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_aggregeringer.php
 */
import static javax.swing.JOptionPane.*;
import javax.swing.ImageIcon;
class KlientOving4{

  public static void main(String[] args) {
    String[] muligeValg = {"Registrere nytt rom", "Reserver rom", "Skriv ut all registrert info", "Finn rom"};
    String valg = (String) showInputDialog(null, "Velg fra menyen under:",  "Gunnis Konferansesenter",
    DEFAULT_OPTION,null, muligeValg, muligeValg[0]);

    Konferansesenter Gunnis = new Konferansesenter();

    while(valg != null){
      if(valg == muligeValg[0]){
        String rom = showInputDialog("Skriv inn romnummer:");
        String kapasitet = showInputDialog("Skriv inn hvor mange personer rommet har plass til:");
        int romLest = Integer.parseInt(rom);
        int kapasitetLest = Integer.parseInt(kapasitet);
        Gunnis.regNyttRom(romLest, kapasitetLest);
        System.out.println("Rom registrert");
      }
      else if(valg == muligeValg[1]){
        String tidFra = showInputDialog("Skriv inn tid Fra:");
        long tidFraLest = Long.parseLong(tidFra);
        String tidTil = showInputDialog("Skriv inn tid TIL:");
        long tidTilLest = Long.parseLong(tidTil);
        String navn = showInputDialog("Skriv inn navn på Kunde:");
        String tlf = showInputDialog("Skriv inn telefonnummer på kunde:");
        String antPers = showInputDialog("Skriv inn antall personer:");
        int antPersLest = Integer.parseInt(antPers);

        Kunde nyKunde = new Kunde(navn, tlf);
        Tidspunkt fra = new Tidspunkt(tidFraLest);
        Tidspunkt til = new Tidspunkt(tidTilLest);

        Gunnis.reservereRom(fra, til, nyKunde, antPersLest);

        System.out.println(navn + " har reservert rom nr: " + Gunnis.getRomNr());
      }
      else if(valg == muligeValg[2]){
        String rom = showInputDialog("Velg indeksen til rommet du vil få informasjon om:");
        int romLest = Integer.parseInt(rom);
        Rom valgtRom = Gunnis.finnRom(romLest);
        System.out.println("Antall rom i konfereansesenteret: " + Gunnis.getAntallRom());
        System.out.println(valgtRom.toString());
      }
      else if(valg == muligeValg[3]){
        String rom1 = showInputDialog("Velg romnummeret til rommet du vil få informasjon om:");
        int rom1Lest = Integer.parseInt(rom1);
        Rom valgtRom1 = Gunnis.finnRom(rom1Lest);
        System.out.println(valgtRom1.toString());
      }
    valg = (String) showInputDialog(null, "Velg fra menyen under:",  "Gunnis Konferansesenter",
     DEFAULT_OPTION, null, muligeValg, muligeValg[0]);
    }
  }
}
