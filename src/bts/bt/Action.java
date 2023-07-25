package bts.bt;

/**
 * The {@code Action} class represents an action node in a behavior tree.
 * It encapsulates a task to be executed when the node is executed.
 */
public class Action extends Node {

	private Task task;  // The task to be executed

	/**
	 * Constructs a new {@code Action} object with the specified name and task.
	 *
	 * @param name the name of the action node
	 * @param task the task to be executed when the action node is executed
	 */
	public Action(String name, Task task) {
		super(name);
		this.task = task;
	}

	@Override
	public boolean execute() {
		return task.apply(getName());
	}
}

