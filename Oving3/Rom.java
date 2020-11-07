/**
 * Øving 3 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_ov_studoppg.php
 * 
 * Du skal her løse et problem ved først å bruke tabeller, deretter ArrayList.
 * Tips: Se kapittel 12.2 og 13.5 i boka.
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
      if(r == null){
        reservasjoner.add(reservasjon);
      }
    }
  }
}
