package Support;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
//@author grupo 31

public class history {

	/** The historic. */
	public static ArrayList<String> historic= new ArrayList<String>();

	/**
	 * Update historic.
	 *
	 * @param fileName the file name
	 * @param newRules the new rules
	 */
	public static void updateHistoric(String fileName, ArrayList<String> newRules){
		try {
			FileWriter writer = new FileWriter(fileName, true);

			writer(newRules, writer);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writer.
	 *
	 * @param newRules the new rules
	 * @param writer the writer
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void writer(ArrayList<String> newRules, FileWriter writer) throws IOException {
		for (String rule : newRules) {
			writer.write(rule);
			writer.write("\r\n");
		}
		writer.close();
	} 

	/**
	 * Clear.
	 *
	 * @param fileName the file name
	 */
	public static void clear(String fileName) {

		try {
			PrintWriter writer = new PrintWriter(fileName);
			writer.print("");
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * View historic.
	 *
	 * @param fileName the file name
	 * @return the array list
	 */
	public static ArrayList<String> viewHistoric(String fileName) {
		try {
			FileReader reader = new FileReader(fileName);
			int character;
			String token1 = "";
			Scanner inFile1 = new Scanner(new FileReader(fileName)).useDelimiter("\r\n");
			while (inFile1.hasNext()) {

				token1 = inFile1.next();
				historic.add(token1);
			}
			inFile1.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return historic;
	}
}