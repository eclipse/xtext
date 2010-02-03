/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.lookAheadContentAssistTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.lookAheadContentAssistTest.Attribute#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.lookAheadContentAssistTest.LookAheadContentAssistTestPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.lookAheadContentAssistTest.LookAheadContentAssistTestPackage#getAttribute_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.lookAheadContentAssistTest.Attribute#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // Attribute
