/**
 * Øving 4 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_aggregeringer.php
 */
import java.util.*;
class Konferansesenter{
  private ArrayList<Rom> rom;
  private int antRom;
  private int hvilketRom;

public Konferansesenter(){
  this.rom = new ArrayList<>();
  this.antRom = antRom;
}

  public void reservereRom(Tidspunkt tidFra, Tidspunkt tidTil, Kunde kunde, int antPers){
    Reservasjon nyReservasjon = new Reservasjon(tidFra, tidTil, kunde);

    for(Rom r: rom){
      if(r.getKapasitet() > antPers){
        r.reserver(nyReservasjon);
        hvilketRom = r.getRomNr();
      }
    }
  }

  public int getRomNr(){
    return hvilketRom;
  }

  public boolean regNyttRom(int romNr, int kapasitet){
    for(Rom r : rom){
      if(r.getRomNr() == romNr){
        return false;
      }
    }
    Rom nyttRom = new Rom(romNr, kapasitet);
    rom.add(nyttRom);
    return true;
  }

  public int getAntallRom(){
    return rom.size();
  }

  public Rom finnRomIndeks(int indeks){
    return rom.get(indeks);
  }

  public Rom finnRom(int romNr){
    return rom.get(romNr-1);
  }
}
