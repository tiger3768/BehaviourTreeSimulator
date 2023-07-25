package bts.bt;

import java.util.List;

/**
 * The {@code Loop} class represents a loop node in a behavior tree.
 * It repeatedly executes its child nodes as long as the condition node evaluates to true.
 */
public class Loop extends Node {

	/**
	 * Constructs a new {@code Loop} object with the specified name.
	 *
	 * @param name the name of the loop node
	 */
	public Loop(String name) {
		super(name);
	}

	/**
	 * Constructs a new {@code Loop} object with the specified name and child nodes.
	 *
	 * @param name    the name of the loop node
	 * @param children the child nodes of the loop
	 */
	public Loop(String name, Node... children) {
		super(name, children);
	}

	/**
	 * Executes the loop by repeatedly executing its child nodes as long as the condition node evaluates to true.
	 * The loop body must contain at least 2 children: a condition node at index 0 and the rest are loop body nodes.
	 *
	 * @return {@code true} if the loop completes successfully, {@code false} if the loop body is invalid
	 */
	@Override
	public boolean execute() {
		List<Node> children = getChildren();

		if (children.size() < 2) {
			System.out.println("Loop body must contain at least 2 children");
			return false;
		}

		Condition condition = (Condition) children.get(0);

		while (condition.execute()) {
			for (int i = 1; i < children.size(); i++) {
				children.get(i).execute();
			}
		}

		return true;
	}
}
