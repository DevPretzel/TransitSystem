package proj4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SeniorPassengerTest {

    @Test
    public void testInheritanceAndInterface() {
        SeniorPassenger s = new SeniorPassenger("Sam", 2, 10.0);
        assertTrue(s instanceof Passenger);
        assertTrue(s instanceof Person);
        assertTrue(s instanceof Discountable);
    }

    @Test
    public void testDiscountRate() {
        SeniorPassenger s = new SeniorPassenger("Sam", 2, 10.0);
        assertEquals(0.3, s.getDiscountRate(), 0.0001);
    }

    @Test
    public void testPayFareDiscounted() throws Exception {
        SeniorPassenger s = new SeniorPassenger("Sam", 2, 10.0);
        assertTrue(s.payFare(10.0, false, false)); // should pay 7.0
        assertEquals(3.0, s.getBalance(), 0.0001);
    }

    @Test
    public void testPayFareFailAfterDiscount() throws Exception {
        SeniorPassenger s = new SeniorPassenger("Sam", 2, 6.0);
        assertFalse(s.payFare(10.0, false, false)); // discounted fare is 7.0
        assertEquals(6.0, s.getBalance(), 0.0001);
    }

    @Test
    public void testCopy() {
        SeniorPassenger s1 = new SeniorPassenger("Sam", 2, 10.0);
        SeniorPassenger s2 = (SeniorPassenger) s1.copy();

        assertNotSame(s1, s2);
        assertEquals(s1, s2);
        assertEquals(s1.getBalance(), s2.getBalance(), 0.0001);
    }

    @Test
    public void testPolymorphicReferences() {
        Passenger p = new SeniorPassenger("Sam", 2, 10.0);
        Discountable d = new SeniorPassenger("Sam", 2, 10.0);

        assertTrue(p instanceof SeniorPassenger);
        assertEquals(0.3, d.getDiscountRate(), 0.0001);
    }
}