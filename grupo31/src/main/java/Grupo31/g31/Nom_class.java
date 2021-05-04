package Grupo31.g31;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;

public class Nom_class {

	private static int numberM;
	public String name;

	public String getClassName() {
		String className = name; 
		numberM=0;
		return className;
	}

	public void nomClass(String file) throws FileNotFoundException{
//		Nom_class co = new Nom_class();

		Class className = file.getClass();

		Method[] methods= className.getDeclaredMethods();
		for(int i = 0; i < methods.length; i++) {
			numberM++;
			
		
		}
	}

	public int getNomClass() {
		return numberM;
	}
}