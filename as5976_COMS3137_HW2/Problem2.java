import java.util.Scanner;

/**
 * HW2 Problem 2 (programming) 
 * @author Arushi Sahai as5976
 *
 */
public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input the postfix expression.");
		Scanner console = new Scanner(System.in);
		String postfixExpression = console.nextLine(); 
		ExpressionTree exprTree = new ExpressionTree(postfixExpression);
		
		// test example: 3 5 7 * / 3 2 - +
		System.out.println("Evaluate: " + exprTree.eval()); // expect 1
		System.out.println("Postfix: " + exprTree.postfix()); // expect 3 5 7 * / 3 2 - + 
		System.out.println("Prefix: " + exprTree.prefix()); // expect + / 3 * 5 7 - 3 2 
		System.out.println("Infix: " + exprTree.infix()); // expect ((3 / (5 * 7 ))+ (3 - 2 ))
	}
}
