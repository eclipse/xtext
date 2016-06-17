/**
 * <copyright>
 * </copyright>
 *
 * $Id: CrossContainmentFactoryImpl.java,v 1.1 2010/04/09 10:00:00 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree.impl.crossContainment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.impl.crossContainment.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CrossContainmentFactoryImpl extends EFactoryImpl implements CrossContainmentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CrossContainmentFactory init() {
		try {
			CrossContainmentFactory theCrossContainmentFactory = (CrossContainmentFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/test/crossContainment"); 
			if (theCrossContainmentFactory != null) {
				return theCrossContainmentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CrossContainmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrossContainmentFactoryImpl() {
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
			case CrossContainmentPackage.ELEMENT: return createElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrossContainmentPackage getCrossContainmentPackage() {
		return (CrossContainmentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CrossContainmentPackage getPackage() {
		return CrossContainmentPackage.eINSTANCE;
	}

} //CrossContainmentFactoryImpl
