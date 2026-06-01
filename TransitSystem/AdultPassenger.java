package proj4;

/**
 * Implements the AdultPassenger class. <br>
 * Filename: AdultPassenger.java <br>
 * Project 4: AdultPassenger, ChildPassenger, and SeniorPassenger <br>
 * Date: 2026-05-15
 * @author Roland Pelzel
 */
public class AdultPassenger extends Passenger {
	
	/**
	 * Parameterized constructor that takes a string name, int id, and a 
	 * balance as a double. 
	 * 
	 * @param name Name of the adult passenger
	 * @param id ID of the adult passenger
	 * @param balance The adult passenger's balance
	 */
	public AdultPassenger(String name, int id, double balance) {
		super(name, id, balance);
	}
	
	/**
	 * Returns a copy of the AdultPassenger.
	 */
	@Override
	public AdultPassenger copy() {
		AdultPassenger copy = new AdultPassenger(
				super.getName(), super.getId(), super.getBalance()
		);
		return copy;
	}
}
