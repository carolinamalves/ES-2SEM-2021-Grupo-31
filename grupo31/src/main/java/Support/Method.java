package Support;

// TODO: Auto-generated Javadoc
//@author grupo 31

//Cria métodos
public class Method {

	/** The name package. */
	String name_package;

	/** The name class. */
	String name_class;

	/** The name method. */
	String name_method;

	/** The Method id. */
	int MethodId;

	/** The Nom class. */
	int Nom_Class;

	/** The Loc class. */
	int Loc_Class;

	/** The Wmc class. */
	int Wmc_Class;

	/** The Loc method. */
	int Loc_Method;

	/** The CYCL O method. */
	int CYCLO_method;

	/**
	 * Gets the method id.
	 *
	 * @return the method id
	 */
	public int getMethodId() {
		return MethodId;
	}

	/**
	 * Gets the name package.
	 *
	 * @return the name package
	 */
	public String getName_package() {
		return name_package;
	}


	/**
	 * Gets the name class.
	 *
	 * @return the name class
	 */
	public String getName_class() {
		return name_class;
	}


	/**
	 * Gets the name method.
	 *
	 * @return the name method
	 */
	public String getName_method() {
		return name_method;
	}

	/**
	 * Gets the nom class.
	 *
	 * @return the nom class
	 */
	public int getNom_Class() {
		return Nom_Class;
	}

	/**
	 * Gets the loc class.
	 *
	 * @return the loc class
	 */
	public int getLoc_Class() {
		return Loc_Class;
	}

	/**
	 * Gets the wmc class.
	 *
	 * @return the wmc class
	 */
	public int getWmc_Class() {
		return Wmc_Class;
	}

	/**
	 * Gets the loc method.
	 *
	 * @return the loc method
	 */
	public int getLoc_Method() {
		return Loc_Method;
	}

	/**
	 * Gets the CYCL O method.
	 *
	 * @return the CYCL O method
	 */
	public int getCYCLO_method() {
		return CYCLO_method;
	}

	/**
	 * Instantiates a new method.
	 *
	 * @param MethodId the method id
	 * @param name_package the name package
	 * @param name_class the name class
	 * @param name_method the name method
	 * @param Nom_Class the nom class
	 * @param Loc_Class the loc class
	 * @param Wmc_Class the wmc class
	 * @param Loc_Method the loc method
	 * @param CYCLO_method the CYCL O method
	 */
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