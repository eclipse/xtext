/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFeature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XFeatureCall#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XFeatureCall#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XFeatureCall#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXFeatureCall()
 * @model
 * @generated
 */
public interface XFeatureCall extends XExpression
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(XExpression)
   * @see org.eclipse.xtext.xpression.XpressionPackage#getXFeatureCall_Target()
   * @model containment="true"
   * @generated
   */
  XExpression getTarget();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xpression.XFeatureCall#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(XExpression value);

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
   * @see org.eclipse.xtext.xpression.XpressionPackage#getXFeatureCall_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xpression.XFeatureCall#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xpression.XExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see org.eclipse.xtext.xpression.XpressionPackage#getXFeatureCall_Params()
   * @model containment="true"
   * @generated
   */
  EList<XExpression> getParams();

} // XFeatureCall
