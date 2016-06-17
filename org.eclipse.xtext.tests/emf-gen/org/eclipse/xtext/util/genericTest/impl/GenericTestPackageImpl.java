/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericTestPackageImpl.java,v 1.1 2010/03/31 13:22:31 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.util.genericTest.GenericTestFactory;
import org.eclipse.xtext.util.genericTest.GenericTestPackage;
import org.eclipse.xtext.util.genericTest.OtherType;
import org.eclipse.xtext.util.genericTest.SomeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericTestPackageImpl extends EPackageImpl implements GenericTestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass someTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherTypeEClass = null;

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
	 * @see org.eclipse.xtext.util.genericTest.GenericTestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GenericTestPackageImpl() {
		super(eNS_URI, GenericTestFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GenericTestPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GenericTestPackage init() {
		if (isInited) return (GenericTestPackage)EPackage.Registry.INSTANCE.getEPackage(GenericTestPackage.eNS_URI);

		// Obtain or create and register package
		GenericTestPackageImpl theGenericTestPackage = (GenericTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GenericTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GenericTestPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGenericTestPackage.createPackageContents();

		// Initialize created meta-data
		theGenericTestPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGenericTestPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GenericTestPackage.eNS_URI, theGenericTestPackage);
		return theGenericTestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getA() {
		return aEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA_SomeReference() {
		return (EReference)aEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getA_SomeReference1() {
		return (EReference)aEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB() {
		return bEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB_OtherReference() {
		return (EReference)bEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB_OtherReference1() {
		return (EReference)bEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getC() {
		return cEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getD() {
		return dEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSomeType() {
		return someTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOtherType() {
		return otherTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericTestFactory getGenericTestFactory() {
		return (GenericTestFactory)getEFactoryInstance();
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
		aEClass = createEClass(A);
		createEReference(aEClass, A__SOME_REFERENCE);
		createEReference(aEClass, A__SOME_REFERENCE1);

		bEClass = createEClass(B);
		createEReference(bEClass, B__OTHER_REFERENCE);
		createEReference(bEClass, B__OTHER_REFERENCE1);

		cEClass = createEClass(C);

		dEClass = createEClass(D);

		someTypeEClass = createEClass(SOME_TYPE);

		otherTypeEClass = createEClass(OTHER_TYPE);
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
		ETypeParameter aEClass_T = addETypeParameter(aEClass, "T");
		ETypeParameter bEClass_U = addETypeParameter(bEClass, "U");
		ETypeParameter bEClass_V = addETypeParameter(bEClass, "V");
		ETypeParameter cEClass_W = addETypeParameter(cEClass, "W");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getA());
		EGenericType g2 = createEGenericType(bEClass_V);
		g1.getETypeArguments().add(g2);
		bEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getB());
		g2 = createEGenericType(cEClass_W);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSomeType());
		g1.getETypeArguments().add(g2);
		cEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getC());
		g2 = createEGenericType(this.getOtherType());
		g1.getETypeArguments().add(g2);
		dEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(aEClass, org.eclipse.xtext.util.genericTest.A.class, "A", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(aEClass_T);
		initEReference(getA_SomeReference(), g1, null, "someReference", null, 0, 1, org.eclipse.xtext.util.genericTest.A.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getA_SomeReference1(), this.getSomeType(), null, "someReference1", null, 0, 1, org.eclipse.xtext.util.genericTest.A.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bEClass, org.eclipse.xtext.util.genericTest.B.class, "B", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(bEClass_U);
		initEReference(getB_OtherReference(), g1, null, "otherReference", null, 0, 1, org.eclipse.xtext.util.genericTest.B.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getA());
		g2 = createEGenericType(this.getOtherType());
		g1.getETypeArguments().add(g2);
		initEReference(getB_OtherReference1(), g1, null, "otherReference1", null, 0, 1, org.eclipse.xtext.util.genericTest.B.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cEClass, org.eclipse.xtext.util.genericTest.C.class, "C", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dEClass, org.eclipse.xtext.util.genericTest.D.class, "D", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(someTypeEClass, SomeType.class, "SomeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(otherTypeEClass, OtherType.class, "OtherType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //GenericTestPackageImpl
