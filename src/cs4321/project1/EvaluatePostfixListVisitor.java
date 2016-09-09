package cs4321.project1;

import cs4321.project1.list.DivisionListNode;
import cs4321.project1.list.SubtractionListNode;
import cs4321.project1.list.NumberListNode;

import java.util.Stack;

import cs4321.project1.list.AdditionListNode;
import cs4321.project1.list.MultiplicationListNode;
import cs4321.project1.list.UnaryMinusListNode;

/**
 * Evaluate postfix list using a single stack. 
 * The general algorithm is when we encounter number nodes, we push
 * it to the stack operation. When we encounter an operator, we pop 
 * the corresponding number of values of the stack and push the result 
 * back into stack. The final result in stack is the value of expression
 *
 * @author Weicheng Yu wy248
 */
public class EvaluatePostfixListVisitor implements ListVisitor {

	private Stack<Double> operation; // stack to keep track of numbers so far
	
	/**
	 * Constructor that initializes stack
	 * 
	 * 
	 */
	public EvaluatePostfixListVisitor() {
		operation = new Stack<Double>();
	}

	/**
	 * Method to get the final result of expression
	 * 
	 * @return the value of the whole expression
	 */
	public double getResult() {
		return operation.peek();
	}

	/**
	 * Method to handle NumberListNode 
	 * 
	 * @param node
	 */
	@Override
	public void visit(NumberListNode node) {
		operation.push(node.getData());
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	/**
	 * Method to handle AdditionListNode
	 * 
	 * @param node
	 */
	@Override
	public void visit(AdditionListNode node) {
		operation.push(operation.pop() + operation.pop());
		if (node.getNext() != null){
			node.getNext().accept(this);
		}
		
	}

	/**
	 * Method to handle SubtractionListNode 
	 * 
	 * @param node
	 */
	@Override
	public void visit(SubtractionListNode node) {
		double right = operation.pop();
		double left = operation.pop();
		
		operation.push(left - right);
		if (node.getNext() != null){
			node.getNext().accept(this);
		}
		
	}

	/**
	 * Method to handle MultiplicationListNode 
	 * 
	 * @param node
	 */
	@Override
	public void visit(MultiplicationListNode node) {
		operation.push(operation.pop() * operation.pop());
		if (node.getNext() != null){
			node.getNext().accept(this);
		}
		
	}

	/**
	 * Method to handle DivisionListNode 
	 * 
	 * @param node
	 */
	@Override
	public void visit(DivisionListNode node) {
		double right = operation.pop();
		double left = operation.pop();
		
		operation.push(left / right);
		if (node.getNext() != null){
			node.getNext().accept(this);
		}
	}

	/**
	 * Method to handle UnaryMinusListNode 
	 * 
	 * @param node
	 */
	@Override
	public void visit(UnaryMinusListNode node) {
		operation.push(operation.pop() * -1);
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

}
