/**
 * 
 */
package com.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sayantan Saha
 *
 */
public class FindingTheWinner {

	static String winner(int[] andrea, int[] maria, String s) {

		int low = 0;
		int high = andrea.length;

		List<Integer> indices = new ArrayList<>();
		if (s.equals("EVEN")) {

			while (low < high) {
				indices.add(low);
				low += 2;
			}
		}

		else {

			low = 1;
			while (low < high) {
				indices.add(low);
				low += 2;
			}

		}

		int andreaPoint = 0, mariapoint = 0;

		for (Integer integer : indices) {

			andreaPoint += andrea[integer] - maria[integer];
			mariapoint += maria[integer] - andrea[integer];
		}

		if (andreaPoint > mariapoint)
			return "ANDREA";
		else
			return "MARIA";
	}
	
	
	public static void main(String[] args) {
		
		int[] a={1,2,3};
		int []m={2,1,3};
		System.out.println(FindingTheWinner.winner(a, m, "EVEN"));
	}
}
