/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Reference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.DomainModelTestPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends Property
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.DomainModelTestPackage#getReference_Type()
   * @model
   * @generated
   */
  org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Reference#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class value);

} // Reference
