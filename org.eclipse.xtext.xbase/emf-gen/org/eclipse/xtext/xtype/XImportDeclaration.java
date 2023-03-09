/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmDeclaredType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XImport Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 2.7
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.XImportDeclaration#isWildcard <em>Wildcard</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XImportDeclaration#isExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XImportDeclaration#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XImportDeclaration#getImportedType <em>Imported Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XImportDeclaration#getMemberName <em>Member Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XImportDeclaration#getImportedNamespace <em>Imported Namespace</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getXImportDeclaration()
 * @model
 * @generated
 */
public interface XImportDeclaration extends EObject
{
	/**
	 * Returns the value of the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wildcard</em>' attribute.
	 * @see #setWildcard(boolean)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXImportDeclaration_Wildcard()
	 * @model
	 * @generated
	 */
	boolean isWildcard();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XImportDeclaration#isWildcard <em>Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wildcard</em>' attribute.
	 * @see #isWildcard()
	 * @generated
	 */
	void setWildcard(boolean value);

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(boolean)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXImportDeclaration_Extension()
	 * @model
	 * @generated
	 */
	boolean isExtension();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XImportDeclaration#isExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #isExtension()
	 * @generated
	 */
	void setExtension(boolean value);

	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXImportDeclaration_Static()
	 * @model
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XImportDeclaration#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Imported Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Type</em>' reference.
	 * @see #setImportedType(JvmDeclaredType)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXImportDeclaration_ImportedType()
	 * @model
	 * @generated
	 */
	JvmDeclaredType getImportedType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XImportDeclaration#getImportedType <em>Imported Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Type</em>' reference.
	 * @see #getImportedType()
	 * @generated
	 */
	void setImportedType(JvmDeclaredType value);

	/**
	 * Returns the value of the '<em><b>Member Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Name</em>' attribute.
	 * @see #setMemberName(String)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXImportDeclaration_MemberName()
	 * @model
	 * @generated
	 */
	String getMemberName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XImportDeclaration#getMemberName <em>Member Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Name</em>' attribute.
	 * @see #getMemberName()
	 * @generated
	 */
	void setMemberName(String value);

	/**
	 * Returns the value of the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Namespace</em>' attribute.
	 * @see #setImportedNamespace(String)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXImportDeclaration_ImportedNamespace()
	 * @model
	 * @generated
	 */
	String getImportedNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XImportDeclaration#getImportedNamespace <em>Imported Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Namespace</em>' attribute.
	 * @see #getImportedNamespace()
	 * @generated
	 */
	void setImportedNamespace(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns the name that has been imported.</p>
	 * <p>For types and wildcard import declarations returns a qualified type name, e.g. java.lang.String.</p>
	 * <p>For member import declarations returns a qualified member name, e.g. java.lang.String.valueOf.</p>
	 * <p>
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getImportedName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getImportedTypeName();

} // XImportDeclaration
