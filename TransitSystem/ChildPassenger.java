package proj4;

/**
 * Implements the ChildPassenger class. <br>
 * Filename: ChildPassenger.java <br>
 * Project 4: AdultPassenger, ChildPassenger, and SeniorPassenger <br>
 * Date: 2026-05-15
 * @author Roland Pelzel
 */
public class ChildPassenger extends Passenger implements Discountable {
	
	/**
	 * Parameterized constructor that takes a string name, int id, and a
	 * balance as a double. 
	 * 
	 * @param name Name of the child passenger
	 * @param id ID of the child passenger
	 * @param balance Balance of the child passenger
	 */
	public ChildPassenger(String name, int id, double balance) {
		super(name, id, balance);
	}
	
	/**
	 * Returns 0.5
	 */
	public double getDiscountRate() { return 0.5; }
	
	/**
	 * Overrides payFare so that the passenger only pays half of the fare.
	 */
	@Override
	public boolean payFare(double fare, boolean mp, boolean dp) 
	throws Exception {
		fare -= fare * this.getDiscountRate(); 
		return super.payFare(fare, mp, dp);
	}
	
	/**
	 * Returns a copy of the ChildPassenger.
	 */
	@Override
	public ChildPassenger copy() {
		ChildPassenger copy = new ChildPassenger(
				super.getName(), super.getId(), super.getBalance()
		);
		return copy;
	}
}
