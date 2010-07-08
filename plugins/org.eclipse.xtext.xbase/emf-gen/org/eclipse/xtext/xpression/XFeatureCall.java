/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xpression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFeature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XFeatureCall#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XFeatureCall#getParams <em>Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.xpression.XFeatureCall#getFeature <em>Feature</em>}</li>
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
   * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature Name</em>' attribute.
   * @see org.eclipse.xtext.xpression.XpressionPackage#getXFeatureCall_FeatureName()
   * @model changeable="false" derived="true"
   * @generated
   */
  String getFeatureName();

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

  /**
   * Returns the value of the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' reference.
   * @see #setFeature(EObject)
   * @see org.eclipse.xtext.xpression.XpressionPackage#getXFeatureCall_Feature()
   * @model
   * @generated
   */
  EObject getFeature();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xpression.XFeatureCall#getFeature <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(EObject value);

} // XFeatureCall
