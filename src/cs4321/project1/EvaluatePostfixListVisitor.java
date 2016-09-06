package cs4321.project1;

import cs4321.project1.list.DivisionListNode;
import cs4321.project1.list.SubtractionListNode;
import cs4321.project1.list.NumberListNode;

import java.util.Stack;

import cs4321.project1.list.AdditionListNode;
import cs4321.project1.list.MultiplicationListNode;
import cs4321.project1.list.UnaryMinusListNode;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Your names and netids go here
 */
public class EvaluatePostfixListVisitor implements ListVisitor {

	private Stack<Double> operation;
	
	public EvaluatePostfixListVisitor() {
		operation = new Stack<Double>();
	}

	public double getResult() {
		return operation.peek();
	}

	@Override
	public void visit(NumberListNode node) {
		// TODO fill me in
		operation.push(node.getData());
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	@Override
	public void visit(AdditionListNode node) {
		operation.push(operation.pop() + operation.pop());
		if (node.getNext() != null){
			node.getNext().accept(this);
		}
		
	}

	@Override
	public void visit(SubtractionListNode node) {
		double right = operation.pop();
		double left = operation.pop();
		
		operation.push(left - right);
		if (node.getNext() != null){
			node.getNext().accept(this);
		}
		
	}

	@Override
	public void visit(MultiplicationListNode node) {
		operation.push(operation.pop() * operation.pop());
		if (node.getNext() != null){
			node.getNext().accept(this);
		}
		
	}

	@Override
	public void visit(DivisionListNode node) {
		double right = operation.pop();
		double left = operation.pop();
		
		operation.push(left / right);
		if (node.getNext() != null){
			node.getNext().accept(this);
		}
	}

	@Override
	public void visit(UnaryMinusListNode node) {
		operation.push(operation.pop() * -1);
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

}
