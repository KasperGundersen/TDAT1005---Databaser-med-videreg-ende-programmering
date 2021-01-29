public class GratisMMS extends Abonnement{
  public static final double prisMnd = 199;

  public GratisMMS(Kunde k, double rabatt, int tlf){
    super(k, rabatt,tlf);
  }

  @Override
  public double beregnBelop(){
    double pris = prisMnd + beregnPrisGb(0,prisData);
    return pris - getRabatt();
  }
}
