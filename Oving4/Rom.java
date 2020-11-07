/**
 * Øving 4 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_aggregeringer.php
 */
import java.util.*;
class Rom{
  private int romNr;
  private int kapasitet;
  private ArrayList<Reservasjon> reservasjoner;

  public Rom(int romNr, int kapasitet){
    this.romNr = romNr;
    this.kapasitet = kapasitet;
    this.reservasjoner = new ArrayList<>();
  }

  public int getRomNr(){
    return romNr;
  }
  public int getKapasitet(){
    return kapasitet;
  }
  public void reserver(Reservasjon reservasjon){

    for(Reservasjon r: reservasjoner){
      if(!(r.overlapp(reservasjon.getFraTid(), reservasjon.getTilTid()))){
        if(r == null){
          reservasjoner.add(reservasjon);
        }
      }
    }
  }

  public String toString(){
    return "Romnummer: " + getRomNr() + " , kapasitet: " + getKapasitet();
  }

  public static void main(String[] args) {

    System.out.println("Totalt antall tester: 2");
    Rom rom1 = new Rom(1, 10);
    Rom rom2 = new Rom(2, 15);

    if(rom1.getRomNr() == 1 && rom2.getRomNr() == 2){
      System.out.println("Test 1: vellykket");
    }
    if(rom1.getKapasitet() == 10 && rom2.getKapasitet() == 15){
      System.out.println("Test 2: vellykket");
    }
  }
}
