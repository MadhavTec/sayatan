/**
 * 
 */
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
 * @author Sayantan Saha
 *
 */
public class LargeResponses {

	private static final String BASE_DIR = "C:/Users/ss85783/Downloads";

	public void solution() {
		
		
		final Scanner scan = new Scanner(System.in);
		System.out.println("Enter Filename");
		String filename = scan.nextLine();
		List<String> lines = new ArrayList<>();
		StringBuffer result = new StringBuffer();
		System.out.println("Parsing File");
		try (Stream<String> stream = Files.lines(Paths.get(/*BASE_DIR + "/" +*/ filename + ".txt"))) {

			lines = stream.filter(
					line -> Integer.parseInt(line.substring(line.lastIndexOf(" "), line.length()).trim()) >= 5000)
					.collect(Collectors.toList());
			result.append(lines.size());
			result.append("\n");
			Integer totalBytes = lines.stream()
					.mapToInt(line -> Integer.parseInt(line.substring(line.lastIndexOf(" "), line.length()).trim()))
					.sum();
			result.append(totalBytes);

			Path path = Paths.get("bytes_" + filename + ".txt");
			System.out.println("Preparing Response");
			try (BufferedWriter writer = Files.newBufferedWriter(path)) {
				writer.write(result.toString());
			}
			
			System.out.println("Response File Created Successfully - "+"bytes_" + filename + ".txt");

		} catch (IOException e) {
			System.out.println("Unable To Parse File - "+e.getMessage());
		}

	}

	public static void main(String[] args) {

		
		LargeResponses responses = new LargeResponses();
		responses.solution();

	}

}
