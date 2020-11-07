/*
Øving 7 - TDAT1005 Databaser med videregående programmering(2019 vår)
http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly1.php
*/
import java.time.*;
class GullMedlem extends BonusMedlem{

  public GullMedlem(int medlNr, Personalia pers, int poeng, LocalDate innmeldtDato){
    super(medlNr, pers, poeng, innmeldtDato);
  }

  @Override
  public boolean registrerPoeng(int nyPoeng){
    int points = (int)(nyPoeng*1.5);

    return super.registrerPoeng(points);
  }
}
