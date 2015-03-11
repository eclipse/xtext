/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.EcorePerNsURIPackage
 * @generated
 */
public interface EcorePerNsURIFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcorePerNsURIFactory eINSTANCE = org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.impl.EcorePerNsURIFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extends Ns URIE Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Ns URIE Object</em>'.
	 * @generated
	 */
	ExtendsNsURIEObject createExtendsNsURIEObject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EcorePerNsURIPackage getEcorePerNsURIPackage();

} //EcorePerNsURIFactory
