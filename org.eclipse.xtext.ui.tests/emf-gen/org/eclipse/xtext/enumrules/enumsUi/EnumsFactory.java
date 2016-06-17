/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnumsFactory.java,v 1.1 2010/02/03 18:24:43 sefftinge Exp $
 */
package org.eclipse.xtext.enumrules.enumsUi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.enumrules.enumsUi.EnumsPackage
 * @generated
 */
public interface EnumsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnumsFactory eINSTANCE = org.eclipse.xtext.enumrules.enumsUi.impl.EnumsFactoryImpl.init();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EnumsPackage getEnumsPackage();

} //EnumsFactory
