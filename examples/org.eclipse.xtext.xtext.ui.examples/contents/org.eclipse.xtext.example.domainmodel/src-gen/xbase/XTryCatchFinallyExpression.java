/**
 * <copyright>
 * </copyright>
 *
 */
package xbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XTry Catch Finally Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xbase.XTryCatchFinallyExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link xbase.XTryCatchFinallyExpression#getFinallyExpression <em>Finally Expression</em>}</li>
 *   <li>{@link xbase.XTryCatchFinallyExpression#getCatchClauses <em>Catch Clauses</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXTryCatchFinallyExpression()
 * @model
 * @generated
 */
public interface XTryCatchFinallyExpression extends XExpression
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(XExpression)
   * @see xbase.XbasePackage#getXTryCatchFinallyExpression_Expression()
   * @model containment="true"
   * @generated
   */
  XExpression getExpression();

  /**
   * Sets the value of the '{@link xbase.XTryCatchFinallyExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(XExpression value);

  /**
   * Returns the value of the '<em><b>Finally Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Finally Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Finally Expression</em>' containment reference.
   * @see #setFinallyExpression(XExpression)
   * @see xbase.XbasePackage#getXTryCatchFinallyExpression_FinallyExpression()
   * @model containment="true"
   * @generated
   */
  XExpression getFinallyExpression();

  /**
   * Sets the value of the '{@link xbase.XTryCatchFinallyExpression#getFinallyExpression <em>Finally Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Finally Expression</em>' containment reference.
   * @see #getFinallyExpression()
   * @generated
   */
  void setFinallyExpression(XExpression value);

  /**
   * Returns the value of the '<em><b>Catch Clauses</b></em>' containment reference list.
   * The list contents are of type {@link xbase.XCatchClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Catch Clauses</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Catch Clauses</em>' containment reference list.
   * @see xbase.XbasePackage#getXTryCatchFinallyExpression_CatchClauses()
   * @model containment="true"
   * @generated
   */
  EList<XCatchClause> getCatchClauses();

} // XTryCatchFinallyExpression
