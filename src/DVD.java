public class DVD extends Skivor{
    private int spelTid;
    private String filmGenre;

    public DVD(String titel, String författare, boolean ärTillänglig, int spelTid, String filmGenre){
        super(titel, författare, ärTillänglig, "DVD");
        this.spelTid = spelTid;
        this.filmGenre = filmGenre;
    }

    public String hämtaInformation(){
        return  "DVD titel: " + titel + ", Skapare: " + författare + ", Speltid(min): " + spelTid + ", Film genre: " + filmGenre + ", Tillänglig: " + (ärTillänglig? "Ja" : "Nej");
    }
}
