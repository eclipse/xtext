/**
 * <copyright>
 * </copyright>
 *
 * $Id: XbaseFactory.java,v 1.2 2010/01/16 08:50:53 sefftinge Exp $
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.XbasePackage
 * @generated
 */
public interface XbaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XbaseFactory eINSTANCE = org.eclipse.xtext.xbase.impl.XbaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XFile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFile</em>'.
	 * @generated
	 */
	XFile createXFile();

	/**
	 * Returns a new object of class '<em>XImport</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport</em>'.
	 * @generated
	 */
	XImport createXImport();

	/**
	 * Returns a new object of class '<em>XFunction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFunction</em>'.
	 * @generated
	 */
	XFunction createXFunction();

	/**
	 * Returns a new object of class '<em>XClass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XClass</em>'.
	 * @generated
	 */
	XClass createXClass();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XbasePackage getXbasePackage();

} //XbaseFactory
