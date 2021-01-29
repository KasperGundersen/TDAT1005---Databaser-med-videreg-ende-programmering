public class DataPlussPluss extends MerData{
  public final int grenseData = 10;
  public final double prisMnd = 379;

  public DataPlussPluss(Kunde k, double rabatt, int tlf){
    super(k,rabatt,tlf);
  }

  @Override
  public double beregnBelop(){
    double pris = prisMnd + beregnPrisGb(grenseData, prisEkstraData) + beregnPrisMms(grenseMMS,prisMMS);
    return pris - getRabatt();
  }
}
