/**
 * <copyright>
 * </copyright>
 *
 * $Id: CrossContainmentFactory.java,v 1.1 2010/04/09 10:00:02 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree.impl.crossContainment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.impl.crossContainment.CrossContainmentPackage
 * @generated
 */
public interface CrossContainmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CrossContainmentFactory eINSTANCE = org.eclipse.xtext.parsetree.impl.crossContainment.impl.CrossContainmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element</em>'.
	 * @generated
	 */
	Element createElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CrossContainmentPackage getCrossContainmentPackage();

} //CrossContainmentFactory
