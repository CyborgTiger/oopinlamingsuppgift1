package gymsystem;

public class Customer {
    private String personnummer;
    private String namn;
    private String dateOfStart;

    public Customer(String personnummer, String namn, String dateOfStart){
        this.personnummer = personnummer;
        this.namn = namn;
        this.dateOfStart = dateOfStart;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public String getNamn() {
        return namn;
    }

    public String getDateOfStart() {
        return dateOfStart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "personnummer='" + personnummer + '\'' +
                ", namn='" + namn + '\'' +
                ", dateOfStart='" + dateOfStart + '\'' +
                '}';
    }
}
