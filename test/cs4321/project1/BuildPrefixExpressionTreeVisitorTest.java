package cs4321.project1;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.tree.*;
import cs4321.project1.list.*;

public class BuildPrefixExpressionTreeVisitorTest {

	private static final double DELTA = 1e-15;

	@Test
	public void testSingleLeafNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n1.accept(v1);
		ListNode result = v1.getResult();
		assertNull(result.getNext());
		assertTrue(result instanceof NumberListNode);
	}
	
	@Test
	public void testAdditionNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new AdditionTreeNode(n1, n2);
		TreeNode n4 = new AdditionTreeNode(n2, n1);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n3.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof AdditionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		
		
        BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		n4.accept(v2);
		result = v2.getResult();
		assertTrue(result instanceof AdditionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
	}
	
	@Test
	public void testUnaryMinusNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new UnaryMinusTreeNode(n1);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n2.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof UnaryMinusListNode);
		ListNode first = result.getNext();
		assertTrue(first instanceof NumberListNode);
		assertEquals(((NumberListNode) first).getData(), 1.0, DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testUnaryMinusMultipleInstances() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new UnaryMinusTreeNode(n1);
		TreeNode n3 = new UnaryMinusTreeNode(n2);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n3.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof UnaryMinusListNode);
		ListNode first = result.getNext();
		assertTrue(first instanceof UnaryMinusListNode);
		ListNode second = first.getNext();
		assertTrue(second instanceof NumberListNode);
		assertEquals(((NumberListNode) second).getData(), 1.0, DELTA);
	}
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testMultiplicationNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new MultiplicationTreeNode(n1, n2);
		TreeNode n4 = new MultiplicationTreeNode(n2, n1);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n3.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof MultiplicationListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		
		
        BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		n4.accept(v2);
		result = v2.getResult();
		assertTrue(result instanceof MultiplicationListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testSubtractionNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new SubtractionTreeNode(n1, n2);
		TreeNode n4 = new SubtractionTreeNode(n2, n1);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n3.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof SubtractionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		
		
        BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		n4.accept(v2);
		result = v2.getResult();
		assertTrue(result instanceof SubtractionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testDivisionNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new DivisionTreeNode(n1, n2);
		TreeNode n4 = new DivisionTreeNode(n2, n1);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n3.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof DivisionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		
		
        BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		n4.accept(v2);
		result = v2.getResult();
		assertTrue(result instanceof DivisionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testCompositeNodes() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(3.0);
		TreeNode n3 = new AdditionTreeNode(n2, n1);
		TreeNode n4 = new LeafTreeNode(2.0);
		TreeNode n5 = new UnaryMinusTreeNode(n4);
		TreeNode n6 = new MultiplicationTreeNode(n5, n3);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n6.accept(v1);
		ListNode result = v1.getResult(); // *
		assertTrue(result instanceof MultiplicationListNode);
		result = result.getNext(); // ~
		assertTrue(result instanceof UnaryMinusListNode);
		result = result.getNext(); // 2.0
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		result = result.getNext(); // +
		assertTrue(result instanceof AdditionListNode);
		result = result.getNext();// 3.0
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 3.0, DELTA);
		result = result.getNext();// 1.0
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
	}

}