package Support;

import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
//@author grupo 31

public class Leitura_Projetos {

	/** The ficheiro. */
	static ArrayList <File> ficheiro = new ArrayList<>();

	/** The dir name. */
	static String dirName;

	/** The fimdojava. */
	static ArrayList <String> fimdojava = new ArrayList<>();

	/** The cm. */
	static Create_Method cm = new Create_Method();

	/** The pack name. */
	static ArrayList <String> packName = new ArrayList <String>();

	/** The it. */
	static int it;

	/** The packages. */
	public static ArrayList <String> packages = new ArrayList<>();

	/** The contador classes. */
	public static int contadorClasses;

	/** The file. */
	static ArrayList <File> file = new ArrayList<>();

	/**
	 * Gets the ficheiro.
	 *
	 * @return the ficheiro
	 */
	public static ArrayList<File> getFicheiro() {
		return ficheiro;
	}

	/**
	 * Gets the dir name.
	 *
	 * @return the dir name
	 */
	public static String getDirName() { 
		return dirName;
	}

	/**
	 * Lista.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List <File> lista(String list) {

		dirName = list;
		packages(list);
		File diretorio = new File(list);
		File[] listaFicheiros = diretorio.listFiles();
		ficheiro.addAll(Arrays.asList(listaFicheiros));
		it = 0;

		for (File i : listaFicheiros) {
			it ++;
			if (i.isFile() && i.getAbsolutePath().endsWith(".java")) {
				Path fim = Paths.get(i.getAbsolutePath());
				fimdojava.add(fim.getFileName().toString());	
				cm.fillmethod(i.getAbsoluteFile());
				contadorClasses++;

			} else if (i.isDirectory()) {
				ficheiro.addAll(lista(i.getAbsolutePath()));
			}
		}
		return ficheiro;
	}

	/**
	 * Packages.
	 *
	 * @param list the list
	 */
	private void packages(String list) {
		File diretorio = new File(list);
		File[] listaFicheiros = diretorio.listFiles();
		for (File i : listaFicheiros) {
			if (i.isFile() && i.getAbsolutePath().endsWith(".java")) {
				String parentName = i.getParent();
				if (!packages.contains(parentName)) {
					packages.add(parentName);
				}
			} else if (i.isDirectory()) {
			}
		}
	}

	/**
	 * Gets the fimdojava.
	 *
	 * @return the fimdojava
	 */
	public static ArrayList<String> getFimdojava() {
		return fimdojava;
	}
}