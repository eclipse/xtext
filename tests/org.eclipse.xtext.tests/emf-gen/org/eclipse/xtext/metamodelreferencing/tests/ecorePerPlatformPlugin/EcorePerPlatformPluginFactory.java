/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.EcorePerPlatformPluginPackage
 * @generated
 */
public interface EcorePerPlatformPluginFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcorePerPlatformPluginFactory eINSTANCE = org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl.EcorePerPlatformPluginFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extends Plugin EObject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Plugin EObject</em>'.
	 * @generated
	 */
	ExtendsPluginEObject createExtendsPluginEObject();

	/**
	 * Returns a new object of class '<em>Extends EAttribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends EAttribute</em>'.
	 * @generated
	 */
	ExtendsEAttribute createExtendsEAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EcorePerPlatformPluginPackage getEcorePerPlatformPluginPackage();

} //EcorePerPlatformPluginFactory
