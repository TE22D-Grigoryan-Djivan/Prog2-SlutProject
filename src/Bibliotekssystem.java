import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotekssystem {
    private String namn = "Blåsin Bibliotek";
    ArrayList<Låneobjekt> låneLista = new ArrayList<>();
    ArrayList<Bokning> bokningslista = new ArrayList<>();
    ArrayList<Användare> användarlista = new ArrayList<>();

    public Bibliotekssystem(){
        this.namn = namn;
        användarlista.add(new Användare("Testanvändare", 1234));
    }

    public void meny(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Välkommen till Bibliotekssytemet " + namn + "!");
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Lägg till låneobjekt\n2. Sök bok\n3.Ta bort låneobjekt\n4. Låna låneobjekt\n5. Lämna tillbaka låneobjekt\n6. Visa lånade\n7. Avsluta");
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
                    System.out.println("Skriv titeln på låneobjektet du vill söka:");
                    String sökTitel = sc.nextLine();
                    Låneobjekt hittatObjekt = sökObjekt(sökTitel);
                    if (hittatObjekt != null){
                        System.out.println("Hittat objekt: " + hittatObjekt.hämtaInformation());
                    }
                    else {
                        System.out.println("Objektet hittades inte!");
                    }
                    break;
                case "3":
                    System.out.println("Skriv titeln på låneobjektet du vill ta bort:");
                    String titelAttTaBort = sc.nextLine();
                    Låneobjekt objektAttTaBort = sökObjekt(titelAttTaBort);
                    if (objektAttTaBort != null){
                        taBortLåneObjekt(objektAttTaBort);
                        System.out.println(titelAttTaBort + " har tagits bort från"+ namn);
                    }
                    else{
                        System.out.println("Objektet att ta bort hittades inte!");
                    }
                    break;
                case "4":
                    lånaObjektTillAnvändare();
                    break;
                case "5":
                    lämnaTillbakaObjekt();
                    break;
                case "6":
                    visaLånadeObjekt();
                    break;
                case "7":
                    System.out.println("Avslutar programmet...");
                    sc.close();
                    return;
                default:
                    System.out.println("Något gick snett, skriv in siffrorna 1-3");
                    break;
            }
        }
    }

    public void läggTillLåneObjekt(String objektTyp){
        Låneobjekt låneobjekt = skapaLåneObjekt(objektTyp);
        if (låneobjekt != null) {
            låneLista.add(låneobjekt);
            System.out.println("");
            if (!användarlista.isEmpty()) {
                Användare användare = användarlista.get(0);
                Bokning bokning = new Bokning(användare, låneobjekt);
                bokningslista.add(bokning);
                System.out.println("En bokning har skapats för " + användare.användarnamn + " för " + låneobjekt.titel);
            } else {
                System.out.println("Glöm inte att lägga till en användare!");
            }
        }
        else {
            System.out.println("Kunde inte skapa låneobjektet. Försök igen!");
        }
    }

    public Låneobjekt skapaLåneObjekt(String objektTyp){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Låneobjekt nyttLåneObjekt = null;

        System.out.println("Ange titel");
        String titel = sc.nextLine();
        System.out.println("Ange författare/skapare");
        String författare = sc.nextLine();

        if (objektTyp.equalsIgnoreCase("bok")){
            System.out.println("Hur många sidor har den?");
            int sidor = parseInt(sc.nextLine());
            System.out.println("Vilken genre tillhör den?");
            String genre = sc2.nextLine();
            nyttLåneObjekt = new Bok(titel, författare, true, sidor, genre);
        }
        else if(objektTyp.equalsIgnoreCase("ljudbok")){
            System.out.println("Hur många minuter är den?");
            int längd = parseInt(sc.nextLine());
            System.out.println("Vem är uppläsaren?");
            String uppläsare = sc2.nextLine();
            nyttLåneObjekt = new Ljudbok(titel, författare, true, längd, uppläsare);
        }
        else if(objektTyp.equalsIgnoreCase("Tvspel")){
            System.out.println("Vilken spel plattform är det?(PS,Xbox,Nintendo)");
            String plattform = sc.nextLine();
            System.out.println("Vad är åldersgränsen?");
            int åldersgräns = parseInt(sc.nextLine());
            nyttLåneObjekt = new TVspel(titel, författare, true, plattform, åldersgräns);
        }
        else if(objektTyp.equalsIgnoreCase("DVD")){
            System.out.println("Hur lång är den?(Min)");
            int spelTid = parseInt(sc.nextLine());
            System.out.println("Vilken filmgenre är det?");
            String filmGenre = sc2.nextLine();
            nyttLåneObjekt = new DVD(titel, författare, true, spelTid, filmGenre);
        }
        else{
            System.out.println("Välj mellan: (Bok, Ljudbok, Tvspel eller DVD)");

        }

        return nyttLåneObjekt;
    }

    public void taBortLåneObjekt(Låneobjekt objekt){
        låneLista.remove(objekt);
        bokningslista.removeIf(bokning -> bokning.getLåneobjekt().equals(objekt));
    }

    public Låneobjekt sökObjekt(String titel){
        for (Låneobjekt obj : låneLista){
            if (obj.titel != null && obj.titel.equalsIgnoreCase(titel)){
                return obj;
            }
        }
        return null;
    }

    private void lånaObjektTillAnvändare(){

    }

    private void lämnaTillbakaObjekt(){

    }

    private void visaLånadeObjekt(){

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
