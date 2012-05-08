/**
 */
package org.eclipse.xtext.purexbase.pureXbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xbase.XBlockExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Special Block Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.purexbase.pureXbase.SpecialBlockExpression#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.purexbase.pureXbase.PureXbasePackage#getSpecialBlockExpression()
 * @model
 * @generated
 */
public interface SpecialBlockExpression extends XBlockExpression
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.purexbase.pureXbase.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.xtext.purexbase.pureXbase.PureXbasePackage#getSpecialBlockExpression_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

} // SpecialBlockExpression
