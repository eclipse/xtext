/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedPackage1Package
 * @generated
 */
public interface NestedPackage1Factory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NestedPackage1Factory eINSTANCE = org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl.NestedPackage1FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Nested Class1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nested Class1</em>'.
	 * @generated
	 */
	NestedClass1 createNestedClass1();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NestedPackage1Package getNestedPackage1Package();

} //NestedPackage1Factory
