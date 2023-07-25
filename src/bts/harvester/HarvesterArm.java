package bts.harvester;

import java.util.Scanner;

import bts.bt.Action;
import bts.bt.Condition;
import bts.bt.Loop;
import bts.bt.Node;
import bts.bt.Sequence;
import bts.bt.Task;

/**
 * The {@code HarvesterArm} class represents a harvester arm in a harvesting system.
 * It utilizes a behavior tree to perform actions related to harvesting.
 */
public class HarvesterArm {
	
	private Node root;          // The root node of the behavior tree
	private Bin bin;            // The bin used for harvesting
	private State state;        // The state of the harvester 
	private Scanner scan;   	// a Scanner object to read input from the user

	/**
	 * Constructs a new {@code HarvesterArm} object with the specified bin.
	 *
	 * @param b the bin used for harvesting
	 */
	public HarvesterArm(Bin b) {
		this.bin = b;
		this.root = build();
		this.state = new State();
		this.scan = new Scanner(System.in);
	}

	/**
	 * Executes the behavior tree starting from the root node.
	 *
	 * @return {@code true} if the execution of the behavior tree is successful, {@code false} otherwise
	 */
	public boolean execute() {
		return root.execute();
	}

	// Private methods

	/**
	 * Builds and returns the root node of the behavior tree.
	 *
	 * @return the root node of the behavior tree
	 */
	private Node build() {
		return new Loop("l1", new Condition("c1", isNotFull),
				new Sequence("s1",
                    new Action("a1", detect),
                    new Condition("c2", pickable),
                    new Action("a2", advance),
                    new Action("a3", grip),
                    new Action("a4", retract),
                    new Condition("c3", picked),
                    new Action("a5", release)
                )
			);
	}
	
	// Task definitions
	
	private Task advance = (n) -> {
		/**
		 * Advances the harvester arm.
		 *
		 * @param n the name of the task node
		 * @return {@code true} indicating the successful execution of the task
		 */
		System.out.println(n + ": Advancing the arm");
		return true;
	};

	private Task pickable = (n) -> {
		/**
		 * Checks if the mango is ready for picking.
		 *
		 * @param n the name of the task node
		 * @return {@code true} if the mango is ready for picking, {@code false} otherwise
		 */
		if (state.isPickable()) {
			System.out.println(n + ": The mango is ready for picking");
			return true;
		}
		System.out.println(n + ": The mango is not ready for picking");
		return false;
	};

	private Task grip = (n) -> {
		/**
		 * Grips the mango with the harvester arm.
		 *
		 * @param n the name of the task node
		 * @return {@code true} if the picking was successful, {@code false} otherwise
		 */
		state.incrementValue();
		if(state.getAttempts() % 3 == 0) {
			state.setPayload(false);
			System.out.println(n + ": Picking the mango was unsuccessful");
			return false;
		}
		System.out.println(n + ": Picking the mango was successful");
		state.setPayload(true);
		return true;
	};

	private Task retract = (n) -> {
		/**
		 * Retracts the harvester arm.
		 *
		 * @param n the name of the task node
		 * @return {@code true} indicating the successful execution of the task
		 */
		System.out.println(n + ": Retracting the arm");
		return true;
	};

	private Task picked = (n) -> {
		/**
		 * Checks if the harvester arm has a mango.
		 *
		 * @param n the name of the task node
		 * @return {@code true} if the gripper has a mango, {@code false} otherwise
		 */
		if (state.hasPayload()) {
			System.out.println(n + ": The gripper has a mango");
			return true;
		}
		System.out.println(n + ": The gripper has no mango");
		return false;
	};

	private Task release = (n) -> {
		/**
		 * Releases the mango into the bin.
		 *
		 * @param n the name of the task node
		 * @return {@code true} indicating the successful execution of the task
		 */
		System.out.println(n + ": Dropping the mango into the bin");
		state.setPayload(false);
		bin.add();
		return true;
	};

	private Task detect = (n) -> {
		/**
		 * Detects a ripe mango.
		 *
		 * @param n the name of the task node
		 * @return {@code true} indicating the successful execution of the task
		 */
		System.out.println(n + ": a ripe mango has been detected");
		System.out.print("a1: Is the mango ripe/unripe? ");
		String s = scan.nextLine().trim();
		while(!s.equals("ripe") && !s.equals("unripe")) {
			System.out.print("Invalid entry ");
			s = scan.nextLine().trim();
		}
		state.setPickable(s);
		return true;
	};
	
	/**
	 * Task to check whether the bin is full or not.
	 */
	private Task isNotFull = (n) -> {
		if(!bin.isFull()) {
			System.out.println();
			System.out.printf(n + ": The bin contains %s mangoes\n", bin.getCount());
			return true;
		}
		System.out.println();
		System.out.println(n + ": The bin is full");
		return false;
	};
}


