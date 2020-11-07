/**
 * Øving 3 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_ov_studoppg.php
 * 
 * Du skal her løse et problem ved først å bruke tabeller, deretter ArrayList.
 * Tips: Se kapittel 12.2 og 13.5 i boka.
 */
class Student{
  private final String navn;
  private int antOppg;


  public Student(String navn){
    this.navn = navn;
    this.antOppg = 0;
  }

  public String getNavn(){
    return navn;
  }
  public int getAntOppg(){
    return antOppg;
  }
  public void setAntOppg(int nyAntOppg){
    if(antOppg<0){
      throw new IllegalArgumentException("Må være et positivt tall");
    }
    antOppg = nyAntOppg;
  }

  public String toString(){
    return "Navn: " + navn + "\n Antall oppgaver godkjent: " + antOppg;
  }
}
