/*
Øving 7 - TDAT1005 Databaser med videregående programmering(2019 vår)
http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly1.php
*/
import java.time.*;
import java.util.Random;
import java.util.ArrayList;

class Medlemsarkiv{
  Random rand = new Random();
  private ArrayList<BonusMedlem> medlemmer;

  public Medlemsarkiv(){
    medlemmer = new ArrayList<BonusMedlem>();
  }

  public ArrayList getArraylist(){
    return this.medlemmer;
  }

  public int finnPoeng(int medlNr, String passord){
    int result = 0;
    for(BonusMedlem m: medlemmer){
      if(m.getMedlNr() == medlNr && m.okPassord(passord)){
        result = m.getPoeng();
      }
      result = -1;
    }
    return result;
  }

  public boolean registrerPoeng(int medlNr, int poeng){
    boolean status = false;
    for(BonusMedlem m: medlemmer){
      if(m.getMedlNr() == medlNr){
        status = m.registrerPoeng(poeng);
      }
      status =  false;
    }
    return status;
  }

  private int finnLedigNr(){
    int ledig = 0;
    for(BonusMedlem m: medlemmer){
      int tilfeldig = rand.nextInt(1000000000);
      if(!(m.getMedlNr() == tilfeldig)){
        ledig = tilfeldig;
      }
    }
    return ledig;
  }

  public int nyMedlem(Personalia pers, LocalDate innmeldt){
    int medlemsNr = finnLedigNr();
    BasicMedlem nyttMedlem = new BasicMedlem(medlemsNr, pers, 0, innmeldt);
    medlemmer.add(nyttMedlem);
    return medlemsNr;
  }

  public boolean sjekkMedlemmer(){
    for(BonusMedlem m: medlemmer){
      if(m instanceof BasicMedlem){
        if(m.finnKvalPoeng(m.getInmeldt()) > 25000 && m.finnKvalPoeng(m.getInmeldt()) <75000){
          SolvMedlem nyttSolv = new SolvMedlem(m.getMedlNr(), m.getPersonalia(), m.getPoeng(), m.getInmeldt());
          medlemmer.set(medlemmer.indexOf(m), nyttSolv);
          return true;
        }
        else if(m.finnKvalPoeng(m.getInmeldt()) > 75000){
          GullMedlem nyttGull = new GullMedlem(m.getMedlNr(), m.getPersonalia(), m.getPoeng(), m.getInmeldt());
          medlemmer.set(medlemmer.indexOf(m), nyttGull);
          return true;
        }
      }

      if(m instanceof SolvMedlem){
        if(m.finnKvalPoeng(m.getInmeldt()) > 75000){
         GullMedlem nyttGull = new GullMedlem(m.getMedlNr(), m.getPersonalia(), m.getPoeng(), m.getInmeldt());
         medlemmer.set(medlemmer.indexOf(m), nyttGull);
         return true;
       }
      }
    }
    return false;
  }

  public String toString(LocalDate a) {
  		String utskrift = "Info: \n";
  		for(BonusMedlem bm: medlemmer) {
  			utskrift += bm.getMedlNr() + ": " + bm.finnKvalPoeng(a) + "\n";
  		}
  		return utskrift;
  	}
}
