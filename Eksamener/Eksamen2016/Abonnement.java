public class Abonnement{
  public static final double prisMnd =99;
  public static final int grenseMMS = 100;
  public static final double prisMMS = 2;
  public static final double prisData = 79;

  private final Kunde betalendeKunde;
  private final int tlf;

  private double minutter = 0;
  private int sms = 0;
  private int mms = 0;
  private double gb = 0;
  private double rabatt = 0;

  public Abonnement(Kunde k, double rabatt, int tlf){
    this.betalendeKunde= k;
    this.rabatt = rabatt;
    this.tlf = tlf;
  }

  public Kunde getBetalendeKunde(){
    return betalendeKunde;
  }

  public int getTlf(){
    return tlf;
  }

  public double getRabatt(){
    return rabatt;
  }

  public void setRabatt(){
    this.rabatt = rabatt;
  }

  public int getMin(){
    return minutter;
  }
  public int getSms(){
    return sms;
  }
  public int getMms(){
    return mms;
  }
  public double getGb(){
    return gb;
  }

  protected double beregnPrisMms(int grense, double pris){
    return ((getMms() > grense)? (getMms()-grense)*pris : 0);
  }

  protected double beregnPrisGb(int grense, double pris){
    return ((getGb() > grense)?(getGb()-grense)*pris:0);
  }

  public double beregnBelop(){
    double pris= prisMnd + beregnPrisMms(grenseMMS, prisMMS) + beregnPrisGb(0,prisData);
    return pris - getRabatt();
  }

  public boolean equals(Object obj){
    if(!(obj instanceof Abonnement)){
      return false;
    }
    if(this == obj){
      return true;
    }
    Abonnement a = (Abonnement) obj;
    return (a.tlf == this.tlf);
  }
}
