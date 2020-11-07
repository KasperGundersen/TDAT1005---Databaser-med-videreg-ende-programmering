class PersonTimer{
  private final Person p;
  private final int ukeNr;
  private int timer;

  public PersonTimer(Person p, int ukeNr, int timer){
    this.p = p;
    this.ukeNr = ukeNr;
    this.timer = timer;
  }

  public Person getPerson(){
    return p;
  }

  public int getUkeNr(){
    return ukeNr;
  }

  public int getTimer(){
    return timer;
  }

  public void setTimer(int timer){
    this.timer = timer;
  }
}
