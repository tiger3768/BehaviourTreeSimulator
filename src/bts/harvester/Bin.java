package bts.harvester;

/**
 * The {@code Bin} class represents a bin used for harvesting fruits.
 * It keeps track of the number of fruits in the bin.
 */
public class Bin {
	
	private int count;  // Number of fruits in the bin
	private int capacity; // Capacity of the bin

	/**
	 * Constructs a new {@code Bin} object with an initial count of 0, and initializes capacity.
	 * @param capacity the capacity of the bin
	 */
	public Bin(int capacity) {
		count = 0;
		this.capacity = capacity;
	}

	/**
	 * Empties the bin by setting the count to 0.
	 */
	public void empty() {
		count = 0;
	}
	
	/**
	 * Adds a fruit to the bin by incrementing the count by 1.
	 */
	public void add() {
		++count;
	}
	
	/**
	 * Checks whether the bin is full or not
	 * @return true if the bin is full, false otherwise
	 */
	public boolean isFull() {
		return count == capacity;
	}
	
	/**
	 * Returns the current count of fruits in the bin.
	 *
	 * @return the count of fruits in the bin
	 */
	public int getCount() {
		return count;
	}
}


