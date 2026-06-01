package proj4;

import java.util.ArrayList;

/**
 * Implements the TransitSystem class. <br>
 * Filename: TransitSystem.java <br>
 * Project 4: TransitSystem <br>
 * Date: 2026-05-15 <br>
 * @author Roland Pelzel
 */
public class TransitSystem {
	
	// Fields
	private String city;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private ArrayList<Route>   routes   = new ArrayList<Route>();
	private ArrayList<Trip>    trips    = new ArrayList<Trip>();
	
	/**
	 * Parameterized constructor that gets a city name and initializes empty
	 * ArrayLists for vehicles, routes, and trips.
	 * 
	 * @param city Name of the transit system's city
	 */
	public TransitSystem(String city) { this.city = city; }
	
	/**
	 * Gets the name of the transit system's city.
	 * @return The name of the city as a String
	 */
	public String getCityName() { return this.city; }
	
	/**
	 * Gets a copy of the ArrayList of vehicles.
	 * @return The ArrayList of vehicles
	 */
	public ArrayList<Vehicle> getVehicles() {
		ArrayList<Vehicle> listcopy = new ArrayList<Vehicle>();
		for(Vehicle v : this.vehicles)
			listcopy.add(v.copy());
		return listcopy;
	}
	
	/**
	 * Gets a copy of the ArrayList of routes.
	 * @return The ArrayList of routes
	 */
	public ArrayList<Route> getRoutes() {
		ArrayList<Route> listcopy = new ArrayList<Route>();
		for(Route r : this.routes)
			listcopy.add(r.copy());
		return listcopy;
	}
	
	/**
	 * Gets a copy of the ArrayList of trips.
	 * @return The ArrayList of trips
	 */
	public ArrayList<Trip> getTrips() {
		ArrayList<Trip> listcopy = new ArrayList<Trip>();
		for(Trip t : this.trips)
			listcopy.add(t.copy());
		return listcopy;
	}
	
	/**
	 * Adds a vehicle to the system.
	 * @param v The vehicle to be added
	 * @return true if successful, false otherwise
	 */
	public boolean addVehicle(Vehicle v) {return this.vehicles.add(v.copy());}
	
	/**
	 * Adds a route to the system.
	 * @param r The route to be added
	 * @return true if successful, false otherwise
	 */
	public boolean addRoute(Route r) { return this.routes.add(r.copy()); }
	
	/**
	 * Adds a trip to the system.
	 * @param t The trip to be added
	 * @return true if successful, false otherwise
	 */
	public boolean addTrip(Trip t) { return this.trips.add(t.copy()); }
	
	/**
	 * Searches for a vehicle with the given id.
	 * @param id The id to search for
	 * @return The vehicle if found, null otherwise
	 */
	public Vehicle findVehicleById(int id) {
		for(Vehicle v : this.vehicles) {
			if(v.getVehicleId() == id)
				return v.copy();
		}
		return null;
	}
	
	/**
	 * Searches for a route with the given name.
	 * @param name The name to search for
	 * @return The route if found, null otherwise
	 */
	public Route findRouteByName(String name) {
		for(Route r : this.routes) {
			if(r.getRouteName().equals(name))
				return r.copy();
		}
		return null;
	}
	
	/**
	 * Returns a string representation of the Transit System in the following
	 * format: <br>
	 * Ashland, 3 vehicles, 15 routes, 50 trips.
	 */
	@Override
	public String toString() {
		String string = "";
		string = String.format(
				"%s, %d vehicles, %d routes, %d trips.",
				this.city, this.vehicles.size(),
				this.routes.size(), this.trips.size()
				);
		return string;
	}
}
