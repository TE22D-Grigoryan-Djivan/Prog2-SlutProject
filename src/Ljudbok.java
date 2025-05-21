public class Ljudbok extends Låneobjekt{
    private int längd;
    private String uppläsare;

    public Ljudbok(String titel, String författare, boolean ärTillänglig, int längd, String uppläsare){ //Konstruktör
        super(titel, författare, ärTillänglig); // anropar konstruktorn i superklassen
        this.längd = längd;
        this.uppläsare = uppläsare;
    }

    public String hämtaInformation(){ //inkluderar ljudbok specifik info
        return  "Ljudbok titel: " + titel + ", Författare: " + författare + ", Längd(min): " + längd + ", Uppläsare: " + uppläsare + ", Tillänglig: " + (ärTillänglig? "Ja" : "Nej");
    }
}
