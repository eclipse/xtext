/**
 * <copyright>
 * </copyright>
 *
 * $Id: XTypeRefImpl.java,v 1.1 2010/01/16 08:50:51 sefftinge Exp $
 */
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xtype.XTypeRef;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XType Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class XTypeRefImpl extends MinimalEObjectImpl.Container implements XTypeRef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XTypeRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XtypePackage.Literals.XTYPE_REF;
	}

} //XTypeRefImpl
