package Grupo31.g31;

import java.io.*;
import java.util.ArrayList;

public class Nom_class {
	static int locClass;
	static ArrayList <String> methodNames = new ArrayList<String>();
	static String packName;
	private int f1(Object p, int x) throws NullPointerException  {
		if (p == null)
			throw new NullPointerException();
		return x;
	}

	public int nomClass(String f) throws FileNotFoundException{
		int Mcount=0;
		locClass = 0;
		packName=null;
		try {

			Class cls = Class.forName(f);
			java.lang.reflect.Method[] methlist= cls.getDeclaredMethods();
			System.out.println("NAMEEEEEEEE" + cls.getPackageName());
//			packName= cls.getPackageName();

			for (int i = 0; i < methlist.length; i++){
				Mcount++;
				System.out.println(Mcount);
				System.out.println(methlist[i].getName());
				methodNames.add(methlist[i].getName());
				methodNames.set(i, methlist[i].getName());
			}
//			System.out.println("teste");
//			Scanner scanner = new Scanner(file);
//			while (scanner.hasNextLine()) {
//				locClass++;
//			}
//			scanner.close();
		}
		catch (Throwable e) {
			System.err.println(e);
		}
		System.out.println("Mcount = " + Mcount);
		return Mcount;
	}

	public int getLoc() {
		return locClass;
	}
	
	public ArrayList <String> getMethodNames(){
		return methodNames;
	}
}