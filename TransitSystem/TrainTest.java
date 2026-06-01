package proj4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainTest {

    @Test
    public void testConstructorAndGetters() {
        Train t = new Train(25010, "metro", 120, 5);

        assertEquals(25010, t.getVehicleId());
        assertEquals("metro", t.getModel());
        assertEquals(120, t.getCapacity());
        assertEquals(5, t.getNumUnits());
    }

    @Test
    public void testToString() {
        Train t = new Train(25010, "metro", 120, 5);
        assertEquals("Train:25010, model: metro, capacity: 120, numUnits: 5", t.toString());
    }

    @Test
    public void testEquals() {
        Train t1 = new Train(25010, "metro", 120, 5);
        Train t2 = new Train(25010, "metro", 120, 5);
        assertTrue(t1.equals(t2));
    }

    @Test
    public void testCopy() {
        Train t1 = new Train(25010, "metro", 120, 5);
        Train t2 = (Train) t1.copy();

        assertNotSame(t1, t2);
        assertEquals(t1, t2);
    }

    @Test
    public void testInheritance() {
        Train t = new Train(1, "Metro", 100, 4);
        assertTrue(t instanceof Vehicle);
    }

    @Test
    public void testPolymorphicReference() {
        Vehicle v = new Train(1, "Metro", 100, 4);
        assertTrue(v instanceof Train);
    }
}