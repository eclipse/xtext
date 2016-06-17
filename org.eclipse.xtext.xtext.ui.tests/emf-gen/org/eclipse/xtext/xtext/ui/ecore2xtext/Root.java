/**
 * <copyright>
 * </copyright>
 *
 * $Id: Root.java,v 1.1 2010/01/08 12:38:23 jkohnlein Exp $
 */
package org.eclipse.xtext.xtext.ui.ecore2xtext;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Root#getClasses <em>Classes</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Root#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2xtextPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtext.ui.ecore2xtext.Abstract}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2xtextPackage#getRoot_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Abstract> getClasses();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2xtextPackage#getRoot_Name()
	 * @model id="true" dataType="org.eclipse.xtext.xtext.ui.ecore2xtext.INT"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Root#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Root
