package com.puzzle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
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
			double distance = Math.sqrt(
					Math.pow(Math.abs(details[0] - details[3]), 2) + Math.pow(Math.abs(details[1] - details[4]), 2));
			if (distance == details[2] + details[5] || distance == Math.abs(details[2] - details[5])) {
				result[count] = "Touching";
			} else if ((details[0] == details[3]) && (details[1] == details[4])) {
				result[count] = "Concentric";
			}
			else if (distance > details[2] + details[5]) {
				result[count] = "Disjoint-Outside";
			} else if (distance < Math.abs(details[2] - details[5])) {
				result[count] = "Disjoint-Inside";
			} else {
				result[count] = "Intersecting";
			}
			count++;
		}
		return result;
	}

	public static void main(String[] args) {

		/*
		 * final Scanner scan = new Scanner(System.in);
		 * System.out.println("Enter Number Of Test Cases"); int count =
		 * Integer.parseInt(scan.nextLine()); String[] info = new String[count];
		 * for (int i = 0; i < count; i++) {
		 * System.out.println("Enter Coordinates Of Two Circles"); info[i] =
		 * scan.nextLine(); }
		 */

		String[] info = null;
		List<String> lines = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get("input010.txt"))) {

			lines = stream.filter(line -> line.trim().length() > 0).collect(Collectors.toList());
			int count = Integer.parseInt(lines.get(0));
			info = new String[count];
			lines.remove(0);
		} catch (IOException e) {
			System.out.println("Unable To Parse File - " + e.getMessage());
		}

		int k = 0;
		for (String string : lines) {

			info[k] = string;
			k++;
		}
		String[] result = TwoCircles.circles(info);
		lines = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get("output010.txt"))) {

			lines = stream.filter(line -> line.trim().length() > 0).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Unable To Parse File - " + e.getMessage());
		}

		k = 0;
		for (String string : result) {

			if (!string.equals(lines.get(k).trim())) {

				System.out.println(k);
				System.out.println(info[k]);
				System.out.println(string + "::::" + lines.get(k));
			}

			k++;
		}

	}
}
