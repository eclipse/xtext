/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xpression;

import org.eclipse.xtext.common.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XInstance Of Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XInstanceOfExpression#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XInstanceOfExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXInstanceOfExpression()
 * @model
 * @generated
 */
public interface XInstanceOfExpression extends XExpression
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(JvmType)
   * @see org.eclipse.xtext.xpression.XpressionPackage#getXInstanceOfExpression_Type()
   * @model required="true"
   * @generated
   */
  JvmType getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xpression.XInstanceOfExpression#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmType value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(XExpression)
   * @see org.eclipse.xtext.xpression.XpressionPackage#getXInstanceOfExpression_Expression()
   * @model containment="true" required="true"
   * @generated
   */
  XExpression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xpression.XInstanceOfExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(XExpression value);

} // XInstanceOfExpression
