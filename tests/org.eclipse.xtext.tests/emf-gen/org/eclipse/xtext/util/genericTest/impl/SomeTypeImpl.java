/**
 * <copyright>
 * </copyright>
 *
 * $Id: SomeTypeImpl.java,v 1.1 2010/03/31 13:22:30 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.util.genericTest.GenericTestPackage;
import org.eclipse.xtext.util.genericTest.SomeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Some Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SomeTypeImpl extends EObjectImpl implements SomeType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SomeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericTestPackage.Literals.SOME_TYPE;
	}

} //SomeTypeImpl
