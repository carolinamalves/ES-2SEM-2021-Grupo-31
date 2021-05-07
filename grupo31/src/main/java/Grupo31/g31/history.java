package Grupo31.g31;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class history {
	
	public static ArrayList<String> historic= new ArrayList<String>();
	
	
	public static void updateHistoric(String fileName, ArrayList<String> newRules){
		try {
//			clear(fileName);
            FileWriter writer = new FileWriter(fileName, true);
          
            for(String rule : newRules) {
            	writer.write(rule);
            	writer.write("\r\n");
            }
            
          
            writer.close();
        } 
			catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}
	
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
	
	
	public static ArrayList<String> viewHistoric(String fileName) {
		
		try {
            FileReader reader = new FileReader(fileName);
            int character;
            
 
            String token1 = "";

        
            Scanner inFile1 = new Scanner(new FileReader(fileName)).useDelimiter("\r\n");

         
            while (inFile1.hasNext()) {
             
              token1 = inFile1.next();
              System.out.println(token1);
              historic.add(token1);
            }
            inFile1.close();
		}
	
            
           
         catch (IOException e) {
            e.printStackTrace();
        }
		
		
		return historic;
		
		
	}
	
	
	
	 public static void main(String[] args) {
		 
		 
		 
		 
		
		 viewHistoric("MyFile.txt");
		 
		 
		 for(String h: historic) {
			 System.out.println("ARRAY :" + h);
		 }
	        
	  }
	
	
	
	
	
	
	

}