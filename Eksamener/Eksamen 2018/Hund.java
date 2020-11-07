class Hund extends Dyr{
  public static int STOR = 3;
  public static int MIDDELS = 2;
  public static int LITEN = 1;
  public static final double PRIS_HUND = 360;
  public static final double TILLEGG_STOR = 50;
  public static final double TILLEGG_MIDDELS = 30;

  private final int str;

  public Hund(int dyrId, String navn, int str){
    super(dyrId, navn);
    if(str <1 || str>3){
      throw new IllegalArgumentException("Feil størrelse");
    }
    this.str = str;
  }
}
