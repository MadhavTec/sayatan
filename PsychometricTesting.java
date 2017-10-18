/**
 * 
 */
package com.puzzle;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author Sayantan Saha
 *
 */
public class PsychometricTesting {

	static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
		int count = 0;
		int[] result = new int[lowerLimits.length];
		if (lowerLimits.length != upperLimits.length) {
			throw new RuntimeException("Invalid Range Inputs");
		}
		for (; count < lowerLimits.length; count++) {
			final int low = lowerLimits[count];
			final int high = upperLimits[count];
			int[] offer = Arrays.stream(scores).filter(score -> score >= low && score <= high).toArray();
			result[count] = offer.length;
		}
		return result;
	}

	public static void main(String[] args) {

		final Scanner scan = new Scanner(System.in);
		System.out.println("Enter Scores Separated By Comma(,)");
		String scores = scan.nextLine();
		System.out.println("Enter lower limit Separated By Comma(,)");
		String low = scan.nextLine();
		System.out.println("Enter higher limit Separated By Comma(,)");
		String high = scan.nextLine();
		int[] result = PsychometricTesting.jobOffers(Stream.of(scores.split(",")).mapToInt(Integer::parseInt).toArray(),
				Stream.of(low.split(",")).mapToInt(Integer::parseInt).toArray(),
				Stream.of(high.split(",")).mapToInt(Integer::parseInt).toArray());
		for (int i : result) {
			System.out.print(i + ",");
		}
	}
}
