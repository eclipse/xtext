/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.EcorePerPlatformResourcePackage
 * @generated
 */
public interface EcorePerPlatformResourceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcorePerPlatformResourceFactory eINSTANCE = org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.impl.EcorePerPlatformResourceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extends Resource EObject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Resource EObject</em>'.
	 * @generated
	 */
	ExtendsResourceEObject createExtendsResourceEObject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EcorePerPlatformResourcePackage getEcorePerPlatformResourcePackage();

} //EcorePerPlatformResourceFactory
