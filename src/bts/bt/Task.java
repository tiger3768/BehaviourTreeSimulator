package bts.bt;

/**
 * The {@code Task} functional interface represents a task to be executed by a behavior tree node.
 * It defines a single method for applying the task.
 */
@FunctionalInterface
public interface Task {

	/**
	 * Applies the task with the given input.
	 *
	 * @param s the input for the task
	 * @return {@code true} if the task is successful, {@code false} otherwise
	 */
	boolean apply(String s);
}

