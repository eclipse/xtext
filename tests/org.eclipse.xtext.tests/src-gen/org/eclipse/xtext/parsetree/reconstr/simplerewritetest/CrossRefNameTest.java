/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cross Ref Name Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest#getNamed <em>Named</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getCrossRefNameTest()
 * @model
 * @generated
 */
public interface CrossRefNameTest extends Expression
{
  /**
   * Returns the value of the '<em><b>Named</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Named</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Named</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getCrossRefNameTest_Named()
   * @model containment="true"
   * @generated
   */
  EList<CrossRefNamed> getNamed();

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference list.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getCrossRefNameTest_Ref()
   * @model
   * @generated
   */
  EList<CrossRefNamed> getRef();

} // CrossRefNameTest
