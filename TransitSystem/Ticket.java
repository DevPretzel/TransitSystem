package proj4;

import java.time.LocalDate;

/**
 * Implements the Ticket class. <br>
 * Filename: Ticket.java <br>
 * Project 4: Ticket <br>
 * Date: 2026-05-15
 * @author Roland Pelzel
 */
public class Ticket {
	
	static int ticketId = 1;
	
	private int ticketnum;
	private LocalDate expiration;
	private boolean used;	// for single-use tickets
	private boolean isexpired;
	private double cost;
	private boolean monthlyPass;
	private boolean dayPass;
	
	/**
	 * Parameterized constructor that takes a ticket cost and mutually 
	 * exclusive pass options. 
	 * @param cost double
	 * @param mp boolean
	 * @param dp boolean
	 * @throws Exception
	 */
	public Ticket(double cost, boolean mp, boolean dp) throws Exception {
		if(mp && dp)
			throw new Exception("Cannot be monthly and day pass.");
		
		if(dp) this.cost = cost * 2;
		else if(mp) this.cost = cost * 5;
		else this.cost = cost;
		
		this.monthlyPass = mp;
		this.dayPass = dp;
		
		this.used = false;
		
		this.ticketnum = Ticket.ticketId;
		Ticket.ticketId++;
		
		if(mp) this.expiration = LocalDate.now().plusMonths(1);
		else if(dp) this.expiration = LocalDate.now().plusDays(1);
		else this.expiration = LocalDate.now();
	}
	
	/**
	 * Returns true if the ticket is usable. 
	 * @return boolean
	 */
	public boolean useTicket() {
		if(this.isExpired()) return false;
		
		if(!this.monthlyPass && !this.dayPass) {
			if(this.used) return false;
			used = true;
		}
		
		return true;
	}
	
	/**
	 * Sets if the ticket is a monthly pass.
	 * @param mp boolean
	 */
	public void setMonthlyPass(boolean mp) {
		this.monthlyPass = mp;
		if(mp) this.dayPass = false;
	}
	
	/**
	 * Sets if the ticket is a day pass.
	 * @param dp boolean
	 */
	public void setDayPass(boolean dp) {
		this.dayPass = dp;
		if(dp) this.monthlyPass = false;
	}
	
	/**
	 * Sets the cost of the ticket.
	 * @param cost Cost of the ticket must be not be negative
	 * @return true if valid cost
	 */
	public boolean setCost(double cost) {
		if(cost >= 0.0) {
			if(this.dayPass) this.cost = cost * 2;
			else if(this.monthlyPass) this.cost = cost * 5;
			else this.cost = cost;
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the ticket number.
	 * @return int
	 */
	public int getTicketNum() { return this.ticketnum; }
	
	/**
	 * Gets the cost of the ticket.
	 * @return double
	 */
	public double getCost() { return this.cost; }
	
	/**
	 * Gets the expiration date of the ticket.
	 * @return LocalDate
	 */
	public LocalDate getExpiration() { return this.expiration; }
	
	/**
	 * Gets the use status of the ticket.
	 * @return boolean
	 */
	public boolean getUsed() { return this.used; }
	
	/**
	 * Returns true if the ticket is a day pass.
	 * @return boolean
	 */
	public boolean isMonthlyPass() { return this.monthlyPass; }
	
	/**
	 * Returns true if the ticket is a monthly pass.
	 * @return boolean
	 */
	public boolean isDayPass() { return this.dayPass; }
	
	/**
	 * Returns true if a ticket is expired.
	 * @return boolean
	 */
	public boolean isExpired() {
		if(this.isexpired) return true;
		
		return LocalDate.now().isAfter(this.expiration);
	}
	
	/**
	 * Returns a string representation in the following format: <br>
	 * Ticket#: 1, Monthly Pass: No, Day Pass: No
	 */
	@Override
	public String toString() {
		String m = this.monthlyPass ? "Yes" : "No";
		String d = this.dayPass ? "Yes" : "No";
		return String.format("Ticket#: %d, Monthly Pass: %s, Day Pass: %s", 
				this.ticketnum, m, d);
	}
	
	/**
	 * Two tickets are equal if their IDs are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Ticket)) return false;
		
		Ticket other = (Ticket)obj;
		if(this.ticketnum == other.getTicketNum()) return true;
		
		return false;
	}
}