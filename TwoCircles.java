package com.puzzle;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 
 * @author Sayantan Saha
 *
 */
public class TwoCircles {

	static String[] circles(String[] info) {

		String[] result = new String[info.length];
		int count = 0;
		for (String string : info) {

			int[] details = Stream.of(string.split(" ")).mapToInt(Integer::parseInt).toArray();

			double radiusDifference = Math.pow(Math.abs(details[2] - details[5]), 2);
			double radiusSum = Math.pow(Math.abs(details[2] + details[5]), 2);
			double distance = Math.pow(Math.abs(details[0] - details[3]), 2)
					+ Math.pow(Math.abs(details[1] - details[4]), 2);

			if (distance >= radiusDifference && distance <= radiusSum) {

				result[count] = "Intersecting";
			}

			else if ((details[0] == 0 && details[3] == 0) || (details[1] == 0 && details[4] == 0)) {

				result[count] = "Concentric";
			}

			else if (distance > details[2] + details[5]) {

				result[count] = "Disjoint Outside";
			}

			else if ((details[2] >= details[5] || details[5] >= details[2])
					&& (Math.pow(distance, 0.5) <= (details[5] - details[2])
							|| Math.pow(distance, 0.5) <= (details[2] - details[5]))) {

				result[count] = "Disjoint Inside";
			}

			else if (details[0] == details[3] || details[1] == details[4]) {

				result[count] = "Touching";
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
		for (int i = 0; i < count; i++) {

			System.out.println("Enter Coordinates Of Two Circles");
			info[i] = scan.nextLine();

		}

		String[] result = TwoCircles.circles(info);
		for (String string : result) {

			System.out.println(string);
		}

	}
}
