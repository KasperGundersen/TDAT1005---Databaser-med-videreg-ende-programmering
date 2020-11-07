class Admin extends Person{

  public Admin(int personID, String navn, int lonn, int ansAr){
    super(personID, navn, lonn, ansAr);
  }

  @Overide
  public double beregnKostnad(int antTimer){
    return getLonn()*antTimer*1.4;
  }
}
