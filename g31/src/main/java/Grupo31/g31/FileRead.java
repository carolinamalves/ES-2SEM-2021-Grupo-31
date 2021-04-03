package Grupo31.g31;



import java.io.*;
import java.awt.*;
import javax.swing.*;


class FileRead extends JFrame {
	

	static File name;
	static int count =0;
	static int count2=0;
	static int totalLines;
	
public 	FileRead(){
	try{
	  FileDialog fd = new FileDialog(new Frame(), "Open a document", FileDialog.LOAD); 
      fd.setDirectory(System.getProperty("user.dir")); 
      fd.setVisible(true);	
   	  name= new File(fd.getDirectory(), fd.getFile());
   	 }catch(Exception e){
   	 	System.err.println(e.getMessage());
   	 	}
   	setSize(400,400);
   	setVisible(true);
   	 }
   	 
	
   	 public static int getTotalLines() {
   		 return totalLines;
   	 }


   	public static void setTotalLines(int totalLines) {
   		FileRead.totalLines = totalLines;
   	}


	/*public void paint(Graphics g){
   	 	super.paint(g);
   	 	g.drawString("Testing open file", 30,100);
   	 	g.drawString("Number of characters' lines: " + count,30,200);
   	 	g.drawString("Number of empty lines :" + count2, 30, 250);
   	 }*/
		
   public void Contar(){
   //	FileRead fr = new FileRead();
   //	fr.setDefaultCloseOperation(2);

      try{
    FileInputStream fstream = new FileInputStream(name); 
    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;

   
    while((strLine = br.readLine())!= null ){
    	if (strLine.trim().length() != 0){
    		System.out.println(strLine);
    		count++;
    	}else{
    		count2++;
    	}
    }

    totalLines= count + count2;
    
    System.out.println("number of lines:" + count);
    System.out.println("number of lines:" + count2);
   
    in.close();
    }catch (Exception e){
      System.err.println("Error: " + e.getMessage());
    }
  //  fr.repaint();
}
   
 
}