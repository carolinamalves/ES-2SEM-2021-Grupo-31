package Grupo31.g31;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leitura_Projetos {
	  static ArrayList <File> ficheiro = new ArrayList<>();
	 static String dirName;
	  
	  public static ArrayList<File> getFicheiro() {
		  return ficheiro;
	  }
	  
	  public static String getDirName() { 
		  
		
		 return dirName;
		  
	  }
	  
	  public List <File> lista(String local_diretorio) {
	      dirName = local_diretorio;
		  File diretorio = new File(local_diretorio);

	        File[] listaFicheiros = diretorio.listFiles();
	        ficheiro.addAll(Arrays.asList(listaFicheiros));
	        for (File i : listaFicheiros) {
	        	if (i.isFile() && i.getAbsolutePath().endsWith(".java")) {
	                System.out.println(i.getAbsolutePath());
	            } else if (i.isDirectory()) {
	                ficheiro.addAll(lista(i.getAbsolutePath()));
	            }
	        }
	        //System.out.println(fList);
	       //System.out.println(getFicheiro());
	        return ficheiro;
	      
	    }   
	}
