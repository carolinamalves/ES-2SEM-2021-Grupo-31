package Grupo31.g31;

import java.io.*;
import java.util.ArrayList;

class LOC_class {

	static String file;

	static File name;

	static int lines;
	static int emptyLines;
	static int totalLines;
	ArrayList<String> packageNames = new ArrayList<String>();
	String s1;
	public static int numLines;

	public 	LOC_class(String file){
		this.file = file;
	}

	public int getTotalLines() {
		return totalLines;
	}

	public static void setTotalLines(int totalLines) {
		LOC_class.totalLines = totalLines;
	}

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