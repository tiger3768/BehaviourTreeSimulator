package bts.bt;

import java.util.ArrayList;

/**
 * The {@code Node} class represents a node in a behavior tree.
 * It can have child nodes and provides basic methods for adding nodes and executing the node's behavior.
 */
public class Node {

	private String name;                // The name of the node
	private ArrayList<Node> children;   // The list of child nodes

	/**
	 * Constructs a new {@code Node} object with the specified name and no initial child nodes.
	 *
	 * @param n the name of the node
	 */
	public Node(String n) {
		this.name = n;
		children = new ArrayList<>();
	}

	/**
	 * Constructs a new {@code Node} object with the specified name and initial child nodes.
	 *
	 * @param n     the name of the node
	 * @param nodes the initial child nodes
	 */
	public Node(String n, Node... nodes) {
		this.name = n;
		children = new ArrayList<>();
		for (Node node : nodes) {
			children.add(node);
		}
	}

	/**
	 * Adds a child node to this node.
	 *
	 * @param n the child node to add
	 */
	public void add(Node n) {
		if (children == null) {
			return;
		}
		children.add(n);
	}

	/**
	 * Returns the name of the node.
	 *
	 * @return the name of the node
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the list of child nodes.
	 *
	 * @return the list of child nodes
	 */
	public ArrayList<Node> getChildren() {
		return children;
	}

	/**
	 * Executes the behavior associated with the node.
	 * This method is intended to be overridden by subclasses to provide specific behavior.
	 *
	 * @return {@code true} if the execution of the node is successful, {@code false} otherwise
	 */
	public boolean execute() {
		return true;
	}
}
