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
 * @author Enze Zhou ez242
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
		
		// comparison to length should be applied first to avoid subscript-out-of-range
		
		if (currentToken >= tokens.length) {
			System.err.println("Start factor() wrongly.");
			return null;
		} else if (tokens[currentToken].equals("(")) {

			// "(" will only be recognized here and ")" will only be
			// consumed here so as to make sure that the parentheses match.
			
			++currentToken;
			TreeNode result = expression();
			if (currentToken >= tokens.length ||
				!tokens[currentToken].equals(")")) {
				System.err.println("Missing ) in factor()");
				return null;
			}
			++currentToken;
			return result;
		} else if (tokens[currentToken].equals("-")) {
			
			// here we should call factor() recursively instead of assuming that
			// tokens[currentToken + 1] is a digit. otherwise "---" can't be handled correctly
			
			++currentToken;
			TreeNode num = factor();
			return new UnaryMinusTreeNode(num);
		} else if (Character.isDigit(tokens[currentToken].charAt(0))) {
			return new LeafTreeNode(Double.valueOf(tokens[currentToken++]));
		} else {
			System.err.println("Unexpected symbol in factor() while parsing " + tokens[currentToken]);
			return null;
		}
		
	}

	/**
	 * Parse the remaining input as far as needed to get the next term
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode term() {
		
		TreeNode result;
		if (currentToken < tokens.length) {
			result = factor();
		} else {
			System.err.println("Start term() wrongly.");
			return null;
		}
		
		while (true) {
			if (currentToken >= tokens.length ||
				tokens[currentToken].equals("+") ||
				tokens[currentToken].equals("-") ||
				tokens[currentToken].equals(")")) {
				return result;
			} else if (tokens[currentToken].equals("*")) {
				++currentToken;
				TreeNode temp = factor();
				TreeNode temp2 = new MultiplicationTreeNode(result, temp);
				result = temp2;
			} else if (tokens[currentToken].equals("/")) {
				++currentToken;
				TreeNode temp = factor();
				TreeNode temp2 = new DivisionTreeNode(result, temp);
				result = temp2;
			} else {
				
				// output temporary result and remaining text to assist in debugging
				
				System.err.println("Unexpected symbol in term() while parsing.");
				PrintTreeVisitor printVisitor = new PrintTreeVisitor();
				result.accept(printVisitor);
				System.out.println(printVisitor.getResult());
				for (int i = currentToken; i < tokens.length; ++i)
					System.out.print(tokens[i]);
				System.out.println("");
				return null;
			}
		}
	}

	/**
	 * Parse the remaining input as far as needed to get the next expression
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode expression() {
		
		TreeNode result;
		if (currentToken < tokens.length) {
			result = term();
		} else {
			System.err.println("Start expression() wrongly.");
			return null;
		}
		
		while (true) {
			if (currentToken >= tokens.length ||
				tokens[currentToken].equals(")")) {
				return result;
			} else if (tokens[currentToken].equals("+")) {
				++currentToken;
				TreeNode temp = term();
				TreeNode temp2 = new AdditionTreeNode(result, temp);
				result = temp2;
			} else if (tokens[currentToken].equals("-")) {
				++currentToken;
				TreeNode temp = term();
				TreeNode temp2 = new SubtractionTreeNode(result, temp);
				result = temp2;
			} else {
				
				// output temporary result and remaining text to assist in debugging
				
				System.err.println("Unexpected symbol in expression() while parsing."); 
				PrintTreeVisitor printVisitor = new PrintTreeVisitor();
				result.accept(printVisitor);
				System.out.println(printVisitor.getResult());
				for (int i = currentToken; i < tokens.length; ++i)
					System.out.print(tokens[i]);
				System.out.println("");
				return null;
			}
		}
	}
}
