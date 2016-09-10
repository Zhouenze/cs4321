package cs4321.project1;

import java.util.Stack;

import cs4321.project1.tree.DivisionTreeNode;
import cs4321.project1.tree.LeafTreeNode;
import cs4321.project1.tree.SubtractionTreeNode;
import cs4321.project1.tree.AdditionTreeNode;
import cs4321.project1.tree.MultiplicationTreeNode;
import cs4321.project1.tree.UnaryMinusTreeNode;

/**
 * Visitor to evaluate the tree to a single number
 * 
 * @author Shuang Zhang sz468
 */

public class EvaluateTreeVisitor implements TreeVisitor {

	private Stack<Double> stack;
	public EvaluateTreeVisitor() {
		// TODO fill me in
		stack = new Stack<Double>();
	}

	/**
	 * Method to get the single number - tree value - when visitor is done
	 * 
	 * @return numeric value of the visited tree
	 */
	public double getResult() {
		// TODO fill me in
		return stack.pop(); // so that skeleton code compiles
	}

	/**
	 * Visit method for leaf node; just pushes the numeric value to the
	 * running stack
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(LeafTreeNode node) {
		// TODO fill me in
		stack.push(node.getData());
	}

	/**
	 * Visit method for unary minus node; recursively visits subtree,
	 * pops the result and multiplies it with -1, pushes the final result to
	 * running stack
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(UnaryMinusTreeNode node) {
		// TODO fill me in
		node.getChild().accept(this);
		stack.push(-1 * this.getResult());
	}

	/**
	 * Visit method for addition node; does the postorder traversal,
	 * which ends up with pushing the sum of results of left and right subtree visits
	 * to the running stack
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(AdditionTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		double right = stack.pop();
		double left = stack.pop();
		stack.push(left + right);
	}

	/**
	 * Visit method for multiplication node; does the postorder traversal,
	 * which ends up with pushing the product of results of left and right subtree visits
	 * to the running stack
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(MultiplicationTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		double right = stack.pop();
		double left = stack.pop();
		stack.push(left * right);
	}

	/**
	 * Visit method for subtraction node; does the postorder traversal,
	 * which ends up with pushing the difference of results of left and right subtree visits
	 * to the running stack
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(SubtractionTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		double right = stack.pop();
		double left = stack.pop();
		stack.push(left - right);
	}

	/**
	 * Visit method for division node; does the postorder traversal,
	 * which ends up with pushing the quotient of results of left and right subtree visits
	 * to the running stack
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(DivisionTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		double right = stack.pop();
		double left = stack.pop();
		stack.push(left / right);
	}
}
