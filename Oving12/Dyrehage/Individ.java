/**
 * Øving 12 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * http://www.aitel.hist.no/fag/vprg/TDAT1005/ovinger/TDAT1005_arvpoly3.php
 */
import java.time.LocalDate;
import java.time.Period;

abstract class Individ extends Dyr implements SkandinaviskeRovdyr {
    private final String navn;
    private final LocalDate fdato;
    private  final boolean hanndyr;
    private final boolean farlig;

    public Individ(String navn, LocalDate fdato, boolean hanndyr, boolean farlig, String gruppenavn, int antIndivider,
                   String norskNavn, String latNavn, String latFamilie,
                   LocalDate ankommetDato, String adresse) {
        super(norskNavn, latNavn, latFamilie,
                ankommetDato, adresse);
        this.navn = navn;
        this.fdato = fdato;
        this.hanndyr = hanndyr;
        this.farlig = farlig;
    }

    public String getNavn(){
        return navn;
    }
    public LocalDate getFdato(){
        return fdato;
    }
    public boolean getHandyr(){
        return hanndyr;
    }
    public boolean getFarlig(){
        return farlig;
    }

    public int getAlder(){
        return Period.between(fdato, LocalDate.now()).getYears();
    }
    @Override
    public String getAdresse(){
        return super.getAdresse();
    }
    @Override
    public void flytt(String nyAdresse){
        super.setAdresse(nyAdresse);
    }
    @Override
    public String skrivUtInfo(){
        return  super.toString() + "\nNavn og fødselsdato: " + navn + ", " + fdato +
        "\nKjønn: " + (hanndyr ? " Hannkjønn" : "Hokjønn") + "\nFarlig: " + (farlig?" JA ":" NEI");
    }

    public abstract int getAntKull();
    public abstract void leggTilKull(int antall);
    public abstract void leggTilNyttKull();
}
