/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnumsUiPackageImpl.java,v 1.1 2010/02/03 18:24:43 sefftinge Exp $
 */
package org.eclipse.xtext.enumrules.enumsUi.impl;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.enumrules.enumsUi.EnumsUiFactory;
import org.eclipse.xtext.enumrules.enumsUi.EnumsUiPackage;
import org.eclipse.xtext.enumrules.enumsUi.ExistingEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumsUiPackageImpl extends EPackageImpl implements EnumsUiPackage {
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
	 * @see org.eclipse.xtext.enumrules.enumsUi.EnumsUiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EnumsUiPackageImpl() {
		super(eNS_URI, EnumsUiFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EnumsUiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EnumsUiPackage init() {
		if (isInited) return (EnumsUiPackage)EPackage.Registry.INSTANCE.getEPackage(EnumsUiPackage.eNS_URI);

		// Obtain or create and register package
		EnumsUiPackageImpl theEnumsUiPackage = (EnumsUiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EnumsUiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EnumsUiPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEnumsUiPackage.createPackageContents();

		// Initialize created meta-data
		theEnumsUiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEnumsUiPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EnumsUiPackage.eNS_URI, theEnumsUiPackage);
		return theEnumsUiPackage;
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
	public EnumsUiFactory getEnumsUiFactory() {
		return (EnumsUiFactory)getEFactoryInstance();
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

} //EnumsUiPackageImpl
