package cs4321.project1;

import java.util.Stack;
import java.util.Vector;

import javax.swing.Painter;

import cs4321.project1.list.*;

/**
 * The algorithm follows what is suggested in the project writeup.
 * Two stacks are created. The operators are stored as Tuple. 
 * Tuple is a helper class created to represent the pair of values
 * operation type and number of operands needed.
 * 
 * @author Weicheng Yu wy248
 */


public class EvaluatePrefixListVisitor implements ListVisitor {

	private Stack<Double> operands;
	private Stack<Tuple> operators;
	
	/**
	* Constructor that initializes the two stacks
	*
	*
	*
	*/
	public EvaluatePrefixListVisitor() {
		operands = new Stack<Double>(); 
		operators = new Stack<Tuple>(); 
	}

	/**
	* Method to get the final result of expression
	*
	* @return the result of expression
	*
	*/
	public double getResult() {
		return operands.peek(); // so that skeleton code compiles
	}

	/**
	* Method to update stacks based on NumberListNode
	*
	* @param node
	*            node to be visited
	*/
	@Override
	public void visit(NumberListNode node) {
		operands.push(node.getData()); // push number to operand stack
		
		if (!operators.empty()) {
			operators.peek().addCounter(-1); // update operator's needed operands
		}
		else {
			return;
		}
		
		/*
		* The while loop keeps looking to update operator stack until there is
		* no more updates. In the same time, it carries out operations when the
		* an operator receives enough operands.
		*
		*/
		while (operators.peek().getCounter() == 0) {
			Tuple T = operators.pop();
			if (T.getInitCount() == 1) {
				operands.push(-1 * operands.pop());
			}
			else if (T.getOp() == '+') {
				
				operands.push(operands.pop() + operands.pop());
				
			}
			else if (T.getOp() == '*') {
				operands.push(operands.pop() * operands.pop());
			}
			
			else if (T.getOp() == '-') {
				double right = operands.pop();
				double left = operands.pop();
				operands.push(left - right);
			}
			else if (T.getOp() == '/') {
				double right = operands.pop();
				double left = operands.pop();
				operands.push(left / right);
			}
			if (!operators.empty()) {
				operators.peek().addCounter(-1);
				
			}
			else{
				return;
			}
		}
		
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	* Method to update stacks based on AdditionListNode
	*
	* @param node
	*            node to be visited
	*/
	@Override
	public void visit(AdditionListNode node) {
		operators.push(new Tuple(2, '+'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	* Method to update stacks based on SubtractionListNode
	*
	* @param node
	*            node to be visited
	*/
	@Override
	public void visit(SubtractionListNode node) {
		operators.push(new Tuple(2, '-'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	* Method to update stacks based on MultiplicationListNode
	*
	* @param node
	*            node to be visited
	*/
	@Override
	public void visit(MultiplicationListNode node) {
		operators.push(new Tuple(2, '*'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	* Method to update stacks based on DivisionListNode
	*
	* @param node
	*            node to be visited
	*/
	@Override
	public void visit(DivisionListNode node) {

		operators.push(new Tuple(2, '/'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	* Method to update stacks based on UnaryMinusListNode
	*
	* @param node
	*            node to be visited
	*/
	@Override
	public void visit(UnaryMinusListNode node) {
		operators.push(new Tuple(1, '~'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}
	
}
