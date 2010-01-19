/**
 * <copyright>
 * </copyright>
 *
 * $Id: XAssignment.java,v 1.2 2010/01/19 19:53:10 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAssignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XAssignment#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XAssignment#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXAssignment()
 * @model
 * @generated
 */
public interface XAssignment extends XExpression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(XExpression)
   * @see org.eclipse.xtext.xpression.XpressionPackage#getXAssignment_Left()
   * @model containment="true"
   * @generated
   */
  XExpression getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xpression.XAssignment#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(XExpression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(XExpression)
   * @see org.eclipse.xtext.xpression.XpressionPackage#getXAssignment_Right()
   * @model containment="true"
   * @generated
   */
  XExpression getRight();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xpression.XAssignment#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(XExpression value);

} // XAssignment
