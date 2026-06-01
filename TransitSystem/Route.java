package proj4;

/**
 * Implements the Route class. <br>
 * Filename: Route.java <br>
 * Project 4: Route <br>
 * Date: 2026-05-15 <br>
 * @author Roland Pelzel
 */
public class Route {
	
	// Fields
	private String routeName, startStop, endStop;
	private double distance;
	
	/**
	 * Parameterized constructor that takes a name, start stop, end stop, and
	 * distance. 
	 * 
	 * @param name Name of the route
	 * @param start Start stop of the route
	 * @param end End stop of the route
	 * @param distance distance of the route
	 */
	public Route(String name, String start, String end, double distance) {
		this.routeName = name;
		this.startStop = start;
		this.endStop   = end;
		this.distance  = distance;
	}
	
	/**
	 * Gets the name of the route.
	 * @return The name of the route as a String
	 */
	public String getRouteName() { return this.routeName; }
	
	/**
	 * Gets the start stop of the route.
	 * @return The start stop of the route as a String
	 */
	public String getStartStop() { return this.startStop; }
	
	/**
	 * Gets the end stop of the route.
	 * @return The end stop of the route as a String
	 */
	public String getEndStop() { return this.endStop; }
	
	/**
	 * Gets the distance of the route.
	 * @return The distance of the route as a double
	 */
	public double getDistance() { return this.distance; }
	
	/**
	 * Returns a string representation of the Route in the following format:
	 * <br> Route: SouthBound, from start to stop.
	 */
	@Override
	public String toString() {
		String string = "";
		string = String.format(
				"Route: %s, from %s to %s.", 
				this.routeName, this.startStop, this.endStop
				);
		return string;
	}
	
	/**
	 * Two routes are equal if they have the same route name, start stop, and
	 * end stop. 
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Route)) return false;
		
		Route other = (Route)obj;
		if(this.getRouteName().equals(other.getRouteName())) {
			if(this.getStartStop().equals(other.getStartStop())) {
				if(this.getEndStop().equals(other.endStop)) {
					if(this.getDistance() == other.getDistance())
						return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Copies a Route object. 
	 * @return A deep copy of this Route object
	 */
	public Route copy() {
		String newname = this.getRouteName();
		String newstart = this.getStartStop();
		String newend = this.getEndStop();
		double newdis = this.getDistance();
		
		return new Route(newname, newstart, newend, newdis);
	}
}
