/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericTestFactoryImpl.java,v 1.1 2010/03/31 13:22:30 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.util.genericTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericTestFactoryImpl extends EFactoryImpl implements GenericTestFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GenericTestFactory init() {
		try {
			GenericTestFactory theGenericTestFactory = (GenericTestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/Xtext/tests/genericTest"); 
			if (theGenericTestFactory != null) {
				return theGenericTestFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GenericTestFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericTestFactoryImpl() {
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
			case GenericTestPackage.A: return createA();
			case GenericTestPackage.B: return createB();
			case GenericTestPackage.C: return createC();
			case GenericTestPackage.D: return createD();
			case GenericTestPackage.SOME_TYPE: return createSomeType();
			case GenericTestPackage.OTHER_TYPE: return createOtherType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> A<T> createA() {
		AImpl<T> a = new AImpl<T>();
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <U, V> B<U, V> createB() {
		BImpl<U, V> b = new BImpl<U, V>();
		return b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <W> C<W> createC() {
		CImpl<W> c = new CImpl<W>();
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D createD() {
		DImpl d = new DImpl();
		return d;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SomeType createSomeType() {
		SomeTypeImpl someType = new SomeTypeImpl();
		return someType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OtherType createOtherType() {
		OtherTypeImpl otherType = new OtherTypeImpl();
		return otherType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericTestPackage getGenericTestPackage() {
		return (GenericTestPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GenericTestPackage getPackage() {
		return GenericTestPackage.eINSTANCE;
	}

} //GenericTestFactoryImpl
