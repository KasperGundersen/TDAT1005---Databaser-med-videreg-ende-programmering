public class Kunde {
   private final int kundeId;
   private final String navn;
   private final String epost;

   public Kunde(int kundeId, String navn, String epost) {
     this.kundeId = kundeId;
     this.navn = navn;
     this.epost = epost;
   }
   public int getKundeId() {
     return kundeId;
   }
   public String getNavn() {
     return navn;
   }
   public String getEpost() {
     return epost;
   }

   public boolean equals(Object obj){
     if(!(obj instanceof Kunde)){
       return false;
     }
     if(obj == this){
       return true;
     }
     Kunde k = (Kunde) obj;
     return (k.kundeId == this.kundeId);
   }
}
