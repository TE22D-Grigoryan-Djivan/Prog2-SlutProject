public class Skivor extends Låneobjekt{
    private String format;

    public Skivor(String titel, String författare, boolean ärTillänglig, String format){ //Konstruktör
        super(titel, författare, ärTillänglig); // anropar konstruktorn i superklassen
        this.format = format;
    }

    public String hämtaInformation(){ //inkluderar skiv specifik info
        return "Skivans titel: " + titel + ", Skapare: " + författare + ", Format(ex cd/blueray): " + format + ", Tillänglig: " + (ärTillänglig? "Ja" : "Nej");
    }
}
