/**
 * <copyright>
 * </copyright>
 *
 * $Id: CImpl.java,v 1.1 2010/03/31 13:22:31 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.xtext.util.genericTest.C;
import org.eclipse.xtext.util.genericTest.GenericTestPackage;
import org.eclipse.xtext.util.genericTest.SomeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>C</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CImpl<W> extends BImpl<W, SomeType> implements C<W> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericTestPackage.Literals.C;
	}

} //CImpl
