/**
 * <copyright>
 * </copyright>
 *
 * $Id: AsubpackageFactoryImpl.java,v 1.1 2010/02/04 09:24:53 sefftinge Exp $
 */
package org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AsubpackageFactoryImpl extends EFactoryImpl implements AsubpackageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AsubpackageFactory init() {
		try {
			AsubpackageFactory theAsubpackageFactory = (AsubpackageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/tests/grammarAccess/subpackage"); 
			if (theAsubpackageFactory != null) {
				return theAsubpackageFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AsubpackageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsubpackageFactoryImpl() {
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
			case AsubpackagePackage.ATYPE: return createAType();
			case AsubpackagePackage.AMODEL: return createAModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AType createAType() {
		ATypeImpl aType = new ATypeImpl();
		return aType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AModel createAModel() {
		AModelImpl aModel = new AModelImpl();
		return aModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsubpackagePackage getAsubpackagePackage() {
		return (AsubpackagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AsubpackagePackage getPackage() {
		return AsubpackagePackage.eINSTANCE;
	}

} //AsubpackageFactoryImpl
