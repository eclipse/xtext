/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage
 * @generated
 */
public interface NoLiteralsFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NoLiteralsFactory eINSTANCE = org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLiteralsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>No Lit Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>No Lit Class</em>'.
	 * @generated
	 */
	NoLitClass createNoLitClass();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NoLiteralsPackage getNoLiteralsPackage();

} //NoLiteralsFactory
