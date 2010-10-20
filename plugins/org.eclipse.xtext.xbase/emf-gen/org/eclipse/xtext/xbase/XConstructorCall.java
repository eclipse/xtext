/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XConstructor Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XConstructorCall#getTypeArguments <em>Type Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall()
 * @model
 * @generated
 */
public interface XConstructorCall extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Constructor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constructor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructor</em>' reference.
	 * @see #setConstructor(JvmConstructor)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_Constructor()
	 * @model
	 * @generated
	 */
	JvmConstructor getConstructor();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XConstructorCall#getConstructor <em>Constructor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constructor</em>' reference.
	 * @see #getConstructor()
	 * @generated
	 */
	void setConstructor(JvmConstructor value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getArguments();

	/**
	 * Returns the value of the '<em><b>Type Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXConstructorCall_TypeArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getTypeArguments();

} // XConstructorCall
