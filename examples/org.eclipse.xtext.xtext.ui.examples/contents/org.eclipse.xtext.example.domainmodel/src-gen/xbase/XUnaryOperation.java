/**
 * <copyright>
 * </copyright>
 *
 */
package xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XUnary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xbase.XUnaryOperation#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXUnaryOperation()
 * @model
 * @generated
 */
public interface XUnaryOperation extends XAbstractFeatureCall
{
  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(XExpression)
   * @see xbase.XbasePackage#getXUnaryOperation_Operand()
   * @model containment="true"
   * @generated
   */
  XExpression getOperand();

  /**
   * Sets the value of the '{@link xbase.XUnaryOperation#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(XExpression value);

} // XUnaryOperation
