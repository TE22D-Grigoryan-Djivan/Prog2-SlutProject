import java.util.ArrayList;

public class Användare {
    public String användarnamn;
    public int lånekortnummmer;
    private ArrayList<Låneobjekt> lånadeobjekt = new ArrayList<>();

    public boolean lånaobjekt(Låneobjekt objekt){
        return true;
    }

    public void lämnaTillbaka(Låneobjekt objekt){

    }

    public void visaLånadeObjekt(){

    }
}
