package proj4;

/**
 * Implements the Vehicle class. <br>
 * Filename: Vehicle.java <br>
 * Project 4: Vehicle <br>
 * Date: 2026-05-15 <br>
 * @author Roland Pelzel
 */
public abstract class Vehicle {
	
	// Fields
	private int vehicleId;
	private String model;
	private int capacity;
	
	/**
	 * Parameterized constructor that takes an id, model, capacity, and
	 * operator. 
	 * 
	 * @param id ID of the vehicle
	 * @param model The model of the vehicle
	 * @param cap The capacity of the vehicle
	 */
	public Vehicle(int id, String model, int cap) {
		this.vehicleId = id;
		this.model = model;
		this.capacity = cap;
	}
	
	/**
	 * Gets this vehicle's ID number.
	 * @return The ID of this vehicle
	 */
	public int getVehicleId() { return this.vehicleId; }
	
	/**
	 * Gets the model of this vehicle.
	 * @return The model of this vehicle as a String
	 */
	public String getModel() { return this.model; }
	
	/**
	 * Gets the capacity of this vehicle.
	 * @return The capacity of this vehicle as an int
	 */
	public int getCapacity() { return this.capacity; }
	
	/**
	 * Implement in subclasses.
	 */
	@Override
	public abstract String toString();
	
	/**
	 * Two vehicles are equal if they have the same id, model, and capacity.
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Vehicle)) return false;
		
		Vehicle other = (Vehicle)obj;
		if(this.getVehicleId() == other.getVehicleId()) {
			if(this.getModel().equals(other.getModel())) {
				if(this.getCapacity() == other.getCapacity())
					return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Implement in subclasses.
	 */
	public abstract Vehicle copy();
}
