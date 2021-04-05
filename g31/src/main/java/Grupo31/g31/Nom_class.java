package Grupo31.g31;

	import java.lang.reflect.Method;
	import java.lang.reflect.Modifier;
		
	public class Nom_class {
//commit;
		public String getClassName() {
		        String className = this.getClass().getSimpleName(); 
		        return className;
		}
			    public static void main(String args[]) throws ClassNotFoundException{
		        int number=0;
		        Nom_class co = new Nom_class();

		    	Class className=co.getClass();
		    	className= co.getClass();
		          Method[] methods= className.getDeclaredMethods();
		           for(int i=0;i<methods.length;i++){
		         System.out.println(methods[i]);
		           number++;
		        	   
		           }
		           System.out.print("A função tem"+" "+ number + " " +"metodos");
		           }
		           
		         }