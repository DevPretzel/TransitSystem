package proj4;

/**
 * Implements the Train class. <br>
 * Filename: Train.java <br>
 * Project 4: Train <br>
 * Date: 2026-05-15
 * @author Roland Pelzel
 */
public class Train extends Vehicle {
	
	private int numUnits;
	
	/**
	 * Parameterized constructor that takes a vehicle ID, vehicle model,
	 * capacity, and number of units. 
	 * 
	 * @param id Vehicle ID
	 * @param model Vehicle model
	 * @param cap Vehicle capacity
	 * @param nu Number of units
	 */
	public Train(int id, String model, int cap, int nu) {
		super(id, model, cap);
		this.numUnits = nu;
	}
	
	/**
	 * Gets the number of units of the train.
	 * @return int
	 */
	public int getNumUnits() { return this.numUnits; }
	
	/**
	 * Returns a string representation of the train in the following format:
	 * <br> Train:250100, model: metro, capacity: 120, numUnits: 5
	 */
	@Override
	public String toString() {
		String string = "";
		string = String.format(
				"Train:%d, model: %s, capacity: %d, numUnits: %d", 
				super.getVehicleId(), super.getModel(), super.getCapacity(), 
				this.numUnits
		);
		return string;
	}
	
	/**
	 * Two trains are equal if they have the same id, model, capacity, and
	 * numUnits. 
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Train)) return false;
		
		Train other = (Train)obj;
		if(this.numUnits == other.getNumUnits()) {
			if(super.equals(other))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Returns a copy of the Train.
	 */
	@Override
	public Train copy() {
		Train copy = new Train(
				super.getVehicleId(), super.getModel(), super.getCapacity(),
				this.numUnits
		);
		return copy;
	}
}
