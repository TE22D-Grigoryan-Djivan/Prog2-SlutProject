public class Bok extends Låneobjekt{
    private int sidor;
    private String genre;

    public Bok(String titel, String författare, boolean ärTillänglig, int sidor, String genre){ //Konstruktör
        super(titel, författare, ärTillänglig); // anropar konstruktorn i superklassen
        this.sidor = sidor;
        this.genre = genre;

    }

    public String hämtaInformation(){ //inkluderar bok specifik info
        return "Bok titel: " + titel + ", Författare: " + författare + ", Sidor: " + sidor + ", Genre: " + genre + ", Tillänglig: " + (ärTillänglig? "Ja" : "Nej");
    }
}
