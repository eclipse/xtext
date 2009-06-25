/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.CompositeType#getBaseType <em>Base Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage#getCompositeType()
 * @model
 * @generated
 */
public interface CompositeType extends Type
{
  /**
   * Returns the value of the '<em><b>Base Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Type</em>' containment reference.
   * @see #setBaseType(CompositeTypeEntry)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage#getCompositeType_BaseType()
   * @model containment="true"
   * @generated
   */
  CompositeTypeEntry getBaseType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.CompositeType#getBaseType <em>Base Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base Type</em>' containment reference.
   * @see #getBaseType()
   * @generated
   */
  void setBaseType(CompositeTypeEntry value);

} // CompositeType
