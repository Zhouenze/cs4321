package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * Visitor to build a prefix expression list out of the given tree
 * 
 * @author Shuang Zhang sz468
 */
public class BuildPrefixExpressionTreeVisitor implements TreeVisitor {
	
	private ListNode dummy;
	private ListNode tail;

	public BuildPrefixExpressionTreeVisitor() {
		// TODO fill me in
		dummy = new DivisionListNode();
		tail = dummy;
	}

	/**
	 * Method to get the finished prefix list representation when visitor is done
	 * 
	 * @return head node of prefix list representation of the visited tree
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
	 * Visit method for unary minus node; concatenates the unary minus list node to 
	 * the tail of the running list,
	 * and recursively visits its subtree
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(UnaryMinusTreeNode node) {
		// TODO fill me in
		UnaryMinusListNode unaryminus = new UnaryMinusListNode();
		tail.setNext(unaryminus);
		tail = unaryminus;
		node.getChild().accept(this);
		
	}

	/**
	 * Visit method for addition node based on preorder traversal
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(AdditionTreeNode node) {
		// TODO fill me in
		AdditionListNode addition = new AdditionListNode();
		tail.setNext(addition);
		tail = addition;
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
	}

	/**
	 * Visit method for multiplication node based on preorder traversal
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(MultiplicationTreeNode node) {
		// TODO fill me in
		MultiplicationListNode multiplication = new MultiplicationListNode();
		tail.setNext(multiplication);
		tail = multiplication;
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
	}

	/**
	 * Visit method for subtraction node based on preorder traversal
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(SubtractionTreeNode node) {
		// TODO fill me in
		SubtractionListNode subtraction = new SubtractionListNode();
		tail.setNext(subtraction);
		tail = subtraction;
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
	}

	/**
	 * Visit method for division node based on preorder traversal
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(DivisionTreeNode node) {
		// TODO fill me in
		DivisionListNode division = new DivisionListNode();
		tail.setNext(division);
		tail = division;
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
	}

}
