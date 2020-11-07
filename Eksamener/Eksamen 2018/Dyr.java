abstract class Dyr {
  private final int dyrId;
  private final String navn;
  private ArrayList<Opphold> oppholdene = new ArrayList<Opphold>();

  protected Dyr(int dyrId, String navn){
    this.dyrId = dyrId;
    this.navn = navn;
  }

  public int getDyrId(){
    return dyrId;
  }

  public String getNavn(){
    return navn;
  }

  abstract double beregnNettoprisPerDogn();

  public void leggTilOpphold(Opphold nyttOpphold){
    oppholdene.add(nyttOpphold);
  }

  public Opphold getOpphold(LocalDate fra, LocalDate til){
    for(Opphold o: oppholdene){
      if(o.getFraDato.equls(fra) && o.getTilDato.equals(til)){
        return o;
      }
    }
    return null;
  }

  public boolean OverlappOpphold(LocalDate fra, LocalDate til){
    for(Opphold o: oppholdene){
      if(o.overlapp(fra,til)){
        return true;
      }
    }
    return false;
  }

  public Opphold finnOpphold(LocalDate fra){
    for(Opphold o: oppholdene){
      if(o.getFraDato.equals(fra)){
        return o;
      }
    }
    return null;
  }
}
