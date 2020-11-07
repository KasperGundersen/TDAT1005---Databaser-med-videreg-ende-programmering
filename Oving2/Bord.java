/**
 * Øving 2 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_ov_bordres.php
 * 
 * 
 * Tema for denne oppgaven er tabeller av strenger og samarbeid mellom objekter.
 * Du skal lage et enkelt system for reservasjon av bord på en restaurant. 
 * Alle bordene er like store, og et bord er enten reservert eller ikke reservert. 
 * Dersom bordet er reservert lagrer vi navnet på den personen som har reservert bordet. 
 * Vi ser bort fra tidspunkter for reservasjon.
 */

class Bord{
  private String[] navn;
  private int antBord;

  public Bord(int antBord){
    this.antBord = antBord;
    this.navn = new String[antBord];
  }

  public int ledigeBord(){
    int teller = 0;

    for(int i = 0; i<navn.length; i++){
      if(navn[i] == null){
        teller++;
      }
    }
    return teller;
  }

  public int reserverteBord(){
    int teller = 0;

    for(int i = 0; i<navn.length; i++){
      if(!(navn[i] == null)){
        teller++;
      }
    }
    return teller;
  }

  public void frigiBord(int bord){
    String ledig = null;
    navn[bord] = ledig;
  }

  public void bookeBord(int bord, String nyttNavn){
    navn[bord] = nyttNavn;
  }

  public int forsteLedig(){
    int ledig = 0;
    for(int i = 0; i<navn.length; i++){
      if(navn[i] == null){
        ledig = i;
      }
    }
    return ledig;
  }

  public String[] bordNavn(){
    return navn;
  }

  public int antBord(){
    return antBord;
  }

}
