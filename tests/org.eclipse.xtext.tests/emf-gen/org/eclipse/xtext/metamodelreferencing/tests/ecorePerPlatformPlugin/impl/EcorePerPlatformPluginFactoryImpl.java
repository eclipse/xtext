/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcorePerPlatformPluginFactoryImpl extends EFactoryImpl implements EcorePerPlatformPluginFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EcorePerPlatformPluginFactory init() {
		try {
			EcorePerPlatformPluginFactory theEcorePerPlatformPluginFactory = (EcorePerPlatformPluginFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2011/tmf/xtext/ecorePerPlatformPlugin"); 
			if (theEcorePerPlatformPluginFactory != null) {
				return theEcorePerPlatformPluginFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EcorePerPlatformPluginFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorePerPlatformPluginFactoryImpl() {
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
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT: return createExtendsPluginEObject();
			case EcorePerPlatformPluginPackage.EXTENDS_EATTRIBUTE: return createExtendsEAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsPluginEObject createExtendsPluginEObject() {
		ExtendsPluginEObjectImpl extendsPluginEObject = new ExtendsPluginEObjectImpl();
		return extendsPluginEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsEAttribute createExtendsEAttribute() {
		ExtendsEAttributeImpl extendsEAttribute = new ExtendsEAttributeImpl();
		return extendsEAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorePerPlatformPluginPackage getEcorePerPlatformPluginPackage() {
		return (EcorePerPlatformPluginPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EcorePerPlatformPluginPackage getPackage() {
		return EcorePerPlatformPluginPackage.eINSTANCE;
	}

} //EcorePerPlatformPluginFactoryImpl
