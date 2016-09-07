package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * Visitor to build a postfix expression list out of the given tree
 * 
 * @author Shuang Zhang sz468
 */
public class BuildPostfixExpressionTreeVisitor implements TreeVisitor {

	private ListNode dummy;
	private ListNode tail;

	public BuildPostfixExpressionTreeVisitor() {
		// TODO fill me in
		dummy = new DivisionListNode();
		tail = dummy;
	}

	/**
	 * Method to get the finished postfix list representation when visitor is done
	 * 
	 * @return head node of postfix list representation of the visited tree
	 */
	public ListNode getResult() {
		// TODO fill me in
		return dummy.getNext();
	}

	/**
	 * Visit method for leaf node; just converts the leaf tree node to a number list node,
	 * and concatenates the number list node to
	 * the tail of the running list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(LeafTreeNode node) {
		// TODO fill me in
		NumberListNode leaf = new NumberListNode(node.getData());
		tail.setNext(leaf);
		// update tail
		tail = leaf;
	}

	/**
	 * Visit method for unary minus node; recursively visits its subtree,
	 * and concatenates the unary minus list node to 
	 * the tail of the running list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(UnaryMinusTreeNode node) {
		// TODO fill me in
		node.getChild().accept(this);
		UnaryMinusListNode unarymius = new UnaryMinusListNode();
		tail.setNext(unarymius);
		tail = unarymius;
	}

	/**
	 * Visit method for addition node based on postorder traversal
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(AdditionTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		AdditionListNode addition = new AdditionListNode();
		tail.setNext(addition);
		tail = addition;
	}

	/**
	 * Visit method for multiplication node based on postorder traversal
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(MultiplicationTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		MultiplicationListNode multiplication = new MultiplicationListNode();
		tail.setNext(multiplication);
		tail = multiplication;
	}

	/**
	 * Visit method for subtraction node based on postorder traversal
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(SubtractionTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		SubtractionListNode subtraction = new SubtractionListNode();
		tail.setNext(subtraction);
		tail = subtraction;
	}

	/**
	 * Visit method for division node based on postorder traversal
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(DivisionTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		DivisionListNode division = new DivisionListNode();
		tail.setNext(division);
		tail = division;
	}

}
