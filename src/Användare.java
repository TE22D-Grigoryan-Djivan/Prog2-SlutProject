import java.util.ArrayList;

public class Användare {
    public String användarnamn;
    public int lånekortnummer;
    private ArrayList<Låneobjekt> låneLista = new ArrayList<>();

    public Användare(String användarnamn, int lånekortnummer){
        this.användarnamn = användarnamn;
        this.lånekortnummer = lånekortnummer;
    }

    public boolean lånaobjekt(Låneobjekt objekt){
        if (objekt.ärTillänglig()){
            låneLista.add(objekt);
            objekt.markeraSomLånad();
            System.out.println(användarnamn + " har lånat " + objekt.getTitel());
            return true;
        }
        else {
            System.out.println("");
            return false;
        }
    }

    public void lämnaTillbaka(Låneobjekt objekt){

    }

    public void visaLånadeObjekt(){

    }
}
