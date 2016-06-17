/**
 * <copyright>
 * </copyright>
 *
 * $Id: B.java,v 1.1 2010/02/03 18:24:43 sefftinge Exp $
 */
package org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.SimplestructurePackage#getB()
 * @model
 * @generated
 */
public interface B extends EObject {
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
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.SimplestructurePackage#getB_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>B</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>B</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>B</em>' containment reference list.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.SimplestructurePackage#getB_B()
	 * @model containment="true"
	 * @generated
	 */
	EList<B> getB();

} // B
