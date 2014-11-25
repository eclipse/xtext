/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bug310435 Val</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val#getLits <em>Lits</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getBug310435Val()
 * @model
 * @generated
 */
public interface Bug310435Val extends Expression
{
  /**
   * Returns the value of the '<em><b>Lits</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lits</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lits</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getBug310435Val_Lits()
   * @model unique="false"
   * @generated
   */
  EList<String> getLits();

} // Bug310435Val
