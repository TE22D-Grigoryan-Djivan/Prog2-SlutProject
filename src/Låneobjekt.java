public class Låneobjekt {
    protected String titel;
    protected String författare;
    protected boolean ärTillänglig;

    public Låneobjekt(String titel, String författare, boolean ärTillänglig){ //Konstruktör
        this.titel = titel;
        this.författare = författare;
        this.ärTillänglig = ärTillänglig;
    }

    public String hämtaInformation(){ //inkluderar låneobjekt info
        return "Låneobjektets titel: " + titel + ", Skapare: " + författare + ", Tillänglig: " + (ärTillänglig? "Ja" : "Nej");
    }

    public void markeraSomLånad(){ // ändrar ärTillänglig till false för att det blir utlånat
        this.ärTillänglig = false;
        System.out.println(titel + " har markerats som lånad.");
    }

    public void markeraSomTillänglig() { // ändrar ärTillänglig till true för att det är tillängligt igen
        this.ärTillänglig = true;
        System.out.println(titel + " har markerats som tillänglig.");
    }

    public String getTitel() { // getters som hämtar titel och författare/skapare
        return titel;
    }

    public String getFörfattare() {
        return författare;
    }

    public boolean ärTillänglig(){ // kontrollerar om objektet är tillängligt
        return ärTillänglig;
    }
}
