/**
 * <copyright>
 * </copyright>
 *
 * $Id: AsubpackageFactory.java,v 1.1 2010/02/04 09:24:52 sefftinge Exp $
 */
package org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AsubpackagePackage
 * @generated
 */
public interface AsubpackageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AsubpackageFactory eINSTANCE = org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AsubpackageFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>AType</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AType</em>'.
	 * @generated
	 */
	AType createAType();

	/**
	 * Returns a new object of class '<em>AModel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AModel</em>'.
	 * @generated
	 */
	AModel createAModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AsubpackagePackage getAsubpackagePackage();

} //AsubpackageFactory
