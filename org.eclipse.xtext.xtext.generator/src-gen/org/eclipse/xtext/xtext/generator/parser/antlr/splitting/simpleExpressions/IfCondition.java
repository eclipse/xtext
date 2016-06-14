/**
 */
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition#isElseif <em>Elseif</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.SimpleExpressionsPackage#getIfCondition()
 * @model
 * @generated
 */
public interface IfCondition extends EObject
{
  /**
   * Returns the value of the '<em><b>Elseif</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elseif</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elseif</em>' attribute.
   * @see #setElseif(boolean)
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.SimpleExpressionsPackage#getIfCondition_Elseif()
   * @model
   * @generated
   */
  boolean isElseif();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition#isElseif <em>Elseif</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Elseif</em>' attribute.
   * @see #isElseif()
   * @generated
   */
  void setElseif(boolean value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expression)
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.SimpleExpressionsPackage#getIfCondition_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expression value);

} // IfCondition
