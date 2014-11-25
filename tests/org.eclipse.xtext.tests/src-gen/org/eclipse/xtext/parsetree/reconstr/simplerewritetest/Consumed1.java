/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consumed1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1#getV1 <em>V1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1#getV2 <em>V2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getConsumed1()
 * @model
 * @generated
 */
public interface Consumed1 extends Expression
{
  /**
   * Returns the value of the '<em><b>V1</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>V1</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>V1</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getConsumed1_V1()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getV1();

  /**
   * Returns the value of the '<em><b>V2</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>V2</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>V2</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getConsumed1_V2()
   * @model unique="false"
   * @generated
   */
  EList<String> getV2();

} // Consumed1
