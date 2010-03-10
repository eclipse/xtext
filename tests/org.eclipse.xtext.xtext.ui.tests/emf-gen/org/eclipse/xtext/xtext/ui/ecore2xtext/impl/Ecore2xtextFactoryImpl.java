/**
 * <copyright>
 * </copyright>
 *
 * $Id: Ecore2xtextFactoryImpl.java,v 1.2 2010/03/10 16:34:10 jkohnlein Exp $
 */
package org.eclipse.xtext.xtext.ui.ecore2xtext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtext.ui.ecore2xtext.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Ecore2xtextFactoryImpl extends EFactoryImpl implements Ecore2xtextFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Ecore2xtextFactory init() {
		try {
			Ecore2xtextFactory theEcore2xtextFactory = (Ecore2xtextFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/ecore2xtext"); 
			if (theEcore2xtextFactory != null) {
				return theEcore2xtextFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Ecore2xtextFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ecore2xtextFactoryImpl() {
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
			case Ecore2xtextPackage.CONCRETE0: return createConcrete0();
			case Ecore2xtextPackage.CONCRETE1: return createConcrete1();
			case Ecore2xtextPackage.ROOT: return createRoot();
			case Ecore2xtextPackage.DIAMOND_INHERITANCE: return createDiamondInheritance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Ecore2xtextPackage.INT:
				return createINTFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Ecore2xtextPackage.INT:
				return convertINTToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concrete0 createConcrete0() {
		Concrete0Impl concrete0 = new Concrete0Impl();
		return concrete0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concrete1 createConcrete1() {
		Concrete1Impl concrete1 = new Concrete1Impl();
		return concrete1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root createRoot() {
		RootImpl root = new RootImpl();
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiamondInheritance createDiamondInheritance() {
		DiamondInheritanceImpl diamondInheritance = new DiamondInheritanceImpl();
		return diamondInheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createINTFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertINTToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ecore2xtextPackage getEcore2xtextPackage() {
		return (Ecore2xtextPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Ecore2xtextPackage getPackage() {
		return Ecore2xtextPackage.eINSTANCE;
	}

} //Ecore2xtextFactoryImpl
