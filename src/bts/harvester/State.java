package bts.harvester;

/**
 * The {@code State} class represents the state of a harvester arm in a harvesting system.
 * It keeps track of the number of attempts made to pick the fruit, whether the fruit is ripe and pickable,
 * and whether the fruit has already been picked or has a payload.
 */
public class State {

	private boolean pickable;  // Whether the fruit is ripe and pickable
	private boolean payload;   // Whether the fruit has already been picked or has a payload
	private int attempts; 	   // Number of attempts made to pick up a mango
	
	/**
	 * Constructs a new {@code State} object with default values.
	 * Initializes attempts to 0, pickable is set to false, and payload is set to false.
	 */
	public State() {
		pickable = false;
		payload = false;
		attempts = 0;
	}

	/**
	 * Checks if the fruit is ripe and pickable.
	 *
	 * @return {@code true} if the fruit is ripe and pickable, {@code false} otherwise
	 */
	public boolean isPickable() {
		return pickable;
	}
	
	/**
	 * Sets the pickable state of the fruit based on the given string.
	 * If the string is "ripe", the fruit is considered pickable; otherwise, it is considered not pickable.
	 *
	 * @param s the string indicating the pickable state of the fruit ("ripe" or other)
	 */
	public void setPickable(String s) {
		if (s.equals("ripe")) {
			pickable = true;
		} else {
			pickable = false;
		}
	}
	
	/**
	 * Checks if the fruit has already been picked or has a payload.
	 *
	 * @return {@code true} if the fruit has already been picked or has a payload, {@code false} otherwise
	 */
	public boolean hasPayload() {
		return payload;
	}
	
	/**
	 * Sets the payload state of the fruit.
	 *
	 * @param p the payload state of the fruit (true if picked or has a payload, false otherwise)
	 */
	public void setPayload(boolean p) {
		payload = p;
	}
	
	/**
	 * Getter method for attempts
	 * @return number of attempts made to pick up a mango
	 */
	public int getAttempts() {
		return attempts;
	}
	
	/**
	 * Used to increase the number of attempts
	 * @return incremented value for attempts
	 */
	public int incrementValue() {
		return ++attempts;
	}
}
