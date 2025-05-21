public class TVspel extends Skivor{
    private String plattform;
    private int åldersgräns;

    public TVspel(String titel, String författare, boolean ärTillänglig, String plattform, int åldersgräns){
        super(titel, författare, ärTillänglig, "Tv-spel");
        this.plattform = plattform;
        this.åldersgräns = åldersgräns;
    }

    public String hämtaInformation(){
        return  "Tv-spel titel: " + titel + ", Skapare: " + författare + ", Plattform(PS/Xbox/Nintendo): " + plattform + ", Åldersgräns: " + åldersgräns + ", Tillänglig: " + (ärTillänglig? "Ja" : "Nej");
    }
}
