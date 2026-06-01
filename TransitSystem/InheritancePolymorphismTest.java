package proj4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InheritancePolymorphismTest {

    @Test
    public void testDriverIsPerson() {
        Driver d = new Driver("John", 1, "A1");
        assertTrue(d instanceof Person);
    }

    @Test
    public void testPassengerIsPerson() {
        Passenger p = new Passenger("Sara", 2, 10.0);
        assertTrue(p instanceof Person);
    }

    @Test
    public void testAdultPassengerIsPassengerButNotDiscountable() {
        AdultPassenger a = new AdultPassenger("Amy", 3, 10.0);
        assertTrue(a instanceof Passenger);
        assertFalse(a instanceof Discountable);
    }

    @Test
    public void testChildPassengerIsPassengerAndDiscountable() {
        ChildPassenger c = new ChildPassenger("Kid", 4, 10.0);
        assertTrue(c instanceof Passenger);
        assertTrue(c instanceof Discountable);
    }

    @Test
    public void testSeniorPassengerIsPassengerAndDiscountable() {
        SeniorPassenger s = new SeniorPassenger("Sam", 5, 10.0);
        assertTrue(s instanceof Passenger);
        assertTrue(s instanceof Discountable);
    }

    @Test
    public void testBusIsVehicle() {
        Bus b = new Bus(10, "Mini", 20, null);
        assertTrue(b instanceof Vehicle);
    }

    @Test
    public void testTrainIsVehicle() {
        Train t = new Train(20, "Metro", 100, 5);
        assertTrue(t instanceof Vehicle);
    }

    @Test
    public void testVehicleReferenceCanStoreBus() {
        Vehicle v = new Bus(10, "Mini", 20, null);
        assertTrue(v instanceof Bus);
    }

    @Test
    public void testVehicleReferenceCanStoreTrain() {
        Vehicle v = new Train(20, "Metro", 100, 5);
        assertTrue(v instanceof Train);
    }

    @Test
    public void testPassengerReferenceCanStoreChildPassenger() {
        Passenger p = new ChildPassenger("Kid", 4, 10.0);
        assertTrue(p instanceof ChildPassenger);
    }

    @Test
    public void testPassengerReferenceCanStoreSeniorPassenger() {
        Passenger p = new SeniorPassenger("Sam", 5, 10.0);
        assertTrue(p instanceof SeniorPassenger);
    }

    @Test
    public void testDiscountableReferenceCanStoreChildPassenger() {
        Discountable d = new ChildPassenger("Kid", 4, 10.0);
        assertEquals(0.5, d.getDiscountRate(), 0.0001);
    }

    @Test
    public void testDiscountableReferenceCanStoreSeniorPassenger() {
        Discountable d = new SeniorPassenger("Sam", 5, 10.0);
        assertEquals(0.3, d.getDiscountRate(), 0.0001);
    }
}