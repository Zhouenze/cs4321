package cs4321.project1;

import cs4321.project1.tree.*;

/**
 * Class for a parser that can parse a string and produce an expression tree. To
 * keep the code simple, this does no input checking whatsoever so it only works
 * on correct input.
 * 
 * An expression is one or more terms separated by + or - signs. A term is one
 * or more factors separated by * or / signs. A factor is an expression in
 * parentheses (), a factor with a unary - before it, or a number.
 * 
 * @author Lucja Kot
 * @author Shuang Zhang sz468
 */
public class Parser {

	private String[] tokens;
	private int currentToken; // pointer to next input token to be processed

	/**
	 * @precondition input represents a valid expression with all tokens
	 *               separated by spaces, e.g. "3.0 - ( 1.0 + 2.0 ) / - 5.0. All
	 *               tokens must be either numbers that parse to Double, or one
	 *               of the symbols +, -, /, *, ( or ), and all parentheses must
	 *               be matched and properly nested.
	 */
	public Parser(String input) {
		this.tokens = input.split("\\s+");
		currentToken = 0;
	}

	/**
	 * Parse the input and build the expression tree
	 * 
	 * @return the (root node of) the resulting tree
	 */
	public TreeNode parse() {
		return expression();
	}

	/**
	 * Parse the remaining input as far as needed to get the next factor
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode factor() {

		// TODO fill me in
		/*
		 * F := (E) | F | number
		 */
		TreeNode result;
		if(tokens[currentToken].equals("-")) { // -F
			currentToken++;
			result = factor();
			result = new UnaryMinusTreeNode(result);
		} else if (tokens[currentToken].equals("(")) { // (E)
			currentToken++; // consume (
			result = expression();
			currentToken++; // consume )
			
		} else { // number
			result = new LeafTreeNode(Double.valueOf(tokens[currentToken]));
			currentToken++;
		}
		
		
		return result;
	}

	/**
	 * Parse the remaining input as far as needed to get the next term
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode term() {

		// TODO fill me in
		/*
		 * T := F {{* | /} F}*
		 */
		TreeNode result = factor();
		while (currentToken < tokens.length && (tokens[currentToken].equals("*") || tokens[currentToken].equals("/"))) {
			String current = tokens[currentToken];
			currentToken++;
			TreeNode result2 = factor();
			result = current.equals("*") ? new MultiplicationTreeNode(result, result2) : new DivisionTreeNode(result, result2);
		}
		
		return result;

	}

	/**
	 * Parse the remaining input as far as needed to get the next expression
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode expression() {

		// TODO fill me in
		/*
		 * E := T {{+|-} T}*
		 */
		TreeNode result = term();
		while (currentToken < tokens.length && (tokens[currentToken].equals("+") || tokens[currentToken].equals("-"))) {
			String current = tokens[currentToken];
			currentToken++;
			TreeNode result2 = term();
			result = current.equals("+") ? new AdditionTreeNode(result, result2) : new SubtractionTreeNode(result, result2);
		}
		
		return result;

	}
}
