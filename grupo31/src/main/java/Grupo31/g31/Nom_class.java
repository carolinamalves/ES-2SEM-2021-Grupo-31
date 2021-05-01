package Grupo31.g31;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

/**
 * @author admin
 *
 */
public class Nom_class {
	
	private static int numberM;
	public String name;
	public String getClassName() {
		String className = name; 
		numberM=0;
		return className;
	}
	public void nomClass() throws FileNotFoundException{
		//int numberM=0;
		Nom_class co = new Nom_class();

		
		Class<? extends Nom_class> className=co.getClass();
		className= co.getClass();
		Method[] methods= className.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			System.out.println(methods[i]);
			numberM++;

		}
		System.out.print("A função tem"+" "+ numberM + " " +"metodos");
	}
	
	public int getNomClass() {
		return numberM;
	}

}