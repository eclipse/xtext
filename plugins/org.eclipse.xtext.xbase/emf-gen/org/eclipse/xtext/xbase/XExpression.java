/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XExpression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XExpression#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXExpression()
 * @model abstract="true"
 * @generated
 */
public interface XExpression extends EObject
{
	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JvmTypeReference)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXExpression_ReturnType()
	 * @model containment="true" derived="true"
	 * @generated
	 */
	JvmTypeReference getReturnType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XExpression#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JvmTypeReference value);

} // XExpression
