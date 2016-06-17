/**
 * <copyright>
 * </copyright>
 *
 * $Id: SubsubpackageFactoryImpl.java,v 1.1 2010/02/04 09:24:54 sefftinge Exp $
 */
package org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SubsubpackageFactoryImpl extends EFactoryImpl implements SubsubpackageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SubsubpackageFactory init() {
		try {
			SubsubpackageFactory theSubsubpackageFactory = (SubsubpackageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/tests/grammarAccess/subsubpackage"); 
			if (theSubsubpackageFactory != null) {
				return theSubsubpackageFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SubsubpackageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsubpackageFactoryImpl() {
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
			case SubsubpackagePackage.ANOTHER_TYPE: return createAnotherType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnotherType createAnotherType() {
		AnotherTypeImpl anotherType = new AnotherTypeImpl();
		return anotherType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsubpackagePackage getSubsubpackagePackage() {
		return (SubsubpackagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SubsubpackagePackage getPackage() {
		return SubsubpackagePackage.eINSTANCE;
	}

} //SubsubpackageFactoryImpl
