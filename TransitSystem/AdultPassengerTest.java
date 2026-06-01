package proj4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AdultPassengerTest {

    @Test
    public void testInheritance() {
        AdultPassenger a = new AdultPassenger("Amy", 5, 20.0);
        assertTrue(a instanceof Passenger);
        assertTrue(a instanceof Person);
    }

    @Test
    public void testNotDiscountable() {
        AdultPassenger a = new AdultPassenger("Amy", 5, 20.0);
        assertFalse(a instanceof Discountable);
    }

    @Test
    public void testUsesRegularFareBehavior() throws Exception {
        AdultPassenger a = new AdultPassenger("Amy", 5, 20.0);
        assertTrue(a.payFare(8.0, false, false));
        assertEquals(12.0, a.getBalance(), 0.0001);
    }

    @Test
    public void testCopy() {
        AdultPassenger a1 = new AdultPassenger("Amy", 5, 20.0);
        AdultPassenger a2 = (AdultPassenger) a1.copy();

        assertNotSame(a1, a2);
        assertEquals(a1, a2);
        assertEquals(a1.getBalance(), a2.getBalance(), 0.0001);
    }

    @Test
    public void testPolymorphicPassengerReference() {
        Passenger p = new AdultPassenger("Amy", 5, 20.0);
        assertTrue(p instanceof AdultPassenger);
    }
}