/*
Øving 7 - TDAT1005 Databaser med videregående programmering(2019 vår)
http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly1.php
*/
import java.time.*;
class BonusMedlem{
  private final int medlNr;
  private final Personalia pers;
  private final LocalDate innmeldtDato;
  private int poeng = 0;

  public BonusMedlem(int medlNr, Personalia pers, int poeng, LocalDate innmeldtDato){
    this.medlNr = medlNr;
    this.pers = pers;
    this.poeng = poeng;
    this.innmeldtDato = innmeldtDato;
  }

  public int getMedlNr(){
    return medlNr;
  }

  public Personalia getPersonalia(){
    return pers;
  }

  public int getPoeng(){
    return poeng;
  }

  public LocalDate getInmeldt(){
    return innmeldtDato;
  }

  public int finnKvalPoeng(LocalDate dagensDato){
    if(!(dagensDato instanceof LocalDate)){
      throw new IllegalArgumentException("Du må skrive inn en gyldig dato");
    }

    int dagerMellom = Period.between(innmeldtDato, dagensDato).getDays();

    if(dagerMellom > 365){
      return poeng = 0;
    }
    return poeng;
  }

  public boolean okPassord(String passord){
    if(passord == null){
      throw new IllegalArgumentException("Du må skrive inn passordet");
    }
        return pers.okPassord(passord);
    }

    public boolean registrerPoeng(int nyPoeng){
      poeng += nyPoeng;
      return  true;
    }

}
