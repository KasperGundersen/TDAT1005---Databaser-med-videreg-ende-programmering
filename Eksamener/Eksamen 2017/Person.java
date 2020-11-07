abstract class Person{
  private int personID;
  private String navn;
  private int lonn;
  private int ansAr;

  public Person(int personID, String navn, int lonn, int ansAr){
    this.personID = personID;
    this.navn = navn;
    this.epost = lonn;
    this.tlf = ansAr;
  }

  public getPersonID(){
    return personID;
  }

  public getNavn(){
    return navn;
  }

  public getLonn(){
    return lonn;
  }

  public getAnsAr(){
    return ansAr;
  }

  public abstract double beregnKostnad(int antTimer){}

  public int getAnsinitet(){
    return 2017 - ansAr;
  }

  public boolean equals(Object obj){
    if(!(obj instanceof Person)){
      return false;
    }
    if(this == obj){
      true;
    }
    Person p = (Person) obj;
    return(personID == p.personID);
  }
}
