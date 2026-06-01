package proj4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ChildPassengerTest {

    @Test
    public void testInheritanceAndInterface() {
        ChildPassenger c = new ChildPassenger("Kid", 1, 10.0);
        assertTrue(c instanceof Passenger);
        assertTrue(c instanceof Person);
        assertTrue(c instanceof Discountable);
    }

    @Test
    public void testDiscountRate() {
        ChildPassenger c = new ChildPassenger("Kid", 1, 10.0);
        assertEquals(0.5, c.getDiscountRate(), 0.0001);
    }

    @Test
    public void testPayFareDiscounted() throws Exception {
        ChildPassenger c = new ChildPassenger("Kid", 1, 10.0);
        assertTrue(c.payFare(6.0, false, false)); // should pay 3.0
        assertEquals(7.0, c.getBalance(), 0.0001);
    }

    @Test
    public void testPayFareFailAfterDiscount() throws Exception {
        ChildPassenger c = new ChildPassenger("Kid", 1, 2.0);
        assertFalse(c.payFare(6.0, false ,false)); // discounted fare is 3.0
        assertEquals(2.0, c.getBalance(), 0.0001);
    }

    @Test
    public void testCopy() {
        ChildPassenger c1 = new ChildPassenger("Kid", 1, 10.0);
        ChildPassenger c2 = (ChildPassenger) c1.copy();

        assertNotSame(c1, c2);
        assertEquals(c1, c2);
        assertEquals(c1.getBalance(), c2.getBalance(), 0.0001);
    }

    @Test
    public void testPolymorphicReferences() {
        Passenger p = new ChildPassenger("Kid", 1, 10.0);
        Discountable d = new ChildPassenger("Kid", 1, 10.0);

        assertTrue(p instanceof ChildPassenger);
        assertEquals(0.5, d.getDiscountRate(), 0.0001);
    }
}