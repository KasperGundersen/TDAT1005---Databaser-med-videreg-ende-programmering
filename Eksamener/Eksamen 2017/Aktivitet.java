class Aktivitet{
  private int aktivitetNr;
  private double budsjettIng;
  private double budsjettAdmin;
  private ArrayList<PersonTimer> personTimer = new ArrayList<>();

  public Aktivitet(int aktivitetNr, double budsjettIng, double budsjettAdmin){
    this.aktivitetNr = aktivitetNr;
    this.budsjettIng = budsjettIng;
    this.budsjettAdmin = budsjettAdmin
  }

  public int getAktivitetNr(){
    return aktivitetNr;
  }

  public double getBudsjettIng(){
    return budsjettIng;
  }

  public double getBudsjettAdmin(){
    return budsjettAdmin;
  }

  public int sjekkPerson(Person p, int ukeNr){
    for(int i = 0; i<personTimer.size();i++){
      PersonTimer pt = personTimer.get(i);
      if(pt.getPerson().equals(p) && pt.getUkeNr().equals(ukeNr)){
        return i;
      }
    }
    return -1;
  }

  public void regAntTimer(Person p, int ukeNr, int timer){
    int index = sjekkPerson(p,ukeNr);
    if(index>=0){
      int gamleTimer = personTimer.get(index).getTimer();
      personTimer.get(index).setTimer(gamleTimer + timer);
    } else{
      PersonTimer pt = new PersonTimer(p,ukeNr,timer);
      personTimer.add(pt);
    }
  }

  public double beregnUtgiftIng(Ingenior i){
    double sum = 0;
    for(PersonTimer pt: personTimer){
      Person p = (Person) pt.getPerson();
      if(p instanceof Ingenior){
        sum += p.beregnKostnad(pt.getTimer());
      }
    }
    return sum;
  }

  public double beregnUtgiftAdmin(){
    int sum = 0;
    for(PersonTimer pt: personTimer){
      Person p = (Person) pt.getPerson();
      if(p instanceof Admin){
        sum += p.beregnKostnad(pt.getTimer());
      }
    }
    return sum;
  }

  public double finnTotBudsjett(){
    return budsjettIng + budsjettAdmin;
  }

  public double finnTotForbruk(){
    return beregnUtgiftIng() + beregnUtgiftAdmin();
  }
}
