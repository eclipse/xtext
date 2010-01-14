/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConstructorCall.java,v 1.1 2010/01/14 14:40:20 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xtype.TypeRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.ConstructorCall#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.ConstructorCall#getParams <em>Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.ConstructorCall#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getConstructorCall()
 * @model
 * @generated
 */
public interface ConstructorCall extends Expression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeRef)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getConstructorCall_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeRef getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.ConstructorCall#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeRef value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xpression.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getConstructorCall_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getParams();

	/**
	 * Returns the value of the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initializer</em>' containment reference.
	 * @see #setInitializer(BlockExpression)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getConstructorCall_Initializer()
	 * @model containment="true"
	 * @generated
	 */
	BlockExpression getInitializer();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.ConstructorCall#getInitializer <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializer</em>' containment reference.
	 * @see #getInitializer()
	 * @generated
	 */
	void setInitializer(BlockExpression value);

} // ConstructorCall
