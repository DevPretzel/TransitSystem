package proj4;

/**
 * Implements the Passenger class. <br>
 * Filename: Passenger.java <br>
 * Project 4: Passenger <br>
 * Date: 2026-05-15
 * @author Roland Pelzel
 */
public class Passenger extends Person {
	
	private double balance;
	private Ticket ticket;
	
	/**
	 * No-arg constructor that creates a default passenger with empty String
	 * as a name, 0 as the id, 0.0 as the balance, and a null ticket.
	 */
	public Passenger() {
		super("", 0);
		this.balance = 0.0;
		this.ticket = null;
	}
	
	/**
	 * Parameterized constructor that takes a name as a String, an int ID, 
	 * a balance as as double, and a null ticket.
	 * 
	 * @param name Name of the Passenger (String)
	 * @param id ID of the Passenger (int)
	 * @param bal Balance of the Passenger (double)
	 */
	public Passenger(String name, int id, double bal) {
		super(name, id);
		this.balance = bal;
		this.ticket = null;
	}
	
	/**
	 * Gets the balance of this passenger.
	 * @return double
	 */
	public double getBalance() { return this.balance; }
	
	/**
	 * Adds the specified amount to the passenger's balance. Assumes the 
	 * amount is positive. 
	 * 
	 * @param amount Amount to add to this Passenger's balance
	 */
	public void addBalance(double amount) { 
		if(amount > 0.0) this.balance += amount; 
	}
	
	/**
	 * If the fare is valid, and the passenger has enough balance, deduct the
	 * fare from the passenger's balance and return true. Else, return false.
	 * 
	 * @param fare Fare to deduct from passenger balance
	 * @return true if fare is deducted, false otherwise
	 */
	public boolean payFare(double fare, boolean mp, boolean dp) 
	throws Exception {
		if(fare < 0.0) return false;
		
		Ticket t = new Ticket(fare, mp, dp);
		
		if(this.balance >= t.getCost()) {
			this.balance -= t.getCost();
			this.ticket = t;
			return true;
		}
//		if(fare >= 0.0) {
//			if(this.balance >= fare) {
//				Ticket t = new Ticket(fare, mp, dp);
//				this.balance -= t.getCost();
//				this.ticket = t;
//				return true;
//			}
//		}
		
		return false;
	}
	
	/**
	 * Returns true if the ticket is usable. 
	 * @return boolean
	 */
	public boolean useTicket() {
		if(this.ticket == null) return false;
		return this.ticket.useTicket();
	}
	
	/**
	 * Returns a string representation of the passenger in the following form:
	 * <br> Passenger Sarah Nash, ID:10001, balance: $5.00
	 */
	@Override
	public String toString() {
		String string = "";
		string = String.format(
				"Passenger %s, ID:%d, balance: $%.2f", 
				super.getName(), super.getId(), this.balance
		);
		return string;
	}
	
	/**
	 * Two passengers are equal if they have the same name and id.
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Passenger)) return false;
		
		Passenger other = (Passenger)obj;
		if(super.getName().equals(other.getName())) {
			if(super.getId() == other.getId())
				return true;
		}
		
		return false;
	}
	
	/**
	 * Returns a copy of the Passenger.
	 */
	@Override
	public Passenger copy() {
		Passenger copy = new Passenger(
				super.getName(), super.getId(), this.balance
		);
		return copy;
	}
}
