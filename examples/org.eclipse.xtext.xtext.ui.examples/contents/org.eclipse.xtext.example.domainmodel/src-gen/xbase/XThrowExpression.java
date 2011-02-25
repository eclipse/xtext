/**
 * <copyright>
 * </copyright>
 *
 */
package xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XThrow Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xbase.XThrowExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXThrowExpression()
 * @model
 * @generated
 */
public interface XThrowExpression extends XExpression
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
   * @see xbase.XbasePackage#getXThrowExpression_Expression()
   * @model containment="true"
   * @generated
   */
  XExpression getExpression();

  /**
   * Sets the value of the '{@link xbase.XThrowExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(XExpression value);

} // XThrowExpression
