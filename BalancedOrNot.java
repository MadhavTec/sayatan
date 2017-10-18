/**
 * 
 */
package com.puzzle;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Sayantan Saha
 *
 */
public class BalancedOrNot {

	static int[] balancedOrNot(String[] expression, int[] maxreplacement) {
		int[] result = new int[expression.length];
		int count = 0;
		for (String expr : expression) {
			int steps = 0;
			Stack<Character> expressionStack = new Stack<>();
			for (int i = 0; i < expr.length(); i++) {
				if (expr.charAt(i) == '<') {
					expressionStack.push(expr.charAt(i));
				} else if (expr.charAt(i) == '>') {
					if (expressionStack.isEmpty() || expressionStack.pop() != '<') {
						// assume for every incorrect brace we replace it by <>
						// balanced bracket
						steps++;
					}
				}
			}

			if (!expressionStack.isEmpty()) {

				result[count] = 0;
			}

			else {
				if (steps <= maxreplacement[count] || steps == 0) {
					result[count] = 1;
				} else {
					result[count] = 0;
				}
			}
			count++;
		}
		return result;
	}

	public static void main(String[] args) {
		final Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number Of Test Cases");
		int count = Integer.parseInt(scan.nextLine());
		String[] info = new String[count];
		int[] maxRep = new int[count];
		for (int i = 0; i < count; i++) {
			System.out.println("Enter Expr");
			info[i] = scan.nextLine();
			System.out.println("Enter Max rep");
			maxRep[i] = Integer.parseInt(scan.nextLine());
		}

		int[] res = BalancedOrNot.balancedOrNot(info, maxRep);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
