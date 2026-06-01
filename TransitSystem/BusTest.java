package proj4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BusTest {

    @Test
    public void testConstructorAndGetters() {
        Driver d = new Driver("Ali", 10, "XYZ123");
        Bus b = new Bus(15200, "minibus", 12, d);

        assertEquals(15200, b.getVehicleId());
        assertEquals("minibus", b.getModel());
        assertEquals(12, b.getCapacity());
        assertEquals(d, b.getDriver());
    }

    @Test
    public void testSetDriver() {
        Driver d1 = new Driver("Ali", 10, "XYZ123");
        Driver d2 = new Driver("Mona", 11, "ABC555");
        Bus b = new Bus(15200, "minibus", 12, d1);

        b.setDriver(d2);
        assertEquals(d2, b.getDriver());
    }

    @Test
    public void testToString() {
        Bus b = new Bus(15200, "minibus", 12, null);
        assertEquals("Bus:15200, model: minibus, capacity: 12", b.toString());
    }

    @Test
    public void testEquals() {
        Bus b1 = new Bus(15200, "minibus", 12, new Driver("Ali", 1, "A1"));
        Bus b2 = new Bus(15200, "minibus", 12, new Driver("Mona", 2, "B2"));

        assertTrue(b1.equals(b2));
    }

    @Test
    public void testCopy() {
        Driver d = new Driver("Ali", 10, "XYZ123");
        Bus b1 = new Bus(15200, "minibus", 12, d);
        Bus b2 = (Bus) b1.copy();

        assertNotSame(b1, b2);
        assertEquals(b1, b2);

        if (b1.getDriver() != null && b2.getDriver() != null) {
            assertNotSame(b1.getDriver(), b2.getDriver());
            assertEquals(b1.getDriver(), b2.getDriver());
        }
    }

    @Test
    public void testInheritance() {
        Bus b = new Bus(1, "Mini", 20, null);
        assertTrue(b instanceof Vehicle);
    }

    @Test
    public void testPolymorphicReference() {
        Vehicle v = new Bus(1, "Mini", 20, null);
        assertTrue(v instanceof Bus);
    }
}