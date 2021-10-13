package gymsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest extends Main{

    /*@Test
    void readFileTest(){
        assertEquals(readCustomer(0).toString(),
                new Customer("7603021234", "Alhambra Aromes", "2020-07-01").toString());
    }*/

    @Test
    void findCustomerTest(){
        assertFalse(findCurrentCustomer("7603021234"));
        assertFalse(findCurrentCustomer("Alhambra Aromes"));
    }

    @Test
    void createCustomersTest(){
        assertEquals(createCustomerList().get(0).toString(),
                new Customer("7603021234", "Alhambra Aromes", "2020-07-01").toString() );
    }

    @Test
    void addCustomerTest(){

    }
}