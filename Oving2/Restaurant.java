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

class Restaurant{
  private String navn;
  private int anno;
  private Bord bord;

  public Restaurant(String navn, int anno, Bord bord){
    this.navn = navn;
    this.anno = anno;
    this.bord = bord;
  }

  public String getNavn(){
    return navn;
  }
  public int getAnno(){
    return anno;
  }

  public void setNavn(String nyttNavn){
    navn = nyttNavn;
  }
  public int getAlder(){
    return (2019-anno);
  }

  public int ledigeBord(){
    return bord.ledigeBord();
  }
  public int reserverteBord(){
    return bord.reserverteBord();
  }

  public void bookeBord(int antBord, String navn){
    if(antBord <= ledigeBord()){
      for(int i = 0; i<antBord; i++){
        bord.bookeBord(bord.forsteLedig(), navn);
      }
    } else {
      System.out.println("Det er ikke nok ledige bord");
    }
  }

  public int[] bordTilNavn(String navn){
    int teller = 0;
    for(int i = 0; i<bord.antBord();i++){
      if (bord.bordNavn()[i] != null){
        if(bord.bordNavn()[i].equals(navn)){
          teller++;
        }
      }

    }
    int[] resBord = new int[teller];
    int indeks = 0;
    for(int i = 0; i<bord.bordNavn().length; i++){
      if (bord.bordNavn()[i] != null){
        if(bord.bordNavn()[i].equals(navn)){
          resBord[indeks] = i;
          indeks++;
        }
      }
    }
    return resBord;
  }


  public void frigiBord(int[] nyttBord){
    for(int i = 0; i<nyttBord.length; i++){
      bord.frigiBord(nyttBord[i]);
    }
  }

  public static void main(String[] args){

    String kunde1 = "Kasper";
    String kunde2 = "Zaim";
    int antBord = 10;
    Bord bord = new Bord(antBord);
    Restaurant dominos = new Restaurant("Dominos", 1999, bord);

    System.out.println("Det er totalt 3 tester: ");

    System.out.println("Test 1: ");
    System.out.println("Ledige bord: " + dominos.ledigeBord());
    System.out.println("Reserverte bord: " + dominos.reserverteBord());

    System.out.println("\nTest 2: ");
    dominos.bookeBord(3, kunde1);
    int[] nyTab = dominos.bordTilNavn(kunde1);
    String utskrift = "";
    for(int i = 0; i<nyTab.length; i++){
        utskrift += nyTab[i] + ", ";
    }
    System.out.println(kunde1 + " har reservert bord\n" + utskrift);

  }
}
