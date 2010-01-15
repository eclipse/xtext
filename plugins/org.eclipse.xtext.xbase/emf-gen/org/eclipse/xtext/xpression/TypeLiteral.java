/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeLiteral.java,v 1.1 2010/01/15 08:16:16 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

import org.eclipse.xtext.common.types.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.TypeLiteral#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getTypeLiteral()
 * @model
 * @generated
 */
public interface TypeLiteral extends Expression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getTypeLiteral_Type()
	 * @model required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.TypeLiteral#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // TypeLiteral
