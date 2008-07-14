/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextgenFactory.java,v 1.4 2008/07/14 08:15:32 sefftinge Exp $
 */
package org.eclipse.xtext.xtextgen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtextgen.XtextgenPackage
 * @generated
 */
public interface XtextgenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtextgenFactory eINSTANCE = org.eclipse.xtext.xtextgen.impl.XtextgenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Gen Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Service</em>'.
	 * @generated
	 */
	GenService createGenService();

	/**
	 * Returns a new object of class '<em>Gen Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Model</em>'.
	 * @generated
	 */
	GenModel createGenModel();

	/**
	 * Returns a new object of class '<em>Outlet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outlet</em>'.
	 * @generated
	 */
	Outlet createOutlet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XtextgenPackage getXtextgenPackage();

} //XtextgenFactory
