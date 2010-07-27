/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AssignmentExpression#getLeftExpr <em>Left Expr</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AssignmentExpression#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AssignmentExpression#getRightExpr <em>Right Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getAssignmentExpression()
 * @model
 * @generated
 */
public interface AssignmentExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Left Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Expr</em>' containment reference.
   * @see #setLeftExpr(Expression)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getAssignmentExpression_LeftExpr()
   * @model containment="true"
   * @generated
   */
  Expression getLeftExpr();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AssignmentExpression#getLeftExpr <em>Left Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Expr</em>' containment reference.
   * @see #getLeftExpr()
   * @generated
   */
  void setLeftExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Function Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Name</em>' attribute.
   * @see #setFunctionName(String)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getAssignmentExpression_FunctionName()
   * @model
   * @generated
   */
  String getFunctionName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AssignmentExpression#getFunctionName <em>Function Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Name</em>' attribute.
   * @see #getFunctionName()
   * @generated
   */
  void setFunctionName(String value);

  /**
   * Returns the value of the '<em><b>Right Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Expr</em>' containment reference.
   * @see #setRightExpr(Expression)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getAssignmentExpression_RightExpr()
   * @model containment="true"
   * @generated
   */
  Expression getRightExpr();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AssignmentExpression#getRightExpr <em>Right Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Expr</em>' containment reference.
   * @see #getRightExpr()
   * @generated
   */
  void setRightExpr(Expression value);

} // AssignmentExpression
