package proj4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RouteTest {

    @Test
    public void testConstructorAndGetters() {
        Route r = new Route("SouthBound", "start", "stop", 4.5);

        assertEquals("SouthBound", r.getRouteName());
        assertEquals("start", r.getStartStop());
        assertEquals("stop", r.getEndStop());
        assertEquals(4.5, r.getDistance(), 0.0001);
    }

    @Test
    public void testToString() {
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        assertEquals("Route: SouthBound, from start to stop.", r.toString());
    }

    @Test
    public void testEquals() {
        Route r1 = new Route("SouthBound", "start", "stop", 4.5);
        Route r2 = new Route("SouthBound", "start", "stop", 4.5);
        assertTrue(r1.equals(r2));
    }

    @Test
    public void testCopy() {
        Route r1 = new Route("SouthBound", "start", "stop", 4.5);
        Route r2 = r1.copy();

        assertNotSame(r1, r2);
        assertEquals(r1, r2);
    }
}