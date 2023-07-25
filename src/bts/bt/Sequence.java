package bts.bt;

import java.util.ArrayList;

/**
 * The {@code Sequence} class represents a sequence node in a behavior tree.
 * It executes its child nodes in order until one fails or all succeed.
 * If any child node fails, the sequence fails. Otherwise, it succeeds.
 */
public class Sequence extends Node {
	
	/**
	 * Constructs a new {@code Sequence} object with the specified name.
	 *
	 * @param name the name of the sequence node
	 */
	public Sequence(String name) {
		super(name);
	}

	/**
	 * Constructs a new {@code Sequence} object with the specified name and child nodes.
	 *
	 * @param name  the name of the sequence node
	 * @param nodes the child nodes of the sequence
	 */
	public Sequence(String name, Node... nodes) {
		super(name, nodes);
	}

	/**
	 * Executes the child nodes in order until one fails or all succeed.
	 * If any child node fails, the sequence fails. Otherwise, it succeeds.
	 *
	 * @return {@code true} if all child nodes succeed, {@code false} if any child node fails
	 */
	@Override
	public boolean execute() {
		ArrayList<Node> children = getChildren();
		for (Node child : children) {
			if (child == null || !child.execute()) {
				return false; // If any child fails, the sequence fails
			}
		}
		return true; // All children succeeded
	}
}
