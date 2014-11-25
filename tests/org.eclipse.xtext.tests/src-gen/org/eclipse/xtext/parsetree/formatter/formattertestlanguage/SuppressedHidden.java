/**
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Suppressed Hidden</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHidden#getVals <em>Vals</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage#getSuppressedHidden()
 * @model
 * @generated
 */
public interface SuppressedHidden extends Line
{
  /**
   * Returns the value of the '<em><b>Vals</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.SuppressedHiddenSub}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vals</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage#getSuppressedHidden_Vals()
   * @model containment="true"
   * @generated
   */
  EList<SuppressedHiddenSub> getVals();

} // SuppressedHidden
