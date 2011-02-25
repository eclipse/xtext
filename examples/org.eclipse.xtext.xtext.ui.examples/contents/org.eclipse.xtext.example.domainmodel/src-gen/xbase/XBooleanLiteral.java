/**
 * <copyright>
 * </copyright>
 *
 */
package xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBoolean Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xbase.XBooleanLiteral#isIsTrue <em>Is True</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXBooleanLiteral()
 * @model
 * @generated
 */
public interface XBooleanLiteral extends XExpression
{
  /**
   * Returns the value of the '<em><b>Is True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is True</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is True</em>' attribute.
   * @see #setIsTrue(boolean)
   * @see xbase.XbasePackage#getXBooleanLiteral_IsTrue()
   * @model
   * @generated
   */
  boolean isIsTrue();

  /**
   * Sets the value of the '{@link xbase.XBooleanLiteral#isIsTrue <em>Is True</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is True</em>' attribute.
   * @see #isIsTrue()
   * @generated
   */
  void setIsTrue(boolean value);

} // XBooleanLiteral
