public class Låneobjekt {
    protected String titel;
    protected String författare;
    protected boolean ärTillänglig;

    public Låneobjekt(String titel, String författare, boolean ärTillänglig){
        this.titel = titel;
        this.författare = författare;
        this.ärTillänglig = ärTillänglig;
    }

    public String hämtaInformation(){
        return "Låneobjektets titel: " + titel + ", Skapare: " + författare + ", Tillänglig: " + (ärTillänglig? "Ja" : "Nej");
    }

    public void markeraSomLånad(){
        this.ärTillänglig = false;
        System.out.println(titel + " har markerats som lånad.");
    }

    public void markeraSomTillänglig() {
        this.ärTillänglig = true;
        System.out.println(titel + " har markerats som tillänglig.");
    }

    public String getTitel() {
        return titel;
    }

    public String getFörfattare() {
        return författare;
    }

    public boolean ärTillänglig(){
        return ärTillänglig;
    }
}
