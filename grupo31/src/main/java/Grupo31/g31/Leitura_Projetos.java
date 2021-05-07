package Grupo31.g31;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bouncycastle.crypto.macs.CMac;

import com.github.javaparser.ParseException;

public class Leitura_Projetos {

	static ArrayList <File> ficheiro = new ArrayList<>();
	static String dirName;
	static ArrayList <String> fimdojava = new ArrayList<>();
	static Create_Method cm = new Create_Method();
	static ArrayList <String> packName = new ArrayList <String>();
 	static int it;
 	
 	static ArrayList <File> file = new ArrayList<>();

	public static ArrayList<File> getFicheiro() {
		return ficheiro;
	}

	public static String getDirName() { 
		return dirName;
	}

	public List <File> lista(String list) {
		
		dirName = list;
		File diretorio = new File(list);
		//List <File> file= new ArrayList<>();
		File[] listaFicheiros = diretorio.listFiles();
		ficheiro.addAll(Arrays.asList(listaFicheiros));
		it = 0;
		
		for (File i : listaFicheiros) {
			it ++;
			if (i.isFile() && i.getAbsolutePath().endsWith(".java")) {
				Path fim = Paths.get(i.getAbsolutePath());
				System.out.println("---------" + fim.getFileName().toString());
				fimdojava.add(fim.getFileName().toString());
		
				cm.fillmethod(i.getAbsoluteFile());
			
//				file.add(i.getAbsoluteFile());
							
			} else if (i.isDirectory()) {
				ficheiro.addAll(lista(i.getAbsolutePath()));
				System.out.println("ficheiro"+ficheiro);
//				packName.add(i.getAbsolutePath());
//				packName.set(it, i.getAbsolutePath());
			}
		}
		
	return ficheiro;
			
}

	public static ArrayList<String> getFimdojava() {
		return fimdojava;
	}
}