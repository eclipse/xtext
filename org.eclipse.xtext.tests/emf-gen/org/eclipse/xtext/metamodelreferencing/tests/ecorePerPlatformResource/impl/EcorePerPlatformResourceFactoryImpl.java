/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcorePerPlatformResourceFactoryImpl extends EFactoryImpl implements EcorePerPlatformResourceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EcorePerPlatformResourceFactory init() {
		try {
			EcorePerPlatformResourceFactory theEcorePerPlatformResourceFactory = (EcorePerPlatformResourceFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2011/tmf/xtext/ecorePerPlatformResource"); 
			if (theEcorePerPlatformResourceFactory != null) {
				return theEcorePerPlatformResourceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EcorePerPlatformResourceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorePerPlatformResourceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EcorePerPlatformResourcePackage.EXTENDS_RESOURCE_EOBJECT: return createExtendsResourceEObject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsResourceEObject createExtendsResourceEObject() {
		ExtendsResourceEObjectImpl extendsResourceEObject = new ExtendsResourceEObjectImpl();
		return extendsResourceEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorePerPlatformResourcePackage getEcorePerPlatformResourcePackage() {
		return (EcorePerPlatformResourcePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EcorePerPlatformResourcePackage getPackage() {
		return EcorePerPlatformResourcePackage.eINSTANCE;
	}

} //EcorePerPlatformResourceFactoryImpl
