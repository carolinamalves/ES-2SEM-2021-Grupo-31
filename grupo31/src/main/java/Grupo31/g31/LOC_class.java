package Grupo31.g31;

import java.io.*;
import java.awt.*;

class LOC_class {

	static File name;
	static int lines=0;
	static int emptyLines=0;
	static int totalLines=0;


	public 	LOC_class(){
		try{
			FileDialog fd = new FileDialog(new Frame(), "Open a document", FileDialog.LOAD); 
			fd.setDirectory(System.getProperty("user.dir")); 
			fd.setVisible(true);	
			name= new File(fd.getDirectory(), fd.getFile());
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

	public static int getTotalLines() {
		return totalLines;
	}


	public static void setTotalLines(int totalLines) {
		LOC_class.totalLines = totalLines;
	}

	public void Contar(){
		try{
			FileInputStream fstream = new FileInputStream(name); 
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while((strLine = br.readLine())!= null ){
				if (strLine.trim().length() != 0){
					lines++;
				}else{
					emptyLines++;
				}
			}

			totalLines= lines + emptyLines;

			System.out.println("number of lines:" + lines);
			System.out.println("number of lines:" + emptyLines);
			System.out.println("number of lines:" + totalLines);

			in.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}