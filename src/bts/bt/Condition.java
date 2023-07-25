package bts.bt;

/**
 * The {@code Condition} class represents a condition node in a behavior tree.
 * It executes a task to determine whether the condition is satisfied or not.
 */
public class Condition extends Node {

	private Task task;  // The task to be executed for the condition

	/**
	 * Constructs a new {@code Condition} object with the specified name and task.
	 *
	 * @param name the name of the condition node
	 * @param task the task to be executed for the condition
	 */
	public Condition(String name, Task task) {
		super(name);
		this.task = task;
	}
	
	/**
	 * Executes the task associated with the condition and returns the result.
	 * 
	 * @return {@code true} if the condition is satisfied, {@code false} otherwise
	 */
	@Override
	public boolean execute() {
	    return task.apply(getName());
	}
}
