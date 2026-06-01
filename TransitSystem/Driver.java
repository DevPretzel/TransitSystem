package proj4;

/**
 * Implements the Driver class. <br>
 * Filename: Driver.java <br>
 * Project 4: Driver <br>
 * Date: 2026-05-15
 * @author Roland Pelzel
 */
public class Driver extends Person {
	
	// Field
	private String licenseNumber;
	
	/**
	 * No-arg constructor that creates a default driver with empty String as
	 * a name, 0 as the id, and AA111 as the driver license.
	 */
	public Driver() {
		super("", 0);
		this.licenseNumber = "AA111";
	}
	
	/**
	 * Parameterized constructor that takes a name, id, and license number.
	 * 
	 * @param name Name of the driver
	 * @param id ID of the driver
	 * @param licenseNumber Driver's license number
	 */
	public Driver(String name, int id, String licenseNumber) {
		super(name, id);
		this.licenseNumber = licenseNumber;
	}
	
	/**
	 * Gets the license number of the Driver.
	 * @return String
	 */
	public String getLicenseNumber() { return this.licenseNumber; }
	
	/**
	 * Returns a string representation of the driver in the following format:
	 * <br> Driver John Adams, ID:21500, AZ789
	 */
	@Override
	public String toString() {
		String string = "";
		string = String.format(
				"Driver %s, ID:%d, %s", 
				super.getName(), super.getId(), this.licenseNumber
		);
		return string;
	}
	
	/**
	 * Returns a copy of the Driver.
	 */
	@Override
	public Driver copy() {
		Driver copy = new Driver(
				super.getName(), super.getId(), this.licenseNumber
		);
		return copy;
	}
}
