public class Bok extends Låneobjekt{
    private int sidor;
    private String genre;

    public Bok(String titel, String författare, boolean ärTillänglig, int sidor, String genre){
        super(titel, författare, ärTillänglig);
        this.sidor = sidor;
        this.genre = genre;

    }

    public String hämtaInformation(){

        return null;
    }
}
