/**
 * Øving 4 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_aggregeringer.php
 */

/**
 * Kunde.java
 * Inneholder kundedata.
 */
class Kunde {
  private final String navn;
  private final String tlf;

/**
 * Konstruktør:
 * Både navn og telefon må oppgis, de kan ikke være verken null eller tomme strenger.
 */
  public Kunde(String navn, String tlf) {
    if (navn == null || navn.trim().equals("")) {
      throw new IllegalArgumentException("Navn må oppgis.");
    }
    if (tlf == null || tlf.trim().equals("")) {
      throw new IllegalArgumentException("Tlf må oppgis.");
    }
    this.navn = navn.trim();
    this.tlf = tlf.trim();
  }

  public String getNavn() {
    return navn;
  }

  public String getTlf() {
    return tlf;
  }

  public String toString() {
    return navn + ", tlf " + tlf;
  }
}
