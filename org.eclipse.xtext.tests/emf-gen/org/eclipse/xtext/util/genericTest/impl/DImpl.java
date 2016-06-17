/**
 * <copyright>
 * </copyright>
 *
 * $Id: DImpl.java,v 1.1 2010/03/31 13:22:30 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.xtext.util.genericTest.D;
import org.eclipse.xtext.util.genericTest.GenericTestPackage;
import org.eclipse.xtext.util.genericTest.OtherType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DImpl extends CImpl<OtherType> implements D {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericTestPackage.Literals.D;
	}

} //DImpl
