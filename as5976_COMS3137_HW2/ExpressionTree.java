import java.util.Stack;

/**
 * HW2 Problem 2 (programming) 
 * @author Arushi Sahai as5976
 *
 */
public class ExpressionTree {

	private static ExpressionNode root = null;
	private static Stack<ExpressionNode> expression = new Stack<ExpressionNode>();

	/**
	 * Constructor
	 * @param postfixExp
	 */
	public ExpressionTree(String postfixExp) {
		constructTree(postfixExp);
	}
	
	private static void constructTree(String postfixExp) {
		String[] tokens = postfixExp.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				System.out.println("token: " + token);
				if (!expression.empty()) {
					ExpressionNode right = expression.pop();
					if (!expression.empty()) {
						ExpressionNode left = expression.pop();
						ExpressionNode pushNode = new ExpressionNode(token, left, right);
						expression.push(pushNode);
						System.out.println("Pushing " + token + " with left " + left.element + " and right " + right.element);
					}
					else {
						System.out.println("Not enough operands for operator.");
						break;
					}
				}
				else {
					System.out.println("Not enough operands for operator.");
					break; // maybe replace with try-catch 
				}
			}
			else {
				expression.push(new ExpressionNode(token));
				System.out.println("Pushing " + token);
			}	
		}
		root = expression.peek();
	}
	
	/**
	 * Evaluate
	 * @return
	 */
	public int eval() {
		return evalRecursive(root);
	}
	
	private int evalRecursive(ExpressionNode node) {
		if (node.left == null) {
			return Integer.parseInt(node.element);
		}
		else {
			int leftVal = evalRecursive(node.left);
			int rightVal = evalRecursive(node.right);
			switch (node.element) {
			case "+":
				return leftVal + rightVal;
			case "-":
				return leftVal - rightVal;
			case "/":
				return leftVal / rightVal;
			case "*":
				return leftVal * rightVal;
			}	
			return 0;
		}
	}
	
	/**
	 * Postfix
	 * @return
	 */
	public String postfix() {
		return postfixRecursive(root);
	}
	
	private String postfixRecursive(ExpressionNode node) {
		String expression = "";
		if (node.left == null) {
			expression += node.element + " ";
			System.out.println(expression);
			return expression;
		}
		return postfixRecursive(node.left) + postfixRecursive(node.right) + node.element + " ";
	}
	
	/**
	 * Prefix
	 * @return
	 */
	public String prefix() {
		return prefixRecursive(root);
	}
	
	private String prefixRecursive(ExpressionNode node) {
		String expression = "";
		if (node.left == null) {
			expression += node.element + " ";
			return expression;
		}
		return node.element + " " + prefixRecursive(node.left) + prefixRecursive(node.right);
	}
	
	/**
	 * Infix
	 * @return
	 */
	public String infix() {
		return infixRecursive(root);
	}
	
	private String infixRecursive(ExpressionNode node) {
		String expression = "";
		if (node.left == null) {
			expression += node.element + " ";
			return expression;
		}
		return "(" + infixRecursive(node.left) + node.element + " " + infixRecursive(node.right) + ")";
	}
	
	private static class ExpressionNode {
		
		ExpressionNode(String theElement) {
			this (theElement, null, null);
		}
		
		ExpressionNode(String theElement, ExpressionNode lt, ExpressionNode rt) {
			element = theElement;
			left = lt;
			right = rt;
		}
		
		String element;
		ExpressionNode left;
		ExpressionNode right;
	}
		
}
