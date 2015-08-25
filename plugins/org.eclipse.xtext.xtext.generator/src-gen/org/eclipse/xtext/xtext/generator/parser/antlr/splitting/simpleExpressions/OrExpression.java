/**
 */
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.SimpleExpressionsPackage#getOrExpression()
 * @model
 * @generated
 */
public interface OrExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.SimpleExpressionsPackage#getOrExpression_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.SimpleExpressionsPackage#getOrExpression_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // OrExpression
