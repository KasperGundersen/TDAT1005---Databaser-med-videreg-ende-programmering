/**
 * Øving 8 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly2.php
 */
import java.io.*;
abstract class Tribune implements Serializable {
  private final String tribunenavn;
  private final int kapasitet;
  private final int pris;

  public Tribune(String tribunenavn, int kapasitet, int pris){
    this.tribunenavn = tribunenavn;
    this.kapasitet = kapasitet;
    this.pris = pris;
  }

  public String getNavn(){
    return tribunenavn;
  }

  public int getKapasitet(){
    return kapasitet;
  }

  public int getPris(){
    return pris;
  }

  public abstract int finnAntallSolgteBilletter();

  public double finnInntekt(){
    return (double)(finnAntallSolgteBilletter()*pris);
  }

  public abstract Billett[] kjopBilletter(int onskesKjopt);

  public abstract Billett[] kjopBilletter(String[] kunder);

  public abstract String toString();
}

class Staa extends Tribune{
  public Staa(String tribunenavn, int kapasitet, int pris){
    super(tribunenavn, kapasitet, pris);
  }
  private int antSolgteBilletter;

  @Override
  public int finnAntallSolgteBilletter(){
    return antSolgteBilletter;
  }

  @Override
  public Billett[] kjopBilletter(int onskesKjopt){
    if(onskesKjopt > super.getKapasitet()){
      return null;
    }
    Billett[] billetter = new Billett[onskesKjopt];
    for(int i = 0; i<onskesKjopt; i++){
      Billett nyBillett = new StaaplassBillett(super.getNavn(), super.getPris());
      billetter[i] = nyBillett;
      antSolgteBilletter++;
    }
    return billetter;
  }
  @Override
  public Billett[] kjopBilletter(String[] kunder){
    if(kunder.length > super.getKapasitet()){
      return null;
    }

    Billett[] billetter = new Billett[kunder.length];
    for(int i = 0; i<kunder.length; i++){
      Billett nyBillett = new StaaplassBillett(super.getNavn(), super.getPris());
      billetter[i] = nyBillett;
      antSolgteBilletter++;
    }
    return billetter;
  }
  @Override
  public String toString(){
    try{
        String returString = getNavn();
        returString += "\n" + "Antall solgte billetter: " + finnAntallSolgteBilletter() + "/" + getKapasitet();
        returString += "\n" + "intekter: " + finnAntallSolgteBilletter()*getPris();

        return returString;
      }
      catch(Exception e){
          e.printStackTrace();
          return "noe gikk galt";
      }
  }
}

class Sitte extends Tribune{
  private int[] antOpptatt;  // tabellstørrelse: antall rader
  public Sitte(String tribunenavn, int kapasitet, int pris, int rader){
    super(tribunenavn, kapasitet, pris);
    antOpptatt = new int[rader];
  }


  @Override
  public int finnAntallSolgteBilletter(){
    int sum = 0;
    for(int i = 0; i<antOpptatt.length; i++){
      sum += antOpptatt[i];
    }
    return sum;
  }

  @Override
  public Billett[] kjopBilletter(int onskesKjopt){
    int ledige = 0;
    int seterPrRad = (super.getKapasitet()/antOpptatt.length);
    if(onskesKjopt > super.getKapasitet()){
      return null;
    }
    if(onskesKjopt > seterPrRad){
      return null;
    }

    for(int k = 0; k<antOpptatt.length; k++){
      ledige = seterPrRad - antOpptatt[k];
      if(ledige >= onskesKjopt){
        Billett[] billetter = new Billett[onskesKjopt];
        for(int i = 0; i<onskesKjopt; i++){
          Billett nyBillett = new SitteplassBillett(super.getNavn(), super.getPris(), k, antOpptatt[k]);
          billetter[i] = nyBillett;
          antOpptatt[k]++;
        }
        return billetter;
      }
    }
    return null;
  }

