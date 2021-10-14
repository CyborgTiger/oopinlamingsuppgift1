package gymsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

class MainTest extends Main{

    @Test
    void findCustomerTest(){
        ArrayList<Customer> customers = createCustomerList();
        assertFalse(findCurrentCustomer("7603021234", customers));
        assertFalse(findCurrentCustomer("Alhambra Aromes", customers));
        assertTrue(findCurrentCustomer("7608021234", customers));
    }

    @Test
    void createCustomersTest(){
        assertEquals(createCustomerList().get(0).toString(),
                new Customer("7603021234", "Alhambra Aromes", LocalDate.parse("2020-07-01")).toString() );
    }

}