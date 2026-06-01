package proj4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PassengerTest {

    @Test
    public void testDefaultConstructor() {
        Passenger p = new Passenger();
        assertEquals("", p.getName());
        assertEquals(0, p.getId());
        assertEquals(0.0, p.getBalance(), 0.0001);
    }

    @Test
    public void testParameterizedConstructorAndGetters() {
        Passenger p = new Passenger("Sarah Nash", 10001, 5.0);
        assertEquals("Sarah Nash", p.getName());
        assertEquals(10001, p.getId());
        assertEquals(5.0, p.getBalance(), 0.0001);
    }

    @Test
    public void testAddBalance() {
        Passenger p = new Passenger("Sarah Nash", 10001, 5.0);
        p.addBalance(3.5);
        assertEquals(8.5, p.getBalance(), 0.0001);
    }

    @Test
    public void testPayFareSuccess() throws Exception {
        Passenger p = new Passenger("Sarah Nash", 10001, 10.0);
        assertTrue(p.payFare(3.0, false, false));
        assertEquals(7.0, p.getBalance(), 0.0001);
    }

    @Test
    public void testPayFareFailNotEnoughBalance() throws Exception {
        Passenger p = new Passenger("Sarah Nash", 10001, 2.0);
        assertFalse(p.payFare(3.0, false, false));
        assertEquals(2.0, p.getBalance(), 0.0001);
    }

    @Test
    public void testPayFareFailNegativeFare() throws Exception {
        Passenger p = new Passenger("Sarah Nash", 10001, 10.0);
        assertFalse(p.payFare(-2.0, false, false));
        assertEquals(10.0, p.getBalance(), 0.0001);
    }
    
    @Test
    public void testUseTicket() throws Exception {
    	Passenger p = new Passenger("Sarah Nash", 10001, 10.0);
    	p.payFare(3.0, false, false);
    	assertTrue(p.useTicket());
    	assertFalse(p.useTicket());
    }

    @Test
    public void testToString() {
        Passenger p = new Passenger("Sarah Nash", 10001, 5.0);
        assertEquals("Passenger Sarah Nash, ID:10001, balance: $5.00", p.toString());
    }

    @Test
    public void testEquals() {
        Passenger p1 = new Passenger("Sarah Nash", 10001, 5.0);
        Passenger p2 = new Passenger("Sarah Nash", 10001, 99.0);
        assertTrue(p1.equals(p2));
    }

    @Test
    public void testCopy() {
        Passenger p1 = new Passenger("Sarah Nash", 10001, 5.0);
        Passenger p2 = (Passenger) p1.copy();

        assertNotSame(p1, p2);
        assertEquals(p1, p2);
        assertEquals(p1.getBalance(), p2.getBalance(), 0.0001);
    }

    @Test
    public void testInheritance() {
        Passenger p = new Passenger("Sarah", 1, 10.0);
        assertTrue(p instanceof Person);
    }

    @Test
    public void testPolymorphicReference() {
        Person p = new Passenger("Sarah", 1, 10.0);
        assertTrue(p instanceof Passenger);
    }
}