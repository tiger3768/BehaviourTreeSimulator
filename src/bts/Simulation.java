package bts;

import bts.harvester.Bin;
import bts.harvester.HarvesterArm;

/**
 * The {@code Simulation} class represents a simulation of a harvesting system.
 * It creates a bin and a harvester arm, and executes the harvester arm's behavior tree.
 */
public class Simulation {
	
	/**
	 * The entry point of the simulation.
	 *
	 * @param args the command line arguments (not used in this simulation)
	 */
	public static void main(String[] args) {
		Bin bin = new Bin(4);
		HarvesterArm hArm = new HarvesterArm(bin);
		
		System.out.println("run:");
		
		if(hArm.execute()) {
			System.out.println("Execution succeeded");
		} else {
			System.out.println("Execution failed");
		}
	}
}
