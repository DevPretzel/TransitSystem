package proj4;

/**
 * Implements the SeniorPassenger class. <br>
 * Filename: SeniorPassenger.java <br>
 * Project 4: AdultPassenger, ChildPassenger, and SeniorPassenger <br>
 * Date: 2026-05-15
 * @author Roland Pelzel
 */
public class SeniorPassenger extends Passenger implements Discountable {
	
	/**
	 * Parameterized constructor that takes a string name, int id, and a 
	 * balance as a double.
	 * 
	 * @param name Name of the senior passenger
	 * @param id ID of the senior passenger
	 * @param bal Balance of the senior passenger
	 */
	public SeniorPassenger(String name, int id, double bal) {
		super(name, id, bal);
	}
	
	/**
	 * Returns 0.3
	 */
	public double getDiscountRate() { return 0.3; }
	
	/**
	 * Overrides payFare so that the passenger receives a 30% discount.
	 */
	@Override
	public boolean payFare(double fare, boolean mp, boolean dp) 
	throws Exception {
		fare -= fare * this.getDiscountRate();
		return super.payFare(fare, mp, dp);
	}
	
	/**
	 * Returns a copy of the SeniorPassenger.
	 */
	@Override
	public SeniorPassenger copy() {
		SeniorPassenger copy = new SeniorPassenger(
				super.getName(), super.getId(), super.getBalance()
		);
		return copy;
	}
}
