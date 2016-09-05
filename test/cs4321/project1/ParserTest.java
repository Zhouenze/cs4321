package cs4321.project1;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.tree.TreeNode;

public class ParserTest {

	/*
	 * This class depends on the correct functioning of PrintTreeVisitor(), which is provided for you.
	 */
			
	@Test
	public void testSingleNumber() {
		Parser p1 = new Parser("1.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);
		assertEquals("1.0", v1.getResult());

	}
	
	@Test
	public void testUnaryMinusSimple() {
		Parser p1 = new Parser("- 1.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);
		assertEquals("(-1.0)", v1.getResult());

	}
	
	@Test
	public void testUnaryMinusComplex() {
		Parser p1 = new Parser("- - 1.0");
		TreeNode parseResult1 =  p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);
		assertEquals("(-(-1.0))", v1.getResult());

	}

	@Test
	public void additionalTest1() {
		Parser p1 = new Parser("( 1.0 ) + ( 2.0 - 3.0 * ( 4.5 / - 6.0 ) - - - 7.0 )");
		TreeNode parseResult1 =  p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);
		assertEquals("(1.0+((2.0-(3.0*(4.5/(-6.0))))-(-(-7.0))))", v1.getResult());

	}
	
	@Test
	public void additionalTest2() {
		Parser p1 = new Parser("( 1.0 + 2.0 ) * ( 3.0 / 4.0 ) + - - - 5.0 * ( 6.0 - - 9.0 )");
		TreeNode parseResult1 =  p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);
		assertEquals("(((1.0+2.0)*(3.0/4.0))+((-(-(-5.0)))*(6.0-(-9.0))))", v1.getResult());

	}
}
