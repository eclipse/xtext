/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcorePerNsURIFactoryImpl extends EFactoryImpl implements EcorePerNsURIFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EcorePerNsURIFactory init() {
		try {
			EcorePerNsURIFactory theEcorePerNsURIFactory = (EcorePerNsURIFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2011/tmf/xtext/ecorePerNsURI"); 
			if (theEcorePerNsURIFactory != null) {
				return theEcorePerNsURIFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EcorePerNsURIFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorePerNsURIFactoryImpl() {
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
			case EcorePerNsURIPackage.EXTENDS_NS_URIE_OBJECT: return createExtendsNsURIEObject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsNsURIEObject createExtendsNsURIEObject() {
		ExtendsNsURIEObjectImpl extendsNsURIEObject = new ExtendsNsURIEObjectImpl();
		return extendsNsURIEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorePerNsURIPackage getEcorePerNsURIPackage() {
		return (EcorePerNsURIPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EcorePerNsURIPackage getPackage() {
		return EcorePerNsURIPackage.eINSTANCE;
	}

} //EcorePerNsURIFactoryImpl
