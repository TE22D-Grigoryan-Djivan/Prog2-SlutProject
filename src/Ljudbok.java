public class Ljudbok extends Låneobjekt{
    private int längd;
    private String uppläsare;

    public Ljudbok(String titel, String författare, boolean ärTillänglig, int längd, String uppläsare){
        super(titel, författare, ärTillänglig);
        this.längd = längd;
        this.uppläsare = uppläsare;
    }

    public String hämtaInformation(){

        return null;
    }
}
