import java.util.ArrayList;

public class Användare {
    public String användarnamn; // Användarens namn
    public int lånekortnummer; // Detta används inte i koden på grund av saknad tid att implementera
    private ArrayList<Låneobjekt> låneLista = new ArrayList<>();

    public Användare(String användarnamn, int lånekortnummer){ //Konstruktör
        this.användarnamn = användarnamn;
        this.lånekortnummer = lånekortnummer;
    }

    public boolean lånaobjekt(Låneobjekt objekt){ //Kontrollerar om objektet är tillängligt, markerar det som lånat lägger till det i användarlistan
        if (objekt.ärTillänglig()){
            låneLista.add(objekt);
            objekt.markeraSomLånad();
            System.out.println(användarnamn + " har lånat " + objekt.getTitel());
            return true;
        }
        else {
            System.out.println(objekt.getTitel() + " är inte tillänglig för utlåning just nu.");
            return false;
        }
    }

    public void lämnaTillbaka(Låneobjekt objekt){ //Tar bort objektet från användarens lista och markerar det som tillängligt
        if (låneLista.remove(objekt)){
            objekt.markeraSomTillänglig();
            System.out.println(användarnamn + " har lämnat tillbaka " + objekt.getTitel());
        }
        else {
            System.out.println(användarnamn + " har inte lånat " + objekt.getTitel());
        }

    }

    public void visaLånadeObjekt(){ //Loopar genom listan för att skriva ut relevant info
        if (låneLista.isEmpty()) {
            System.out.println(användarnamn + " har inga lånade objekt för tillfället. ");
        }
        else {
            System.out.println(användarnamn + "s lånade objekt:");
            for (Låneobjekt obj : låneLista){
                System.out.println(obj.hämtaInformation());
            }
        }

    }
}
