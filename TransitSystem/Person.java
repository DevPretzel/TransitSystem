package proj4;

/**
 * Implements the Person class. <br>
 * Filename: Person.java <br>
 * Project 4: Person <br>
 * Date: 2026-05-15 <br>
 * @author Roland Pelzel
 */
public abstract class Person {
	
	// Fields
	private String name;
	private int id;
	
	/**
	 * No-arg constructor that creates a default person with an empty Sting as
	 * a name and 0 as the id.
	 */
	public Person() {
		this.name = "";
		this.id = 0;
	}
	
	/**
	 * Parameterized constructor that takes a Person name and ID.
	 * @param name Name of the Person
	 * @param id ID of the Person
	 */
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	/**
	 * Gets this Person's name.
	 * @return The name of this Person
	 */
	public String getName() { return this.name; }
	
	/**
	 * Gets this Person's ID number.
	 * @return The ID of this Person
	 */
	public int getId() { return this.id; }
	
	/**
	 * Sets this Person's name.
	 * @param name The new name
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * Sets this Person's ID.
	 * @param id The new ID number
	 */
	public void setID(int id) { this.id = id; }
	
	/**
	 * Implement in subclasses.
	 */
	@Override
	public abstract String toString();
	
	/**
	 * Two persons are equal if they have the same name and id.
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) return false;
		
		Person other = (Person)obj;
		if(this.getName().equals(other.getName())) {
			if(this.getId() == other.getId())
				return true;
		}
		
		return false;
	}
	
	/**
	 * Implement in subclasses.
	 */
	public abstract Person copy();
}
