/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.withtransient;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithtransientFactory
 * @model kind="package"
 * @generated
 */
public interface WithtransientPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "withtransient";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/ide/tests/testlanguage/mm/withtransient";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "withtransient";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WithtransientPackage eINSTANCE = org.eclipse.xtext.ide.tests.testlanguage.withtransient.impl.WithtransientPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.ide.tests.testlanguage.withtransient.impl.WithTransientImpl <em>With Transient</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.ide.tests.testlanguage.withtransient.impl.WithTransientImpl
	 * @see org.eclipse.xtext.ide.tests.testlanguage.withtransient.impl.WithtransientPackageImpl#getWithTransient()
	 * @generated
	 */
	int WITH_TRANSIENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_TRANSIENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_TRANSIENT__PACKAGE_NAME = 1;

	/**
	 * The number of structural features of the '<em>With Transient</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_TRANSIENT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithTransient <em>With Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Transient</em>'.
	 * @see org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithTransient
	 * @generated
	 */
	EClass getWithTransient();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithTransient#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithTransient#getName()
	 * @see #getWithTransient()
	 * @generated
	 */
	EAttribute getWithTransient_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithTransient#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithTransient#getPackageName()
	 * @see #getWithTransient()
	 * @generated
	 */
	EAttribute getWithTransient_PackageName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WithtransientFactory getWithtransientFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.ide.tests.testlanguage.withtransient.impl.WithTransientImpl <em>With Transient</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.ide.tests.testlanguage.withtransient.impl.WithTransientImpl
		 * @see org.eclipse.xtext.ide.tests.testlanguage.withtransient.impl.WithtransientPackageImpl#getWithTransient()
		 * @generated
		 */
		EClass WITH_TRANSIENT = eINSTANCE.getWithTransient();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WITH_TRANSIENT__NAME = eINSTANCE.getWithTransient_Name();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WITH_TRANSIENT__PACKAGE_NAME = eINSTANCE.getWithTransient_PackageName();

	}

} //WithtransientPackage
