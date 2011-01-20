/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.ColorConstant#getConstant <em>Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getColorConstant()
 * @model
 * @generated
 */
public interface ColorConstant extends ColorLiteral
{
  /**
   * Returns the value of the '<em><b>Constant</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constant</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constant</em>' reference.
   * @see #setConstant(JvmIdentifiableElement)
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getColorConstant_Constant()
   * @model
   * @generated
   */
  JvmIdentifiableElement getConstant();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.css.xcss.ColorConstant#getConstant <em>Constant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constant</em>' reference.
   * @see #getConstant()
   * @generated
   */
  void setConstant(JvmIdentifiableElement value);

} // ColorConstant
