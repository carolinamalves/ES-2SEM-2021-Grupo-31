package Metrics;

import java.io.*;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
//@author grupo 31

//Linhas de código da class
public class LOC_class {

	/** The file. */
	static String file;

	/** The name. */
	static File name;

	/** The lines. */
	static int lines;
	
	/** The empty lines. */
	static int emptyLines;
	
	/** The total lines. */
	static int totalLines;
	
	/** The package names. */
	ArrayList<String> packageNames = new ArrayList<String>();
	
	/** The s 1. */
	public String s1;
	
	/** The num lines. */
	public static int numLines;

	/**
	 * Instantiates a new LO C class.
	 *
	 * @param file the file
	 */
	public 	LOC_class(String file){
		this.file = file;
	}

	/**
	 * Gets the total lines.
	 *
	 * @return the total lines
	 */
	public int getTotalLines() {
		return totalLines;
	}

	/**
	 * Sets the total lines.
	 *
	 * @param totalLines the new total lines
	 */
	public static void setTotalLines(int totalLines) {
		LOC_class.totalLines = totalLines;
	}

	/**
	 * Contar.
	 *
	 * @return the int
	 */
	public int Contar() {
		lines = 0;
		emptyLines = 0;
		totalLines = 0;

		try{
			FileInputStream fstream = new FileInputStream(file); 
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while((strLine = br.readLine())!= null ){
				if (strLine.trim().length() != 0){
					lines++;
					numLines++;
					if(strLine.indexOf("package") != -1) {
						String s = strLine.replace("package ", "");
						s1 = s.replace(";", "");
					}	
				}else{
					emptyLines++;
				}
			}
			totalLines= lines;
			in.close();

		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		return totalLines;
	}
}