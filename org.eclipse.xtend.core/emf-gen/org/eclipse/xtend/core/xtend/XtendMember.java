/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmVisibility;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendMember#getAnnotationInfo <em>Annotation Info</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendMember#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.xtend.core.xtend.XtendMember#getDeclaringType <em>Declaring Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendMember()
 * @model
 * @generated
 */
public interface XtendMember extends XtendAnnotationTarget
{
	/**
	 * Returns the value of the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Info</em>' containment reference.
	 * @see #setAnnotationInfo(XtendAnnotationTarget)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendMember_AnnotationInfo()
	 * @model containment="true"
	 * @generated
	 */
	XtendAnnotationTarget getAnnotationInfo();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendMember#getAnnotationInfo <em>Annotation Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Info</em>' containment reference.
	 * @see #getAnnotationInfo()
	 * @generated
	 */
	void setAnnotationInfo(XtendAnnotationTarget value);

	/**
	 * Returns the value of the '<em><b>Modifiers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifiers</em>' attribute list.
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendMember_Modifiers()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getModifiers();

	/**
	 * Returns the value of the '<em><b>Declaring Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtend.core.xtend.XtendTypeDeclaration#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaring Type</em>' container reference.
	 * @see #setDeclaringType(XtendTypeDeclaration)
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#getXtendMember_DeclaringType()
	 * @see org.eclipse.xtend.core.xtend.XtendTypeDeclaration#getMembers
	 * @model opposite="members" transient="false"
	 * @generated
	 */
	XtendTypeDeclaration getDeclaringType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtend.core.xtend.XtendMember#getDeclaringType <em>Declaring Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Type</em>' container reference.
	 * @see #getDeclaringType()
	 * @generated
	 */
	void setDeclaringType(XtendTypeDeclaration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmVisibility getVisibility();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmVisibility getDeclaredVisibility();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStatic();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isFinal();

} // XtendMember
