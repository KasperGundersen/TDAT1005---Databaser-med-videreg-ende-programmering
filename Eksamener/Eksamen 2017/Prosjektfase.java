class Prosjektfase {
 private java.util.ArrayList<Aktivitet> aktiviteter = new java.util.ArrayList<Aktivitet>();
 public double finnRestBudsjett() {
   double sum = 0;
  for(Aktivitet a: aktiviteter){
    sum += (a.finnTotBudsjett - a.finnTotForbruk)
  }
  return sum;
 }
}
