/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartialParsingTestUtilPackageImpl.java,v 1.1 2010/02/04 09:24:53 sefftinge Exp $
 */
package org.eclipse.xtext.parser.partialParsingTestUtil.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren;
import org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild;
import org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilFactory;
import org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartialParsingTestUtilPackageImpl extends EPackageImpl implements PartialParsingTestUtilPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass crossResourceContainerManyChildrenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass crossResourceContainerOneChildEClass = null;

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
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PartialParsingTestUtilPackageImpl() {
		super(eNS_URI, PartialParsingTestUtilFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PartialParsingTestUtilPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PartialParsingTestUtilPackage init() {
		if (isInited) return (PartialParsingTestUtilPackage)EPackage.Registry.INSTANCE.getEPackage(PartialParsingTestUtilPackage.eNS_URI);

		// Obtain or create and register package
		PartialParsingTestUtilPackageImpl thePartialParsingTestUtilPackage = (PartialParsingTestUtilPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PartialParsingTestUtilPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PartialParsingTestUtilPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePartialParsingTestUtilPackage.createPackageContents();

		// Initialize created meta-data
		thePartialParsingTestUtilPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePartialParsingTestUtilPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PartialParsingTestUtilPackage.eNS_URI, thePartialParsingTestUtilPackage);
		return thePartialParsingTestUtilPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCrossResourceContainerManyChildren() {
		return crossResourceContainerManyChildrenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrossResourceContainerManyChildren_Children() {
		return (EReference)crossResourceContainerManyChildrenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCrossResourceContainerOneChild() {
		return crossResourceContainerOneChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrossResourceContainerOneChild_Child() {
		return (EReference)crossResourceContainerOneChildEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartialParsingTestUtilFactory getPartialParsingTestUtilFactory() {
		return (PartialParsingTestUtilFactory)getEFactoryInstance();
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

		// Create classes and their features
		crossResourceContainerManyChildrenEClass = createEClass(CROSS_RESOURCE_CONTAINER_MANY_CHILDREN);
		createEReference(crossResourceContainerManyChildrenEClass, CROSS_RESOURCE_CONTAINER_MANY_CHILDREN__CHILDREN);

		crossResourceContainerOneChildEClass = createEClass(CROSS_RESOURCE_CONTAINER_ONE_CHILD);
		createEReference(crossResourceContainerOneChildEClass, CROSS_RESOURCE_CONTAINER_ONE_CHILD__CHILD);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(crossResourceContainerManyChildrenEClass, CrossResourceContainerManyChildren.class, "CrossResourceContainerManyChildren", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCrossResourceContainerManyChildren_Children(), ecorePackage.getEObject(), null, "children", null, 0, -1, CrossResourceContainerManyChildren.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(crossResourceContainerOneChildEClass, CrossResourceContainerOneChild.class, "CrossResourceContainerOneChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCrossResourceContainerOneChild_Child(), ecorePackage.getEObject(), null, "child", null, 0, 1, CrossResourceContainerOneChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PartialParsingTestUtilPackageImpl
