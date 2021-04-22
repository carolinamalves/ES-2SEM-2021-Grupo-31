package Grupo31.g31;

public class Method {
	int MethodId;
	String name_package;
	String name_class;
	String name_method;
	int Nom_Class;
	int Loc_Class;
	int Wmc_Class;
	int Loc_Method;
	int CYCLO_method;

	public int getMethodId() {
		return MethodId;
	}

	public String getName_package() {
		return name_package;
	}

	public String getName_class() {
		return name_class;
	}

	public String getName_method() {
		return name_method;
	}

	public int getNom_Class() {
		return Nom_Class;
	}

	public int getLoc_Class() {
		return Loc_Class;
	}

	public int getWmc_Class() {
		return Wmc_Class;
	}

	public int getLoc_Method() {
		return Loc_Method;
	}

	public int getCYCLO_method() {
		return CYCLO_method;
	}

	public Method(int MethodId,String name_package,String name_class,String name_method,int Nom_Class,int Loc_Class,
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