class Ingenior extends Person{

  public Ingenior(int personID, String navn, int lonn, int ansAr){
    super(personID, navn, lonn, ansAr);
  }

  @Overide
  public double beregnKostnad(int antTimer){
    int ansinitet = getAnsinitet();
    if(ansinitet<3){
      return 1.6*getLonn()*antTimer;
    } else if(ansinitet>2 && ansinitet<6){
      return 1.8*getLonn()*antTimer;
    } else{ return 2.1*getLonn()*antTimer;
    }
   }
}
