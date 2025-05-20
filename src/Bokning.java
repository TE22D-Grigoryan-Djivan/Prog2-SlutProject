public class Bokning {
    private Användare användare;
    private Låneobjekt låneobjekt;

    public Bokning(Användare användare, Låneobjekt låneobjekt){
        this.användare = användare;
        this.låneobjekt = låneobjekt;

    }

    public Användare getAnvändare() {
        return användare;
    }

    public Låneobjekt getLåneobjekt() {
        return låneobjekt;
    }
}
