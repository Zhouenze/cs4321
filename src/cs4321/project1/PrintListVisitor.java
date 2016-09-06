package cs4321.project1;

import cs4321.project1.list.*;

/**
 * Visitor to print a list expression
 * 
 * @author Shuang Zhang sz468
 */

public class PrintListVisitor implements ListVisitor {
	
	private String result;
	

	public PrintListVisitor() {
		// TODO fill me in
		result = "";
	}

	/**
	 * Method to get the finished string representation when visitor is done
	 * 
	 * @return string representation of the visited list
	 */
	public String getResult() {
		// TODO fill me in
		return result;
	}

	/**
	 * Visit method for number node; recursively visits the rest of the list
	 * and concatenates the string representation of the rest to that of this node,
	 * and sets the concatenation as the result
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(NumberListNode node) {
		// TODO fill me in
		String rest = "";
		if (node.getNext() != null) {
			node.getNext().accept(this);
			rest = " " + this.getResult();
		}
		result = node.getData() + rest;
	}

	/**
	 * Visit method for addition node; recursively visits the rest of the list
	 * and concatenates the string representation of the rest to that of this node,
	 * and sets the concatenation as the result
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(AdditionListNode node) {
		// TODO fill me in
		String rest = "";
		if (node.getNext() != null) {
			node.getNext().accept(this);
			rest = " " + this.getResult();
		}
		result = "+" + rest;
	}

	/**
	 * Visit method for subtraction node; recursively visits the rest of the list
	 * and concatenates the string representation of the rest to that of this node,
	 * and sets the concatenation as the result
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(SubtractionListNode node) {
		// TODO fill me in
		String rest = "";
		if (node.getNext() != null) {
			node.getNext().accept(this);
			rest = " " + this.getResult();
		}
		result = "-" + rest;
	}

	/**
	 * Visit method for multiplication node; recursively visits the rest of the list
	 * and concatenates the string representation of the rest to that of this node,
	 * and sets the concatenation as the result
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(MultiplicationListNode node) {
		// TODO fill me in
		String rest = "";
		if (node.getNext() != null) {
			node.getNext().accept(this);
			rest = " " + this.getResult();
		}
		result = "*" + rest;
	}

	/**
	 * Visit method for division node; recursively visits the rest of the list
	 * and concatenates the string representation of the rest to that of this node,
	 * and sets the concatenation as the result
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(DivisionListNode node) {
		// TODO fill me in
		String rest = "";
		if (node.getNext() != null) {
			node.getNext().accept(this);
			rest = " " + this.getResult();
		}
		result = "/" + rest;
	}

	/**
	 * Visit method for unary minus node; recursively visits the rest of the list
	 * and concatenates the string representation of the rest to that of this node,
	 * and sets the concatenation as the result
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(UnaryMinusListNode node) {
		// TODO fill me in
		String rest = "";
		if (node.getNext() != null) {
			node.getNext().accept(this);
			rest = " " + this.getResult();
		}
		result = "~" + rest;
	}

}
