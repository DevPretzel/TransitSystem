package proj4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DriverTest {

    @Test
    public void testDefaultConstructor() {
        Driver d = new Driver();
        assertEquals("", d.getName());
        assertEquals(0, d.getId());
        assertEquals("AA111", d.getLicenseNumber());
    }

    @Test
    public void testParameterizedConstructorAndGetters() {
        Driver d = new Driver("John Adams", 21500, "AZ789");
        assertEquals("John Adams", d.getName());
        assertEquals(21500, d.getId());
        assertEquals("AZ789", d.getLicenseNumber());
    }

    @Test
    public void testToString() {
        Driver d = new Driver("John Adams", 21500, "AZ789");
        assertEquals("Driver John Adams, ID:21500, AZ789", d.toString());
    }

    @Test
    public void testEquals() {
        Driver d1 = new Driver("John Adams", 21500, "AZ789");
        Driver d2 = new Driver("John Adams", 21500, "XX111");
        assertTrue(d1.equals(d2));
    }

    @Test
    public void testCopy() {
        Driver d1 = new Driver("John Adams", 21500, "AZ789");
        Driver d2 = (Driver) d1.copy();

        assertNotSame(d1, d2);
        assertEquals(d1, d2);
        assertEquals(d1.getLicenseNumber(), d2.getLicenseNumber());
    }

    @Test
    public void testInheritance() {
        Driver d = new Driver("John", 1, "A1");
        assertTrue(d instanceof Person);
    }

    @Test
    public void testPolymorphicReference() {
        Person p = new Driver("John", 1, "A1");
        assertTrue(p instanceof Driver);
    }
}