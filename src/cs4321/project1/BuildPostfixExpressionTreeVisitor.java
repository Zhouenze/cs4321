package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Your names and netids go here
 */
public class BuildPostfixExpressionTreeVisitor implements TreeVisitor {

	//dummy head node head
	private ListNode head;
	private ListNode current;

	public BuildPostfixExpressionTreeVisitor() {
		// TODO fill me in
		head = new NumberListNode(-1);
		current = head;
	}

	public ListNode getResult() {
		// TODO fill me in
		return head.getNext();
	}

	@Override
	public void visit(LeafTreeNode node) {
		current.setNext(new NumberListNode(node.getData()));
		current = current.getNext();
		
	}

	@Override
	public void visit(UnaryMinusTreeNode node) {
		node.getChild().accept(this);
		current.setNext(new UnaryMinusListNode());
		current = current.getNext();
	}

	@Override
	public void visit(AdditionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		current.setNext(new AdditionListNode());
		current = current.getNext();
	}

	@Override
	public void visit(MultiplicationTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		current.setNext(new MultiplicationListNode());
		current = current.getNext();
	}

	@Override
	public void visit(SubtractionTreeNode node) {
	
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		current.setNext(new SubtractionListNode());
		current = current.getNext();
	}

	@Override
	public void visit(DivisionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		current.setNext(new DivisionListNode());
		current = current.getNext();
	}

}
