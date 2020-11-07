/**
 * Øving 12 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly3.php
 */

import java.time.LocalDate;

public abstract class Dyr{
  private final String norskNavn; // "vanlig" navn på dyret
  private final String latNavn;  // latinsk artsnavn
  private final String latFamilie;  // artsfamilie
  private final LocalDate ankommetDato;  // dato ankommet dyrehagen
  private String adresse; // innhegning, bur, akvarium el.l. (unikt innad i dyrehagen)

  /* Enkel konstruktør, ingen datakontroll */
  public Dyr(String norskNavn, String latNavn, String latFamilie,
             LocalDate ankommetDato, String adresse) {
	this.norskNavn = norskNavn;
	this.latNavn = latNavn;
	this.latFamilie = latFamilie;
	this.ankommetDato = ankommetDato;
	this.adresse = adresse;
  }

  public String getNorskNavn(){
    return norskNavn;
  }

  public String getLatNavn() {
    return latNavn;
  }

  public String getLatFamilie() {
    return latFamilie;
  }

  public LocalDate getAnkommetDato() {
    return ankommetDato;
  }

  public String getAdresse(){
    return adresse;
  }

  public void setAdresse(String nyAdresse){
    adresse = nyAdresse;
  }

  public String toString() {
    return "Norsk navn: " + norskNavn + "\nLatinsk navn og familie: " + latNavn
	+ ", " + latFamilie + "\nAdresse: "+adresse;
  }
}