  @Override
  public Billett[] kjopBilletter(String[] kunder){
    int ledige = 0;
    int seterPrRad = (super.getKapasitet()/antOpptatt.length);
    int onskesKjopt = kunder.length;
    if(onskesKjopt > super.getKapasitet()){
      return null;
    }
    if(onskesKjopt > seterPrRad){
      return null;
    }

    for(int k = 0; k<antOpptatt.length; k++){
      ledige = seterPrRad - antOpptatt[k];
      if(ledige >= onskesKjopt){
        Billett[] billetter = new Billett[kunder.length];
        for(int i = 0; i<onskesKjopt; i++){
          Billett nyBillett = new SitteplassBillett(super.getNavn(), super.getPris(), k, antOpptatt[k]);
          billetter[i] = nyBillett;
          antOpptatt[k]++;
        }
        return billetter;
      }
    }
    return null;
  }

    public String toString(){
      int seterPrRad = (super.getKapasitet()/antOpptatt.length);
      try{
          String returString = getNavn();
          returString += "\n" + "Antall solgte billetter: " + finnAntallSolgteBilletter() + "/" + getKapasitet();
          returString += "\n" + "intekter: " + finnAntallSolgteBilletter()*getPris();

          return returString;
        }
        catch(Exception e){
            e.printStackTrace();
            return "noe gikk galt";
        }
    }
}

class VIP extends Sitte{
  private String[][] tilskuer; // tabellstørrelse: antall rader * antall plasser pr rad
  public VIP(String tribunenavn, int kapasitet, int pris, int rad){
    super(tribunenavn, kapasitet, pris, rad);
    tilskuer = new String[rad][getKapasitet()/rad];
  }

  @Override
  public int finnAntallSolgteBilletter(){
    int teller = 0;
    for(int i = 0; i<tilskuer.length; i++){
      for(int k = 0; k<tilskuer[i].length; k++){
        if(tilskuer[i][k] != null){
          teller++;
        }
      }
    }
    return teller;
  }

  @Override
  public Billett[] kjopBilletter(int onskesKjopt){
    return null;
  }

  public boolean sjekkLedigRad(int rad, int antBilletter){
    int ledige = 0;
    for(int i = 0; i<rad; i++){
      if(tilskuer[rad][i] == null){
        ledige++;
      }
    }
    if(ledige < antBilletter){
      return true;
    }
    return false;
  }

  @Override
  public Billett[] kjopBilletter(String[] kunder){
    boolean ledige = false;
    int seterPrRad = (super.getKapasitet()/tilskuer.length);
    int onskesKjopt = kunder.length;
    int[] antallOpptatte = new int[tilskuer.length];

    if(onskesKjopt > super.getKapasitet()){
      return null;
    }
    if(onskesKjopt > seterPrRad){
      return null;
    }

    for(int k = 0; k<tilskuer.length; k++){
      ledige = sjekkLedigRad(k,kunder.length);
      if(ledige){
        Billett[] billetter = new Billett[kunder.length];
        for(int i = 0; i<onskesKjopt; i++){
          Billett nyBillett = new SitteplassBillett(super.getNavn(), super.getPris(), k, i + antallOpptatte[k] + 1);
          billetter[i] = nyBillett;
          tilskuer[k][antallOpptatte[k]] = kunder[i];
          antallOpptatte[k]++;
        }
        return billetter;
      }
    }
    return null;
  }

  public String toString(){
    int seterPrRad = (super.getKapasitet()/tilskuer.length);
    try{
        String returString = getNavn();
        returString += "\n" + "Antall solgte billetter: " + finnAntallSolgteBilletter() + "/" + getKapasitet();
        returString += "\n" + "intekter: " + finnAntallSolgteBilletter()*getPris();
        for(int i = 0; i < tilskuer.length; i++){
            for(int j = 0; j < seterPrRad; j++){
                if(tilskuer[i][j] != null){
                    returString += "\n" + tilskuer[i][j] + "; rad: " + (i+1) + ", sete: " + (j+1);
                }
            }
        }
        return returString;
      }
      catch(Exception e){
          e.printStackTrace();
          return "noe gikk galt";
      }
  }
}
