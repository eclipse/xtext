/**
 * <copyright>
 * </copyright>
 *
 */
package xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBlock Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xbase.XBlockExpression#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXBlockExpression()
 * @model
 * @generated
 */
public interface XBlockExpression extends XExpression
{
  /**
   * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
   * The list contents are of type {@link xbase.XExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expressions</em>' containment reference list.
   * @see xbase.XbasePackage#getXBlockExpression_Expressions()
   * @model containment="true"
   * @generated
   */
  EList<XExpression> getExpressions();

} // XBlockExpression
