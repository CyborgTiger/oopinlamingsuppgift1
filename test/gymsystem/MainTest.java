package gymsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class MainTest{

    @Test
    void findCustomerTest(){
        ArrayList<Customer> customers = Main.createCustomerList();
        customers.add(new Customer("1111111111", "test", LocalDate.now().minusDays(1)));
        assertFalse(Main.findCurrentCustomer("7603021234", customers));
        assertFalse(Main.findCurrentCustomer("Alhambra Aromes", customers));
        assertFalse(Main.findCurrentCustomer("non existent", customers));
        assertTrue(Main.findCurrentCustomer("test", customers));

        String readFileTest = "";
        try {
            Scanner fileReader = new Scanner(new File("visitorLog.txt"));
            readFileTest = fileReader.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        assertEquals(readFileTest, "test 1111111111 Date: " + LocalDate.now());
    }

    @Test
    void createCustomersTest(){
        assertEquals(Main.createCustomerList().get(0).toString(),
                new Customer("7603021234", "Alhambra Aromes", LocalDate.parse("2020-07-01")).toString() );
    }


}