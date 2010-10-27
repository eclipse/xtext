/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gradient</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.Gradient#getColors <em>Colors</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.Gradient#getPercents <em>Percents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getGradient()
 * @model
 * @generated
 */
public interface Gradient extends ColorLiteral
{
  /**
   * Returns the value of the '<em><b>Colors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.css.xcss.ColorLiteral}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Colors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Colors</em>' containment reference list.
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getGradient_Colors()
   * @model containment="true"
   * @generated
   */
  EList<ColorLiteral> getColors();

  /**
   * Returns the value of the '<em><b>Percents</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.css.xcss.Percent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Percents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Percents</em>' containment reference list.
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getGradient_Percents()
   * @model containment="true"
   * @generated
   */
  EList<Percent> getPercents();

} // Gradient
