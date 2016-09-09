package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * There are two variables head and current that I use to keep building
 * the tree. The head is used to return a Linked List representation. 
 * The current ListNode is used to keep building the tail of the linked list
 * The general algorithm is to build the current node recursively based on 
 * its type. 
 * @author Weicheng Yu wy248
 */
public class BuildPostfixExpressionTreeVisitor implements TreeVisitor {

	
	private ListNode head; // dummy head node head
	private ListNode current; // tail node

	/**
	* Constructor that initializes head and current variables
	*
	*
	*/
	public BuildPostfixExpressionTreeVisitor() {
		
		head = new NumberListNode(-1); // dummy head
		current = head;
	}

	/**
	* Method to get the Linked List representation
	*
	*@return head of the Linked List
	*/
	public ListNode getResult() {
		return head.getNext();
	}

	/**
	* Method to update current based on LeafTreeNode
	*
	* @param node
	*			 the node to be visited
	*/	
	@Override
	public void visit(LeafTreeNode node) {
		current.setNext(new NumberListNode(node.getData()));
		current = current.getNext();
		
	}

	/**
	* Method to update current based on UnaryMinusTreeNode
	*
	* @param node
	*			 the node to be visited
	*/	
	@Override
	public void visit(UnaryMinusTreeNode node) {
		node.getChild().accept(this);
		current.setNext(new UnaryMinusListNode());
		current = current.getNext();
	}

	/**
	* Method to update current based on AdditionTreeNode
	*
	* @param node
	*			 the node to be visited
	*/	
	@Override
	public void visit(AdditionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		current.setNext(new AdditionListNode());
		current = current.getNext();
	}

	/**
	* Method to update current based on MultiplicationTreeNode
	*
	* @param node
	*			 the node to be visited
	*/	
	@Override
	public void visit(MultiplicationTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		current.setNext(new MultiplicationListNode());
		current = current.getNext();
	}

	/**
	* Method to update current based on SubtractionTreeNode
	*
	* @param node
	*			 the node to be visited
	*/	
	@Override
	public void visit(SubtractionTreeNode node) {
	
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		current.setNext(new SubtractionListNode());
		current = current.getNext();
	}

	/**
	* Method to update current based on DivisionTreeNode
	*
	* @param node
	*			 the node to be visited
	*/			 
	@Override
	public void visit(DivisionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		current.setNext(new DivisionListNode());
		current = current.getNext();
	}

}
