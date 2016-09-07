package cs4321.project1;

import java.util.Stack;

import cs4321.project1.list.DivisionListNode;
import cs4321.project1.list.SubtractionListNode;
import cs4321.project1.list.NumberListNode;
import cs4321.project1.list.AdditionListNode;
import cs4321.project1.list.MultiplicationListNode;
import cs4321.project1.list.UnaryMinusListNode;

/**
 * Visitor to evaluate the postfix list to a single number
 * 
 * @author Shuang Zhang sz468
 */
public class EvaluatePostfixListVisitor implements ListVisitor {

	private Stack<Double> stack;
	
	public EvaluatePostfixListVisitor() {
		// TODO fill me in
		stack = new Stack<Double>();
	}

	/**
	 * Method to get the single number - list value - when visitor is done
	 * 
	 * @return numeric value of the visited list
	 */
	public double getResult() {
		// TODO fill me in
		return stack.pop(); // so that skeleton code compiles
	}

	/**
	 * Visit method for number node; pushes the numeric value to the running stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(NumberListNode node) {
		// TODO fill me in
		stack.push(node.getData());
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for addition node; pops the two operands of the addition operation from the stack,
	 * pushes the sum to the running stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(AdditionListNode node) {
		// TODO fill me in
		double b = stack.pop(); // input is assumed valid
		double a = stack.pop();
		stack.push(a + b);
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for subtraction node; pops the two operands of the subtraction operation from the stack,
	 * pushes the difference to the running stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(SubtractionListNode node) {
		// TODO fill me in
		double b = stack.pop(); // input is assumed valid
		double a = stack.pop();
		stack.push(a - b);
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for multiplication node; pops the two operands of the multiplication operation from the stack,
	 * pushes the product to the running stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(MultiplicationListNode node) {
		// TODO fill me in
		double b = stack.pop(); // input is assumed valid
		double a = stack.pop();
		stack.push(a * b);
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for division node; pops the two operands of the division operation from the stack,
	 * pushes the quotient to the running stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(DivisionListNode node) {
		// TODO fill me in
		double b = stack.pop(); // input is assumed valid
		double a = stack.pop();
		stack.push(a / b);
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for unary minus node; pops the operand of the unary minus operation from the stack,
	 * pushes the opposite to the running stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(UnaryMinusListNode node) {
		// TODO fill me in
		double b = stack.pop();
		stack.push(-1 * b);
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

}
