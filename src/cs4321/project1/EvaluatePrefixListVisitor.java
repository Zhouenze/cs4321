package cs4321.project1;

import java.util.Stack;
import java.util.Vector;

import javax.swing.Painter;

import cs4321.project1.list.*;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Your names and netids go here
 */

public class EvaluatePrefixListVisitor implements ListVisitor {

	private Stack<Double> operands;
	private Stack<Tuple> operators;
	
	public EvaluatePrefixListVisitor() {
		operands = new Stack<Double>(); 
		operators = new Stack<Tuple>(); 
	}

	public double getResult() {
		return operands.peek(); // so that skeleton code compiles
	}

	@Override
	public void visit(NumberListNode node) {
		operands.push(node.getData());
		
		if (!operators.empty()) {
			operators.peek().addCounter(-1);
		}
		else {
			return;
		}
		
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

	@Override
	public void visit(AdditionListNode node) {
		operators.push(new Tuple(2, '+'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	@Override
	public void visit(SubtractionListNode node) {
		operators.push(new Tuple(2, '-'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	@Override
	public void visit(MultiplicationListNode node) {
		operators.push(new Tuple(2, '*'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	@Override
	public void visit(DivisionListNode node) {

		operators.push(new Tuple(2, '/'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}

	@Override
	public void visit(UnaryMinusListNode node) {
		operators.push(new Tuple(1, '~'));
		if (node.getNext() != null) {
			node.getNext().accept(this);
		}
	}
	
}
