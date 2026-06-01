package proj4;

import java.util.ArrayList;

/**
 * Implements the Trip class. <br>
 * Filename: Trip.java <br>
 * Project 4: Trip <br>
 * Date: 2026-05-15 <br>
 * @author Roland Pelzel
 */
public class Trip {
	
	// Fields
	private Vehicle vehicle;
	private Route route;
	private ArrayList<Passenger> riders = new ArrayList<Passenger>();
	private double fare;
	
	/**
	 * Parameterized constructor that takes a vehicle, route, and fare.
	 * 
	 * @param vehicle Vehicle object
	 * @param route Route object
	 * @param fare Fare as a double
	 */
	public Trip(Vehicle vehicle, Route route, double fare) {
		this.vehicle = vehicle;
		this.route = route;
		this.fare = fare;
	}
	
	/**
	 * Gets the vehicle of this trip.
	 * @return The vehicle of this trip
	 */
	public Vehicle getVehicle() { return this.vehicle.copy(); }
	
	/**
	 * Gets the Route of this trip.
	 * @return The route of this trip
	 */
	public Route getRoute() { return this.route.copy(); }
	
	/**
	 * Gets the fare for this trip.
	 * @return The fare for this trip as a double
	 */
	public double getFare() { return this.fare; }
	
	/**
	 * Returns the number of passengers.
	 * @return int
	 */
	public int getPassengerCount() { return this.riders.size(); }
	
	/**
	 * Adds a passenger only if the trip is not full and the passenger 
	 * successfully pays the fare.
	 * 
	 * @param p The person to add to the trip
	 * @return true if added and false otherwise. Vehicle capacity cannot be 
	 * exceeded
	 */
	public boolean addPassenger(Passenger p, boolean mp, boolean dp)
	throws Exception {
		if(this.isFull()) return false;
		
		if(p.payFare(this.fare, mp, dp)) {
			if(p.useTicket()) {
				return this.riders.add(p.copy());
			}
		}
//		if(!(this.isFull())) {
//			boolean paid = p.payFare(this.fare, mp, dp);
//			boolean use = p.useTicket();
//			if(paid && use) return this.riders.add(p.copy());
//		}
		return false;
	}
	
	/**
	 * Removes a rider from the trip.
	 * @param p The person to be removed
	 * @return true when passenger is removed, false if passenger is not found
	 */
	public boolean removePassenger(Passenger p) {
		return this.riders.remove(p);
	}
	
	/**
	 * Gets the number of riders.
	 * @return The number of riders
	 */
	public int getRiderCount() { return this.riders.size(); }
	
	/**
	 * Checks if the vehicle is full.
	 * @return true if the vehicle is full, false otherwise
	 */
	public boolean isFull() {
		if(this.riders.size() >= this.vehicle.getCapacity())
			return true;
		return false;
	}
	
	/**
	 * Returns a deep copy of the ArrayList of Passengers.
	 * @return ArrayList of Passengers
	 */
	public ArrayList<Passenger> getPassengers() {
		ArrayList<Passenger> listcopy = new ArrayList<Passenger>();
		
		for(Passenger p : this.riders) 
			listcopy.add(p.copy());
		
		
		return listcopy;
	}
	
	/**
	 * Returns a string representation of the Trip in the following format:
	 * <br> Route: SouthBound, from start to stop, fare: $3.00
	 */
	@Override
	public String toString() {
		String string = "";
		string = String.format(
				"Route: %s, from %s to %s, fare: $%.2f", 
				this.route.getRouteName(), this.route.getStartStop(), 
				this.route.getEndStop(), this.fare
				);
		return string;
	}
	
	/**
	 * Two trips are equal if they have the same vehicle, route, riders, and
	 * fare. 
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Trip)) return false;
		
		Trip other = (Trip)obj;
		if(this.getVehicle().equals(other.getVehicle())) {
			if(this.getRoute().equals(other.getRoute())) {
				if(this.getPassengers().equals(other.getPassengers())) {
					if(this.getFare() == other.getFare())
						return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Copies a Trip object. 
	 * @return A deep copy of a Trip object
	 */
	public Trip copy() {
		Vehicle newveh = this.vehicle.copy();
		Route newroute = this.route.copy();
		ArrayList<Passenger> newriders = this.getPassengers();
		double newfare = this.fare;
		
		Trip tripcopy = new Trip(newveh, newroute, newfare);
		for(Passenger p : newriders) tripcopy.riders.add(p.copy());
		
		return tripcopy;
	}
}
