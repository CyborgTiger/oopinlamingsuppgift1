package gymsystem;

import java.time.LocalDate;

public class Customer {
    private String personnummer;
    private String namn;
    private LocalDate dateOfStart;

    public Customer(String personnummer, String namn, LocalDate dateOfStart){
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

    public LocalDate getDateOfStart() {
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
