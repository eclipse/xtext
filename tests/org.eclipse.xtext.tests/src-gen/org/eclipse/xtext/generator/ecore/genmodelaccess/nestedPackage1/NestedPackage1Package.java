/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1;

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
 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedPackage1Factory
 * @model kind="package"
 * @generated
 */
public interface NestedPackage1Package extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nestedPackage1";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xtext.org/genmodeltest-nested-v1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nestedPackage1";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NestedPackage1Package eINSTANCE = org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedPackage1PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedClass1Impl <em>Nested Class1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedClass1Impl
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedPackage1PackageImpl#getNestedClass1()
	 * @generated
	 */
	int NESTED_CLASS1 = 0;

	/**
	 * The number of structural features of the '<em>Nested Class1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_CLASS1_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedClass1 <em>Nested Class1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nested Class1</em>'.
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedClass1
	 * @generated
	 */
	EClass getNestedClass1();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NestedPackage1Factory getNestedPackage1Factory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedClass1Impl <em>Nested Class1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedClass1Impl
		 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedPackage1PackageImpl#getNestedClass1()
		 * @generated
		 */
		EClass NESTED_CLASS1 = eINSTANCE.getNestedClass1();

	}

} //NestedPackage1Package
