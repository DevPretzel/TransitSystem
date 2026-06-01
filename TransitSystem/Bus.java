package proj4;

/**
 * Implements the Bus class. <br>
 * Filename: Bus.java <br>
 * Project 4: Bus <br>
 * Date: 2026-05-15
 * @author Roland Pelzel
 */
public class Bus extends Vehicle {
	
	// Field
	private Driver driver;
	
	/**
	 * Parameterized constructor that creates a Bus object.
	 */
	public Bus(int id, String model, int cap, Driver driver) {
		super(id, model, cap);
		this.driver = driver;
	}
	
	/**
	 * Gets the driver of the bus.
	 * @return Driver object associated with Bus
	 */
	public Driver getDriver() { return this.driver; }
	
	/**
	 * Sets the driver of the bus.
	 * @param driver Driver object
	 */
	public void setDriver(Driver driver) { this.driver = driver; }
	
	/**
	 * Returns a string representation of the bus in the following format: <br>
	 * Bus:15200, model: minibus, capacity: 12
	 */
	@Override
	public String toString() {
		String string = "";
		string = String.format(
				"Bus:%d, model: %s, capacity: %d", 
				super.getVehicleId(), super.getModel(), super.getCapacity()
		);
		return string;
	}
	
	/**
	 * Returns a copy of the Bus.
	 */
	@Override
	public Bus copy() {
		Driver d = this.driver == null ? null : this.driver.copy();
		
		Bus copy = new Bus(
				super.getVehicleId(), 
				super.getModel(), 
				super.getCapacity(), 
				d
		);
		
		return copy;
	}
}
