package gymsystem;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UI();
    }

    /**
     * Creates a ArrayList with all the customers
     * @return a ArrayList that contains all customers in the customer file
     */
    public static ArrayList<Customer> createCustomerList(){
        String personnummer = "";
        String namn = "";
        String personnumerAndNamn;
        String dateOfStart;
        ArrayList<Customer> customers = new ArrayList<>();
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("src/gymsystem/customers.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        if (fileReader != null) {
            while(fileReader.hasNext()){
                personnumerAndNamn = fileReader.nextLine();
                dateOfStart = fileReader.nextLine();


            for (int j = 0; j < personnumerAndNamn.length(); j++) {
                if (personnumerAndNamn.charAt(j) == ','){
                    personnummer = personnumerAndNamn.substring(0,j);
                    namn = personnumerAndNamn.substring(j+2);
                }
            }
            customers.add(new Customer(personnummer, namn, LocalDate.parse(dateOfStart)));
            }}
        return customers;
    }

    /**
     * Checks if the customer input has a valid membership
     * @param inputString what is being searched with
     * @param customers the arrayList being searched
     * @return boolean if a customer was found and with valid membership
     */
    public static boolean findCurrentCustomer(String inputString, ArrayList<Customer> customers){
        inputString = inputString.trim();
        LocalDate today = LocalDate.now();
        boolean found = false;
        boolean displayError = true;
        try (FileWriter logOfVisitors = new FileWriter("visitorLog.txt", true)) {
            if (Character.isDigit(inputString.charAt(0))) {
                //personnummer based search
                for (Customer customer : customers) {
                    if (customer.getPersonnummer().equals(inputString)) {
                        LocalDate expiryDate = customer.getDateOfStart().plusYears(1);
                        if (expiryDate.isAfter(today)) {
                            logOfVisitors.write(customer.getNamn() + " " + customer.getPersonnummer() + " Date: " + today + "\n");
                            found = true;
                            displayError = false;
                            logOfVisitors.close();
                            System.out.println("Customer found and logged through personnummer");
                            break;
                        }
                        System.out.println("Customer expired");
                        displayError = false;
                        break;
                    }
                }
                if (displayError) {
                    System.out.println("Customer not found. Check if inputted correctly.");
                }
            } else {
                //name based search
                for (Customer customer : customers) {
                    if (customer.getNamn().equals(inputString)) {
                        LocalDate expiryDate = customer.getDateOfStart().plusYears(1);
                        if (expiryDate.isAfter(today)) {
                            logOfVisitors.write(customer.getNamn() + " " + customer.getPersonnummer() + " Date: " + today + "\n");
                            found = true;
                            displayError = false;
                            logOfVisitors.close();
                            System.out.println("Customer found and logged through name");
                            break;
                        }
                        System.out.println("Customer expired");
                        displayError = false;
                        break;
                    }
                }
                if (displayError) {
                    System.out.println("Customer not found. Check if inputted correctly.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return found;
    }

    public static void UI(){
        ArrayList<Customer> customers = createCustomerList();
        Scanner input = new Scanner(System.in);
        boolean foundCustomer = false;
        while (!foundCustomer){
            System.out.println("Input customer info (Full name or 10 digit personnummmer)");
            foundCustomer = findCurrentCustomer(input.nextLine(), customers);
        }
    }
}
