/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Type Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeTypeEntry#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage#getCompositeTypeEntry()
 * @model
 * @generated
 */
public interface CompositeTypeEntry extends EObject
{
  /**
   * Returns the value of the '<em><b>Data Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Type</em>' reference.
   * @see #setDataType(Type)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage#getCompositeTypeEntry_DataType()
   * @model
   * @generated
   */
  Type getDataType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeTypeEntry#getDataType <em>Data Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Type</em>' reference.
   * @see #getDataType()
   * @generated
   */
  void setDataType(Type value);

} // CompositeTypeEntry
