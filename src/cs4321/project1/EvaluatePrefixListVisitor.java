package cs4321.project1;

import java.util.Stack;

import cs4321.project1.list.*;

/**
 * Visitor to evaluate the prefix list to a single number
 * 
 * @author Shuang Zhang sz468
 */

public class EvaluatePrefixListVisitor implements ListVisitor {

	private Stack<Double> operand;
	private Stack<Pair> operator;
	
	/**
	 * Helper class to represent the pair of an operator node and the number of its remaining operands
	 * 
	 * @author D2Victoria
	 *
	 */
	private class Pair {
		private ListNode node;
		private int number;
		
		private Pair(ListNode node, int number) {
			this.node = node;
			this.number = number;
		}
		
		/*
		 * number getter:
		 * 		returns the value of number field
		 */
		private int getNumber() {
			return this.number;
		}
		
		/*
		 * node getter:
		 * 		returns the node in this pair
		 */
		private ListNode getNode() {
			return this.node;
		}
		
		/*
		 * number setter:
		 * 		decrements the value of number field
		 */
		private void decrementBy1() {
			this.number--;
		}
	}
	
	public EvaluatePrefixListVisitor() {
		// TODO fill me in
		operand = new Stack<Double>();
		operator = new Stack<Pair>();
	}

	/**
	 * Method to get the single number - list value - when visitor is done
	 * 
	 * @return numeric value of the visited list
	 */
	public double getResult() {
		// TODO fill me in
		return operand.pop(); // so that skeleton code compiles
	}

	/**
	 * Visit method for number node; pushes the numeric value to the operand stack,
	 * and updates the number of expected operands of the node in the top pair of the operator stack.
	 * If the top operator has all the operands it expects, pops it out of the stack and pushes the numeric value of operation to the operand stack
	 * repeat the above unless the operator stack is empty
	 * 
	 * and recursively visits the rest of the list
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(NumberListNode node) {
		// TODO fill me in
		operand.push(node.getData());
		while (!operator.isEmpty()) {
			operator.peek().decrementBy1();
			if(operator.peek().getNumber() != 0) {
				break;
			}
			ListNode operatorNode = operator.pop().getNode();
			if(operatorNode instanceof UnaryMinusListNode) {
				double b = operand.pop();
				operand.push(-1 * b);
			} else { 
				double b = operand.pop();
				double a = operand.pop();
				
				if (operatorNode instanceof AdditionListNode) {
					operand.push(a + b);
				} else if (operatorNode instanceof SubtractionListNode) {
					operand.push(a - b);
				} else if (operatorNode instanceof MultiplicationListNode) {
					operand.push(a * b);
				} else if (operatorNode instanceof DivisionListNode) {
					operand.push(a / b);
				}
				
			}
		}
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for addition node; initializes the pair with the addition node
	 * and pushes the pair to the operator stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(AdditionListNode node) {
		// TODO fill me in
		operator.push(new Pair(node, 2));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for subtraction node; initializes the pair with the subtraction node
	 * and pushes the pair to the operator stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(SubtractionListNode node) {
		// TODO fill me in
		operator.push(new Pair(node, 2));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for multiplication node; initializes the pair with the multiplication node
	 * and pushes the pair to the operator stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(MultiplicationListNode node) {
		// TODO fill me in
		operator.push(new Pair(node, 2));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for division node; initializes the pair with the division node
	 * and pushes the pair to the operator stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(DivisionListNode node) {
		// TODO fill me in
		operator.push(new Pair(node, 2));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}
	
	/**
	 * Visit method for unary minus node; initializes the pair with the unary minus node
	 * and pushes the pair to the operator stack,
	 * and recursively visits the rest of the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(UnaryMinusListNode node) {
		// TODO fill me in
		operator.push(new Pair(node, 1));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}
}
