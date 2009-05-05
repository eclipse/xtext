/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnumsPackageImpl.java,v 1.2 2009/05/05 15:32:34 sefftinge Exp $
 */
package org.eclipse.xtext.enumrules.enums.impl;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.xtext.enumrules.enums.EnumsFactory;
import org.eclipse.xtext.enumrules.enums.EnumsPackage;
import org.eclipse.xtext.enumrules.enums.ExistingEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumsPackageImpl extends EPackageImpl implements EnumsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum existingEnumEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.xtext.enumrules.enums.EnumsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EnumsPackageImpl() {
		super(eNS_URI, EnumsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EnumsPackage init() {
		if (isInited) return (EnumsPackage)EPackage.Registry.INSTANCE.getEPackage(EnumsPackage.eNS_URI);

		// Obtain or create and register package
		EnumsPackageImpl theEnumsPackage = (EnumsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EnumsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EnumsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEnumsPackage.createPackageContents();

		// Initialize created meta-data
		theEnumsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEnumsPackage.freeze();

		return theEnumsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExistingEnum() {
		return existingEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumsFactory getEnumsFactory() {
		return (EnumsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create enums
		existingEnumEEnum = createEEnum(EXISTING_ENUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Initialize enums and add enum literals
		initEEnum(existingEnumEEnum, ExistingEnum.class, "ExistingEnum");
		addEEnumLiteral(existingEnumEEnum, ExistingEnum.SAME_NAME);
		addEEnumLiteral(existingEnumEEnum, ExistingEnum.OVERRIDDEN_LITERAL);
		addEEnumLiteral(existingEnumEEnum, ExistingEnum.DIFFERENT_NAME);

		// Create resource
		createResource(eNS_URI);
	}

} //EnumsPackageImpl
