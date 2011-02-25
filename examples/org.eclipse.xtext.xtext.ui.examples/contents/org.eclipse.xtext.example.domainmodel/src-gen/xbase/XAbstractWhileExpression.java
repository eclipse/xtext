/**
 * <copyright>
 * </copyright>
 *
 */
package xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAbstract While Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xbase.XAbstractWhileExpression#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link xbase.XAbstractWhileExpression#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXAbstractWhileExpression()
 * @model abstract="true"
 * @generated
 */
public interface XAbstractWhileExpression extends XExpression
{
  /**
   * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predicate</em>' containment reference.
   * @see #setPredicate(XExpression)
   * @see xbase.XbasePackage#getXAbstractWhileExpression_Predicate()
   * @model containment="true"
   * @generated
   */
  XExpression getPredicate();

  /**
   * Sets the value of the '{@link xbase.XAbstractWhileExpression#getPredicate <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predicate</em>' containment reference.
   * @see #getPredicate()
   * @generated
   */
  void setPredicate(XExpression value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(XExpression)
   * @see xbase.XbasePackage#getXAbstractWhileExpression_Body()
   * @model containment="true"
   * @generated
   */
  XExpression getBody();

  /**
   * Sets the value of the '{@link xbase.XAbstractWhileExpression#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(XExpression value);

} // XAbstractWhileExpression
