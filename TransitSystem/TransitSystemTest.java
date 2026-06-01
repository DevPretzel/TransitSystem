package proj4;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class TransitSystemTest {

    @Test
    public void testConstructorAndCityName() {
        TransitSystem ts = new TransitSystem("Ashland");
        assertEquals("Ashland", ts.getCityName());
        assertEquals(0, ts.getVehicles().size());
        assertEquals(0, ts.getRoutes().size());
        assertEquals(0, ts.getTrips().size());
    }

    @Test
    public void testAddVehicleStoresCopy() {
        TransitSystem ts = new TransitSystem("Ashland");
        Bus b = new Bus(1, "Mini", 20, null);

        ts.addVehicle(b);
        ArrayList<Vehicle> vehicles = ts.getVehicles();

        assertEquals(1, vehicles.size());
        assertEquals(b, vehicles.get(0));
        assertNotSame(b, vehicles.get(0));
    }

    @Test
    public void testAddRouteStoresCopy() {
        TransitSystem ts = new TransitSystem("Ashland");
        Route r = new Route("SouthBound", "start", "stop", 4.5);

        ts.addRoute(r);
        ArrayList<Route> routes = ts.getRoutes();

        assertEquals(1, routes.size());
        assertEquals(r, routes.get(0));
        assertNotSame(r, routes.get(0));
    }

    @Test
    public void testAddTripStoresCopy() {
        TransitSystem ts = new TransitSystem("Ashland");
        Trip t = new Trip(new Bus(1, "Mini", 2, null),
                          new Route("SouthBound", "start", "stop", 4.5),
                          3.0);

        ts.addTrip(t);
        ArrayList<Trip> trips = ts.getTrips();

        assertEquals(1, trips.size());
        assertEquals(t, trips.get(0));
        assertNotSame(t, trips.get(0));
    }

    @Test
    public void testFindVehicleById() {
        TransitSystem ts = new TransitSystem("Ashland");
        Bus b = new Bus(100, "Mini", 20, null);
        ts.addVehicle(b);

        Vehicle found = ts.findVehicleById(100);
        assertNotNull(found);
        assertEquals(b, found);
        assertNotSame(b, found);
    }

    @Test
    public void testFindVehicleByIdNotFound() {
        TransitSystem ts = new TransitSystem("Ashland");
        assertNull(ts.findVehicleById(999));
    }

    @Test
    public void testFindRouteByName() {
        TransitSystem ts = new TransitSystem("Ashland");
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        ts.addRoute(r);

        Route found = ts.findRouteByName("SouthBound");
        assertNotNull(found);
        assertEquals(r, found);
        assertNotSame(r, found);
    }

    @Test
    public void testFindRouteByNameNotFound() {
        TransitSystem ts = new TransitSystem("Ashland");
        assertNull(ts.findRouteByName("NorthBound"));
    }

    @Test
    public void testGetVehiclesDeepCopy() {
        TransitSystem ts = new TransitSystem("Ashland");
        Bus b = new Bus(1, "Mini", 20, null);
        ts.addVehicle(b);

        ArrayList<Vehicle> vehicles = ts.getVehicles();
        assertEquals(1, vehicles.size());
        assertNotSame(b, vehicles.get(0));
    }

    @Test
    public void testGetRoutesDeepCopy() {
        TransitSystem ts = new TransitSystem("Ashland");
        Route r = new Route("SouthBound", "start", "stop", 4.5);
        ts.addRoute(r);

        ArrayList<Route> routes = ts.getRoutes();
        assertEquals(1, routes.size());
        assertNotSame(r, routes.get(0));
    }

    @Test
    public void testGetTripsDeepCopy() {
        TransitSystem ts = new TransitSystem("Ashland");
        Trip t = new Trip(new Bus(1, "Mini", 2, null),
                          new Route("SouthBound", "start", "stop", 4.5),
                          3.0);
        ts.addTrip(t);

        ArrayList<Trip> trips = ts.getTrips();
        assertEquals(1, trips.size());
        assertNotSame(t, trips.get(0));
    }

    @Test
    public void testToString() {
        TransitSystem ts = new TransitSystem("Ashland");
        ts.addVehicle(new Bus(1, "Mini", 20, null));
        ts.addRoute(new Route("SouthBound", "start", "stop", 4.5));
        ts.addTrip(new Trip(new Bus(2, "Metro", 30, null),
                            new Route("EastBound", "A", "B", 5.0),
                            2.0));

        assertEquals("Ashland, 1 vehicles, 1 routes, 1 trips.", ts.toString());
    }

    @Test
    public void testPolymorphismInVehicleList() {
        TransitSystem ts = new TransitSystem("Ashland");
        ts.addVehicle(new Bus(1, "Mini", 20, null));
        ts.addVehicle(new Train(2, "Metro", 100, 4));

        ArrayList<Vehicle> vehicles = ts.getVehicles();
        assertTrue(vehicles.get(0) instanceof Vehicle);
        assertTrue(vehicles.get(1) instanceof Vehicle);
    }
}