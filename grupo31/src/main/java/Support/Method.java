package Support;

// TODO: Auto-generated Javadoc
//@author grupo 31

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
	 * Sets the method id.
	 *
	 * @param methodId the new method id
	 */
	public void setMethodId(int methodId) {
		MethodId = methodId;
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
	 * Sets the name package.
	 *
	 * @param name_package the new name package
	 */
	public void setName_package(String name_package) {
		this.name_package = name_package;
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
	 * Sets the name class.
	 *
	 * @param name_class the new name class
	 */
	public void setName_class(String name_class) {
		this.name_class = name_class;
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
	 * Sets the name method.
	 *
	 * @param name_method the new name method
	 */
	public void setName_method(String name_method) {
		this.name_method = name_method;
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
	 * Sets the nom class.
	 *
	 * @param nom_Class the new nom class
	 */
	public void setNom_Class(int nom_Class) {
		Nom_Class = nom_Class;
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
	 * Sets the loc class.
	 *
	 * @param loc_Class the new loc class
	 */
	public void setLoc_Class(int loc_Class) {
		Loc_Class = loc_Class;
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
	 * Sets the wmc class.
	 *
	 * @param wmc_Class the new wmc class
	 */
	public void setWmc_Class(int wmc_Class) {
		Wmc_Class = wmc_Class;
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
	 * Sets the loc method.
	 *
	 * @param loc_Method the new loc method
	 */
	public void setLoc_Method(int loc_Method) {
		Loc_Method = loc_Method;
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
	 * Sets the CYCL O method.
	 *
	 * @param cYCLO_method the new CYCL O method
	 */
	public void setCYCLO_method(int cYCLO_method) {
		CYCLO_method = cYCLO_method;
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