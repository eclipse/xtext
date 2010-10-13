/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmIdentifyableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XSimple Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.XSimpleFeatureCall#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getXSimpleFeatureCall()
 * @model
 * @generated
 */
public interface XSimpleFeatureCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' reference.
   * @see #setFeature(JvmIdentifyableElement)
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getXSimpleFeatureCall_Feature()
   * @model
   * @generated
   */
  JvmIdentifyableElement getFeature();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.css.xcss.XSimpleFeatureCall#getFeature <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(JvmIdentifyableElement value);

} // XSimpleFeatureCall
