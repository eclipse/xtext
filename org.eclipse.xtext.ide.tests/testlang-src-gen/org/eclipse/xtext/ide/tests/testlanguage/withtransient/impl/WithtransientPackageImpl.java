/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.withtransient.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithTransient;
import org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithtransientFactory;
import org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithtransientPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WithtransientPackageImpl extends EPackageImpl implements WithtransientPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass withTransientEClass = null;

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
	 * @see org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithtransientPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WithtransientPackageImpl()
	{
		super(eNS_URI, WithtransientFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link WithtransientPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WithtransientPackage init()
	{
		if (isInited) return (WithtransientPackage)EPackage.Registry.INSTANCE.getEPackage(WithtransientPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredWithtransientPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		WithtransientPackageImpl theWithtransientPackage = registeredWithtransientPackage instanceof WithtransientPackageImpl ? (WithtransientPackageImpl)registeredWithtransientPackage : new WithtransientPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theWithtransientPackage.createPackageContents();

		// Initialize created meta-data
		theWithtransientPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWithtransientPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WithtransientPackage.eNS_URI, theWithtransientPackage);
		return theWithtransientPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWithTransient()
	{
		return withTransientEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWithTransient_Name()
	{
		return (EAttribute)withTransientEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWithTransient_PackageName()
	{
		return (EAttribute)withTransientEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WithtransientFactory getWithtransientFactory()
	{
		return (WithtransientFactory)getEFactoryInstance();
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
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		withTransientEClass = createEClass(WITH_TRANSIENT);
		createEAttribute(withTransientEClass, WITH_TRANSIENT__NAME);
		createEAttribute(withTransientEClass, WITH_TRANSIENT__PACKAGE_NAME);
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
	public void initializePackageContents()
	{
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
		initEClass(withTransientEClass, WithTransient.class, "WithTransient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWithTransient_Name(), ecorePackage.getEString(), "name", null, 0, 1, WithTransient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWithTransient_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, WithTransient.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //WithtransientPackageImpl
