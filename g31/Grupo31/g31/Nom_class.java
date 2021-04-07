package Grupo31.g31;

import java.lang.reflect.Method;

public class Nom_class {
	
	static int numberM;
	
	public String getClassName() {
		String className = this.getClass().getSimpleName(); 
		return className;
	}
	
	public int getNomClass (){
	return numberM;	
	}
	
	
	public void nomClass(){
		int numberM=0;
		Nom_class co = new Nom_class();

		Class className=co.getClass();
		className= co.getClass();
		Method[] methods= className.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			System.out.println(methods[i]);
			numberM++;
		}
		
		System.out.print("A função tem"+" "+ numberM + " " +"metodos");
	}

}