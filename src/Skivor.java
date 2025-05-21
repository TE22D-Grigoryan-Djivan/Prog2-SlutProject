public class Skivor extends Låneobjekt{
    private String format;

    public Skivor(String titel, String författare, boolean ärTillänglig, String format){
        super(titel, författare, ärTillänglig);
        this.format = format;
    }

    public String hämtaInformation(){
        return "Skivans titel: " + titel + ", Skapare: " + författare + ", Format(ex cd/blueray): " + format + ", Tillänglig: " + (ärTillänglig? "Ja" : "Nej");
    }
}
