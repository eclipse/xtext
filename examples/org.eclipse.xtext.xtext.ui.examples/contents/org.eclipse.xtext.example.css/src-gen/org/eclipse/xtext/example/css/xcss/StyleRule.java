/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.css.xcss;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XBinaryOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Style Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.StyleRule#getSelectors <em>Selectors</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.css.xcss.StyleRule#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getStyleRule()
 * @model
 * @generated
 */
public interface StyleRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Selectors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.css.xcss.Selector}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selectors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selectors</em>' containment reference list.
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getStyleRule_Selectors()
   * @model containment="true"
   * @generated
   */
  EList<Selector> getSelectors();

  /**
   * Returns the value of the '<em><b>Settings</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.XBinaryOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Settings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Settings</em>' containment reference list.
   * @see org.eclipse.xtext.example.css.xcss.XcssPackage#getStyleRule_Settings()
   * @model containment="true"
   * @generated
   */
  EList<XBinaryOperation> getSettings();

} // StyleRule
