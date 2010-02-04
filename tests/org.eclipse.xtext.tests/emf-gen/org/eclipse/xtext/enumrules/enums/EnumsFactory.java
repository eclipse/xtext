/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnumsFactory.java,v 1.1 2010/02/04 09:24:54 sefftinge Exp $
 */
package org.eclipse.xtext.enumrules.enums;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.enumrules.enums.EnumsPackage
 * @generated
 */
public interface EnumsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnumsFactory eINSTANCE = org.eclipse.xtext.enumrules.enums.impl.EnumsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Existing Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Existing Type</em>'.
	 * @generated
	 */
	ExistingType createExistingType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EnumsPackage getEnumsPackage();

} //EnumsFactory
