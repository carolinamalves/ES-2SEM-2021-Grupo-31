package Grupo31.g31;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Metodo {
   	 int MethodId;
	 String name_package;
	 String name_class;
	 String name_method;
	 int Nom_Class;
	 int Loc_Class;
	 int Wmc_Class;
	 boolean is_God_Class;
	 int Loc_Method;
	 int CYCLO_method;
	 boolean is_Long_Method;
	
	 public int getMethodId() {
		return MethodId;
	}
	
	 public void setMethodId(int methodId) {
		MethodId = methodId;
	}
	
	 public String getName_package() {
		return name_package;
	}

	 public void setName_package(String name_package) {
		this.name_package = name_package;
	}
	
	 public String getName_class() {
		return name_class;
	}
	
	 public void setName_class(String name_class) {
		this.name_class = name_class;
	}

	 public String getName_method() {
		return name_method;
	}
	
	 public void setName_method(String name_method) {
		this.name_method = name_method;
	}
	
	 public int getNom_Class() {
		return Nom_Class;
	}
	
	 public void setNom_Class(int nom_Class) {
		Nom_Class = nom_Class;
	}
	
	 public int getLoc_Class() {
		return Loc_Class;
	}
	
	 public void setLoc_Class(int loc_Class) {
		Loc_Class = loc_Class;
	}
	
	 public int getWmc_Class() {
		return Wmc_Class;
	}
	
	 public void setWmc_Class(int wmc_Class) {
		Wmc_Class = wmc_Class;
	}
	
	 public boolean isIs_God_Class() {
		return is_God_Class;
	}
	
	 public void setIs_God_Class(boolean is_God_Class) {
		this.is_God_Class = is_God_Class;
	}

	 public int getLoc_Method() {
		return Loc_Method;
	}

	 public void setLoc_Method(int loc_Method) {
		Loc_Method = loc_Method;
	}

	 public int getCYCLO_method() {
		return CYCLO_method;
	}

	 public void setCYCLO_method(int cYCLO_method) {
		CYCLO_method = cYCLO_method;
	}
	
	 public boolean isIs_Long_Method() {
		return is_Long_Method;
	}
	
	 public void setIs_Long_Method(boolean is_Long_Method) {
		this.is_Long_Method = is_Long_Method;
	}

	 public Metodo(int MethodId,String name_package,String name_class,String name_method,int Nom_Class,int Loc_Class,
	 int Wmc_Class,int Loc_Method,int CYCLO_method) {
		 this.MethodId=MethodId;
		 this.name_package=name_package;
		 this.name_class=name_class;
		 this.name_method=name_method;
		 this.Nom_Class=Nom_Class;
		 this.Loc_Class=Loc_Class;
		 this.Wmc_Class=Wmc_Class;
		 this.Loc_Method=Loc_Method;
		 this.CYCLO_method=CYCLO_method;
	 }
}