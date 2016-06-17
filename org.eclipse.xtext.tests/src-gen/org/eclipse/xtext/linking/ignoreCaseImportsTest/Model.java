/**
 */
package org.eclipse.xtext.linking.ignoreCaseImportsTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.ignoreCaseImportsTest.Model#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.IgnoreCaseImportsTestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends org.eclipse.xtext.linking.ignoreCaseLinkingTest.Model
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.ignoreCaseImportsTest.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.IgnoreCaseImportsTestPackage#getModel_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

} // Model
