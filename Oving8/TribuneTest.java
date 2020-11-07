/**
 * Øving 8 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly2.php
 */
import static java.lang.System.out;
import java.util.Arrays;
import java.io.*;

class TribuneTest{
    public static void main(String[] args){
        Tribune[] tribuner = new Tribune[4];
        tribuner[0] = new Sitte("VGsvingen", 20, 300, 4);
        tribuner[1] = new Staa("GamleMenn", 15, 200);
        tribuner[2] = new Staa("StandUp", 30, 300);
        tribuner[3] = new VIP("BigBois", 20, 1200, 2);

        String[] navn = {"Emir", "Steve"};

        tribuner[0].kjopBilletter(navn);
        tribuner[0].kjopBilletter(20);

        tribuner[1].kjopBilletter(navn);
        tribuner[1].kjopBilletter(20);

        tribuner[2].kjopBilletter(navn);
        tribuner[2].kjopBilletter(20);

        tribuner[3].kjopBilletter(navn);
        tribuner[3].kjopBilletter(10);


        out.println(tribuner[0].toString() + "\n");
        out.println(tribuner[1].toString()+ "\n");
        out.println(tribuner[2].toString()+ "\n");
        out.println(tribuner[3].toString()+ "\n");
    }


public static Tribune lesFraFil(String filnavn){
    try{
      FileInputStream fis = new FileInputStream(filnavn);
      ObjectInputStream ois = new ObjectInputStream(fis);
      Tribune t = (Tribune) ois.readObject();
      ois.close();
      return t;
    }
    catch(IOException e){
      e.printStackTrace();
    }
    catch(NullPointerException e){
      e.printStackTrace();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }

  public static boolean skrivTilFil(String filnavn, Tribune t){
    try{
      FileOutputStream fos = new FileOutputStream(filnavn);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(t);
      oos.close();
      return true;
    }
    catch(IOException e){
      e.printStackTrace();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return false;
  }
}
