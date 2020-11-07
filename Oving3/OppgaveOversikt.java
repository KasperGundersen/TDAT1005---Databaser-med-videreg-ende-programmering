/**
 * Øving 3 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_ov_studoppg.php
 * 
 * Du skal her løse et problem ved først å bruke tabeller, deretter ArrayList.
 * Tips: Se kapittel 12.2 og 13.5 i boka.
 */
class OppgaveOversikt{
  private Student[] studenter = new Student[5];
  private int antStud = 0;

//  public OppgaveOversikt(Student[] studenter){
//    this.studenter = studenter;
//  }

  public int finnAntStud(){
    return antStud;
  }

  public void utvidTab(){
    Student[] nyTab = new Student[studenter.length + 5];
    for(int i = 0;i<antStud; i++){
      nyTab[i] = studenter[i];
    }
    studenter = nyTab;
  }

  public boolean regNyStud(String navn){
    if(!(navn instanceof String)){
      throw new IllegalArgumentException("Navnet må være en streng");
    }
    if(navn == null){
      throw new IllegalArgumentException("Du må skrive inn et navn");
    }

    for(int i = 0; i<antStud; i++){
      if(navn.equalsIgnoreCase(studenter[i].getNavn())){
        return false;
      }
    }

    if(studenter.length == antStud){
      utvidTab();
    }


    Student nyStudent = new Student(navn);
    studenter[antStud] = nyStudent;
    antStud++;
    return true;
  }

  public int finnAntOppgaver(String navn){
    if(!(navn instanceof String)){
      throw new IllegalArgumentException("Navnet må være en streng");
    }
    if(navn == null){
      throw new IllegalArgumentException("Du må skrive inn et navn");
    }
    int resultat = 0;

    for(int i = 0; i<antStud; i++){
      if(navn.equals(studenter[i].getNavn())){
        resultat = studenter[i].getAntOppg();
      }
      // resultat = -1;
    }
    return resultat;
  }

  public boolean okAntOppg(String navn, int okning){
    if(okning<1){
      throw new IllegalArgumentException("Nytt antall med godkjente oppgaver må være over 0");
    }
    if(!(navn instanceof String)){
      throw new IllegalArgumentException("Navnet må være en streng");
    }

    if(navn == null){
      throw new IllegalArgumentException("Du må skrive inn et navn");
    }

    int nyAntallOppg = 0;
    int hvilkenStud = 0;

    for(int i = 0; i<antStud; i++){
      if(navn.equals(studenter[i].getNavn())){
        hvilkenStud = i;
      }
      // throw new IllegalArgumentException("Denne studenten finnes ikke");
    }
    nyAntallOppg = studenter[hvilkenStud].getAntOppg() + okning;
    studenter[hvilkenStud].setAntOppg(nyAntallOppg);
    return true;
  }

  public String[] finnAlleNavn(){
    String[] alleNavn = new String[antStud];

    for(int i = 0; i<antStud; i++){
      alleNavn[i] = studenter[i].getNavn();
    }
    return alleNavn;
  }

  public String toString(){
    String studentene = "";
    String s = "";
    for(int i = 0; i<finnAlleNavn().length; i++){
      s = Integer.toString(finnAntOppgaver(finnAlleNavn()[i]));
      studentene += "\n" + finnAlleNavn()[i] + ": " + s;
    }
    return "Antall studenter: " + antStud + "\n Studentenes navn og oppgaver godkjent: " + studentene;
  }
}
