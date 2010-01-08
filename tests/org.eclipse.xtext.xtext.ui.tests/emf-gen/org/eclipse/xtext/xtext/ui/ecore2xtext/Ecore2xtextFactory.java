/**
 * <copyright>
 * </copyright>
 *
 * $Id: Ecore2xtextFactory.java,v 1.1 2010/01/08 12:38:23 jkohnlein Exp $
 */
package org.eclipse.xtext.xtext.ui.ecore2xtext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2xtextPackage
 * @generated
 */
public interface Ecore2xtextFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Ecore2xtextFactory eINSTANCE = org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Concrete0</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete0</em>'.
	 * @generated
	 */
	Concrete0 createConcrete0();

	/**
	 * Returns a new object of class '<em>Concrete1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete1</em>'.
	 * @generated
	 */
	Concrete1 createConcrete1();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	Root createRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Ecore2xtextPackage getEcore2xtextPackage();

} //Ecore2xtextFactory
