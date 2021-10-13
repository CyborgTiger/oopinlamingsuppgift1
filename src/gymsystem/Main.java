package gymsystem;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*För att bli Godkänd (G) krävs att du hjälper både receptionisten och den personlige tränaren och
    uppfyller deras önskemål. Din lösning ska kunna:
            • Läsa personposter från fil.
            • Skriva till fil.
• Läsa in och parsa datum (tips: LocalDate är en bra klass för hantering av datum)
• Ha bra felhantering (relevanta felmeddelanden, exceptionhantering och try-with-resources)
• Koden ska vara enkelt läsbar och prydligt skriven.
            • Minst ett enhetstest måste finnas, som är:
    o Någorlunda relevant för programmets funktionalitet
    o Som går grönt oberoende av datum
    o Som alltid går att köra automatiskt (alltså inte väntar på input från användare).
    För att bli Väl Godkänd (VG) måste lösningen uppfylla följande:
            • Alla krav för att få G vara uppfyllda.
            • Jobba helt testdrivet när du löser uppgiften.
• Det ska finnas enhetstester som minst täcker följande delar av koden:
    o Att inläsning av korrekt data görs, på korrekt sätt
    o Att datat kontrolleras och behandlas på rätt sätt
    o Att korrekta utskrifter görs till fil
• Testerna ska uppfylla följande krav:
    o Dessa tester ska alltid kunna köras med samma resultat. (De får alltså inte vara
    beroende av att man t.ex. kör koden ett visst datum för att de ska bli gröna)
    o Testerna ska vara relevanta för programmets funktionalitet och inte vara extremt
simplistiska. (Ni får alltså INTE VG om ni testar t.ex. 1==1 eller liknande, och inte
    heller om ni testar simpla getters och setters)
    o De ska alltid gå att köra testerna automatiskt (det är alltså inte ok att testerna väntar
            på input från användaren)
    o Alla testfallen ska gå gröna när de körs.*/
    public static void main(String[] args) {


    }
    public static Customer readCustomer(int i){
        String personnummer = "";
        String namn = "";
        String personnumerAndNamn = "";
        String dateOfStart = "";

        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("src/gymsystem/customers.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        if (fileReader != null) {
            for (int j = 0; j < i; j++) {
                fileReader.nextLine();
            }
            personnumerAndNamn = fileReader.nextLine();
            dateOfStart = fileReader.nextLine();
        }

        for (int j = 0; j < personnumerAndNamn.length(); j++) {
            if (personnumerAndNamn.charAt(j) == ','){
                personnummer = personnumerAndNamn.substring(0,j);
                namn = personnumerAndNamn.substring(j+2);
            }
        }

        return new Customer(personnummer, namn, dateOfStart);
    }

    public static ArrayList<Customer> createCustomerList(){
        ArrayList<Customer> customers = new ArrayList<>();
        //while()



        return customers;
    }

    public static boolean findCurrentCustomer(String inputString){
        if (Character.isDigit(inputString.charAt(0))){

        } else{

        }
        return false;
    }
}
