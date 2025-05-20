import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotekssystem {
    private String namn = "Blåsin Bibliotek";
    ArrayList<Låneobjekt> låneLista = new ArrayList<>();
    ArrayList<Bokning> bokningslista = new ArrayList<>();

    public Bibliotekssystem(){
        this.namn = namn;
    }

    public void meny(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Välkommen till Bibliotekssytemet!");
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Lägg till låneobjekt\n2. Sök bok\n3. Avsluta");
            switch (sc.nextLine()) {
                case "1":
                    String val = "";
                    System.out.println("Vilket låneobjekt vill du lägga till? (Bok, Ljudbok, Tvspel eller DVD)");
                    while(true){
                        val = sc.nextLine();
                        if(val.trim().equalsIgnoreCase("ljudbok") || val.trim().equalsIgnoreCase("bok") || val.trim().equalsIgnoreCase("DVD") || val.trim().equalsIgnoreCase("TVspel")){
                            break;
                        }
                        System.out.println("Ange gilltigt svar (Antingen Bok, Ljudbok, Tvspel eller DVD)");
                    }
                    läggTillLåneObjekt(val);
                    break;
                case "2":

                    break;
                case "3":
                    System.out.println("Avslutar programmet...");
                    return;
                default:
                    System.out.println("Något gick snett, skriv in siffrorna 1-3");
                    break;
            }
        }
    }

    public void läggTillLåneObjekt(String objekt){

        Låneobjekt låneobjekt = skapaLåneObjekt(objekt);
        låneLista.add(låneobjekt);
        Bokning bokning = new bokning(användare, låneobjekt);
        bokningslista.add(bokning);

    }

    public Låneobjekt skapaLåneObjekt(String objekt){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Låneobjekt nyttLåneObjekt = null;
        Bokning nybokning = null;
        if (objekt.equalsIgnoreCase("bok")){
            System.out.println("Hur många sidor har den?");
            int sidor = sc.nextInt();
            System.out.println("Vilken genre tillhör den?");
            String genre = sc2.nextLine();
            nyttLåneObjekt = new Bok(sidor, genre);
        }
        else if(objekt.equalsIgnoreCase("ljudbok")){
            System.out.println("Hur många minuter är den?");
            int längd = sc.nextInt();
            System.out.println("Vem är uppläsaren?");
            String uppläsare = sc2.nextLine();
            nyttLåneObjekt = new Ljudbok(längd, uppläsare);
        }
        else if(objekt.equalsIgnoreCase("Tvspel")){
            System.out.println("Vilken spel plattform är det?(PS,Xbox,Nintendo)");
            String plattform = sc.nextLine();
            System.out.println("Vad är åldersgränsen?");
            int åldersgräns = sc2.nextInt();
            nyttLåneObjekt = new TVspel(plattform, åldersgräns);
        }
        else if(objekt.equalsIgnoreCase("DVD")){
            System.out.println("Hur lång är den?(Min)");
            int spelTid = sc.nextInt();
            System.out.println("Vilken filmgenre är det?");
            String filmGenre = sc2.nextLine();
            nyttLåneObjekt = new DVD(spelTid, filmGenre);
        }
        else{
            System.out.println("Välj mellan: (Bok, Ljudbok, Tvspel eller DVD)");

        }

        return nyttLåneObjekt;
    }

    public void taBortLåneObjekt(Låneobjekt objekt){

    }

    public Låneobjekt sökObjekt(String titel){

        return null;
    }

    public int parseInt(String text){
        try {
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            System.out.println("Ogilitig inmatning");
            return 0;
        }
    }
}
