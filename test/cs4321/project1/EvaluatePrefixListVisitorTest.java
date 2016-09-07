package cs4321.project1;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.list.*;

public class EvaluatePrefixListVisitorTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void testSingleNumberNode() {
		ListNode n1 = new NumberListNode(1.0);
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n1.accept(v1);
		assertEquals(1.0, v1.getResult(), DELTA);
	}

	@Test
	public void testAdditionSimple() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new AdditionListNode();
		n3.setNext(n2);
		n2.setNext(n1);
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n3.accept(v1);
		assertEquals(3.0, v1.getResult(), DELTA);
		
		ListNode n4 = new NumberListNode(1.0);
		ListNode n5 = new NumberListNode(2.0);
		ListNode n6 = new AdditionListNode();
		n6.setNext(n4);
		n4.setNext(n5); // expression: + 1.0 2.0
		EvaluatePrefixListVisitor v2 = new EvaluatePrefixListVisitor();
		n6.accept(v2);
		assertEquals(3.0, v2.getResult(), DELTA);
	}
	
	@Test
	public void testAdditionMultipleInstances() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new AdditionListNode();
		ListNode n4 = new NumberListNode(3.0);
		ListNode n5 = new AdditionListNode();
		n5.setNext(n4);
		n4.setNext(n3);
		n3.setNext(n2);
		n2.setNext(n1);
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n5.accept(v1);
		assertEquals(6.0, v1.getResult(), DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testSubtractionSimple() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new SubtractionListNode();
		n3.setNext(n2);
		n2.setNext(n1); // expression: - 2.0 1.0
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n3.accept(v1);
		assertEquals(1.0, v1.getResult(), DELTA);
		
		ListNode n4 = new NumberListNode(1.0);
		ListNode n5 = new NumberListNode(2.0);
		ListNode n6 = new SubtractionListNode();
		n6.setNext(n4);
		n4.setNext(n5); // expression: - 1.0 2.0
		EvaluatePrefixListVisitor v2 = new EvaluatePrefixListVisitor();
		n6.accept(v2);
		assertEquals(-1.0, v2.getResult(), DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testSubtractionMultipleInstances() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new SubtractionListNode();
		ListNode n4 = new NumberListNode(3.0);
		ListNode n5 = new SubtractionListNode();
		n5.setNext(n4);
		n4.setNext(n3);
		n3.setNext(n2);
		n2.setNext(n1); // expression: - 3.0 - 2.0 1.0
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n5.accept(v1);
		assertEquals(2.0, v1.getResult(), DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testMultiplicationSimple() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new MultiplicationListNode();
		n3.setNext(n2);
		n2.setNext(n1); // expression: * 2.0 1.0
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n3.accept(v1);
		assertEquals(2.0, v1.getResult(), DELTA);
		
		ListNode n4 = new NumberListNode(1.0);
		ListNode n5 = new NumberListNode(2.0);
		ListNode n6 = new MultiplicationListNode();
		n6.setNext(n4);
		n4.setNext(n5); // expression: * 1.0 2.0
		EvaluatePrefixListVisitor v2 = new EvaluatePrefixListVisitor();
		n6.accept(v2);
		assertEquals(2.0, v2.getResult(), DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testMultiplicationMultipleInstances() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new MultiplicationListNode();
		ListNode n4 = new NumberListNode(3.0);
		ListNode n5 = new MultiplicationListNode();
		n5.setNext(n4);
		n4.setNext(n3);
		n3.setNext(n2);
		n2.setNext(n1); // expression: * 3.0 * 2.0 1.0
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n5.accept(v1);
		assertEquals(6.0, v1.getResult(), DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testDivisionSimple() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new DivisionListNode();
		n3.setNext(n2);
		n2.setNext(n1); // expression: / 2.0 1.0
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n3.accept(v1);
		assertEquals(2.0, v1.getResult(), DELTA);
		
		ListNode n4 = new NumberListNode(1.0);
		ListNode n5 = new NumberListNode(2.0);
		ListNode n6 = new DivisionListNode();
		n6.setNext(n4);
		n4.setNext(n5); // expression: / 1.0 2.0
		EvaluatePrefixListVisitor v2 = new EvaluatePrefixListVisitor();
		n6.accept(v2);
		assertEquals(0.5, v2.getResult(), DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testDivisionMultipleInstances() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new DivisionListNode();
		ListNode n4 = new NumberListNode(3.0);
		ListNode n5 = new DivisionListNode();
		n5.setNext(n4);
		n4.setNext(n3);
		n3.setNext(n2);
		n2.setNext(n1); // expression: / 3.0 / 2.0 1.0
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n5.accept(v1);
		assertEquals(1.5, v1.getResult(), DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testUnaryMinusNode() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new UnaryMinusListNode();
		n2.setNext(n1);
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n2.accept(v1);
		assertEquals(-1.0, v1.getResult(), DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testUnaryMinusMultipleInstances() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new UnaryMinusListNode();
		ListNode n3 = new UnaryMinusListNode();
		n3.setNext(n2);
		n2.setNext(n1); // expression is ~ ~ 1
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n3.accept(v1);
		assertEquals(1.0, v1.getResult(), DELTA);
	}
	
	/**
	 * Shuang Zhang sz468
	 */
	@Test
	public void testMultiOperator() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(3.0);
		ListNode n3 = new AdditionListNode();
		ListNode n4 = new NumberListNode(2.0);
		ListNode n5 = new UnaryMinusListNode();
		ListNode n6 = new MultiplicationListNode();
		n6.setNext(n5);
		n5.setNext(n4);
		n4.setNext(n3);
		n3.setNext(n2);
		n2.setNext(n1); // expression: * ~ 2 + 3 1
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n6.accept(v1);
		assertEquals(-8.0, v1.getResult(), DELTA);
	}

}
