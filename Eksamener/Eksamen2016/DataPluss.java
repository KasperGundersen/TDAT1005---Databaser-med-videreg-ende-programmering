public class DataPluss extends MerData{
  public static final int grenseData = 3;
  public static final double prisMnd = 249

  public DataPluss(Kunde k, double rabatt, int tlf){
    super(k, rabatt, tlf);
  }

  @Override
  public double beregnBelop(){
    double pris = prisMnd + beregnPrisMms(grenseMMS, prisMMS) + beregnPrisGb(grenseData, prisEkstraData);
    return pris - getRabatt();
  }
}
