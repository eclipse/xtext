/**
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Linewrap Min Max</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrapMinMax#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage#getTestLinewrapMinMax()
 * @model
 * @generated
 */
public interface TestLinewrapMinMax extends Root
{
  /**
   * Returns the value of the '<em><b>Items</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Items</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage#getTestLinewrapMinMax_Items()
   * @model containment="true"
   * @generated
   */
  EList<Line> getItems();

} // TestLinewrapMinMax
