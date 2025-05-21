public class Bokning {
    private Användare användare;
    private Låneobjekt låneobjekt;

    public Bokning(Användare användare, Låneobjekt låneobjekt){ //Konstruktör
        this.användare = användare;
        this.låneobjekt = låneobjekt;

    }

    public Användare getAnvändare() { //get metoderna hämtar användaren och låneobjektet för aktuell bokning
        return användare;
    }

    public Låneobjekt getLåneobjekt() {
        return låneobjekt;
    }
}
