/**
 * Øving 3 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_ov_studoppg.php
 * 
 * Du skal her løse et problem ved først å bruke tabeller, deretter ArrayList.
 * Tips: Se kapittel 12.2 og 13.5 i boka.
 */
import java.util.*;
class OppgaveOversiktArraylist{
  private ArrayList<Student> studenter;
  private int antStud;

  public OppgaveOversiktArraylist(ArrayList<Student> studenter){
    this.studenter = studenter;
    antStud = 0;
  }

  public int finnAntStud(){
    return antStud;
  }


  public boolean regNyStud(String navn){
    if(!(navn instanceof String)){
      throw new IllegalArgumentException("Navnet må være en streng");
    }
    if(navn == null){
      throw new IllegalArgumentException("Du må skrive inn et navn");
    }

    for(int i = 0; i<studenter.size(); i++){
      if(navn.equals(studenter.get(i).getNavn())){
        return false;
      }
    }


    Student nyStudent = new Student(navn);
    studenter.add(nyStudent);
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

    for(int i = 0; i<studenter.size(); i++){
      if((studenter.indexOf(i)) > -1){
        resultat = studenter.get(i).getAntOppg();
      }
      resultat = -1;
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

    int nyAntallOppg;
    int hvilkenStud = studenter.indexOf(navn);

    for(int i = 0; i<studenter.size(); i++){
      if((hvilkenStud) > -1){
        nyAntallOppg = studenter.get(hvilkenStud).getAntOppg() + okning;
        studenter.get(hvilkenStud).setAntOppg(nyAntallOppg);
      }
      throw new IllegalArgumentException("Denne studenten finnes ikke");
    }

    return true;
  }

  public String[] finnAlleNavn(){
    String[] alleNavn = new String[antStud];

    for(int i = 0; i<studenter.size(); i++){
      alleNavn[i] = studenter.get(i).getNavn();
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
