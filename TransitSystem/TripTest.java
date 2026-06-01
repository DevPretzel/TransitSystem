package proj4;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class TripTest {

    @Test
    public void testConstructorAndBasicGetters() {
        Bus b = new Bus(1, "Mini", 2, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 3.0);

        assertEquals(3.0, t.getFare(), 0.0001);

        Vehicle vCopy = t.getVehicle();
        Route rCopy = t.getRoute();

        assertEquals(b, vCopy);
        assertEquals(r, rCopy);
        assertNotSame(b, vCopy);
        assertNotSame(r, rCopy);
    }

    @Test
    public void testAddPassengerSuccess() throws Exception {
        Bus b = new Bus(1, "Mini", 2, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 3.0);

        Passenger p = new Passenger("Sarah", 1, 10.0);

        assertTrue(t.addPassenger(p, false, false));
        assertEquals(1, t.getPassengerCount());
        assertEquals(7.0, p.getBalance(), 0.0001);
    }

    @Test
    public void testAddPassengerFailNotEnoughBalance() throws Exception {
        Bus b = new Bus(1, "Mini", 2, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 5.0);

        Passenger p = new Passenger("Sarah", 1, 2.0);

        assertFalse(t.addPassenger(p, false, false));
        assertEquals(0, t.getPassengerCount());
        assertEquals(2.0, p.getBalance(), 0.0001);
    }

    @Test
    public void testAddPassengerPolymorphismChildPassenger() throws Exception {
        Bus b = new Bus(1, "Mini", 2, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 6.0);

        Passenger p = new ChildPassenger("Kid", 2, 5.0); // discounted fare is 3.0
        assertTrue(t.addPassenger(p, false, false));
        assertEquals(1, t.getPassengerCount());
        assertEquals(2.0, p.getBalance(), 0.0001);
    }

    @Test
    public void testAddPassengerFailWhenFull() throws Exception {
        Bus b = new Bus(1, "Mini", 1, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 2.0);

        Passenger p1 = new Passenger("A", 1, 10.0);
        Passenger p2 = new Passenger("B", 2, 10.0);

        assertTrue(t.addPassenger(p1, false, false));
        assertFalse(t.addPassenger(p2, false, false));
        assertEquals(1, t.getPassengerCount());
    }

    @Test
    public void testRemovePassengerSuccess() throws Exception {
        Bus b = new Bus(1, "Mini", 2, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 2.0);

        Passenger p = new Passenger("Sarah", 1, 10.0);
        t.addPassenger(p, false, false);

        assertTrue(t.removePassenger(p));
        assertEquals(0, t.getPassengerCount());
    }

    @Test
    public void testRemovePassengerFail() {
        Bus b = new Bus(1, "Mini", 2, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 2.0);

        Passenger p = new Passenger("Sarah", 1, 10.0);
        assertFalse(t.removePassenger(p));
    }

    @Test
    public void testIsFull() throws Exception {
        Bus b = new Bus(1, "Mini", 1, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 2.0);

        assertFalse(t.isFull());
        t.addPassenger(new Passenger("Sarah", 1, 10.0), false, false);
        assertTrue(t.isFull());
    }

    @Test
    public void testGetPassengersReturnsDeepCopy() throws Exception {
        Bus b = new Bus(1, "Mini", 2, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 2.0);

        Passenger p = new Passenger("Sarah", 1, 10.0);
        t.addPassenger(p, false, false);

        ArrayList<Passenger> list = t.getPassengers();

        assertEquals(1, list.size());
        assertEquals("Sarah", list.get(0).getName());
        assertNotSame(p, list.get(0));
    }

    @Test
    public void testToString() {
        Bus b = new Bus(1, "Mini", 2, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t = new Trip(b, r, 3.0);

        assertEquals("Route: SouthBound, from start to stop, fare: $3.00", t.toString());
    }

    @Test
    public void testCopy() throws Exception {
        Bus b = new Bus(1, "Mini", 2, null);
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        Trip t1 = new Trip(b, r, 3.0);
        t1.addPassenger(new Passenger("Sarah", 1, 10.0), false, false);

        Trip t2 = t1.copy();

        assertNotSame(t1, t2);
        assertEquals(t1, t2);
        assertNotSame(t1.getVehicle(), t2.getVehicle());
        assertNotSame(t1.getRoute(), t2.getRoute());
    }
}