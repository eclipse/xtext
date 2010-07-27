/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>At Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AtExpression#getObjExpr <em>Obj Expr</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AtExpression#getIndexExpr <em>Index Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getAtExpression()
 * @model
 * @generated
 */
public interface AtExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Obj Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Obj Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Obj Expr</em>' containment reference.
   * @see #setObjExpr(Expression)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getAtExpression_ObjExpr()
   * @model containment="true"
   * @generated
   */
  Expression getObjExpr();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AtExpression#getObjExpr <em>Obj Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Obj Expr</em>' containment reference.
   * @see #getObjExpr()
   * @generated
   */
  void setObjExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Index Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index Expr</em>' containment reference.
   * @see #setIndexExpr(Expression)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getAtExpression_IndexExpr()
   * @model containment="true"
   * @generated
   */
  Expression getIndexExpr();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AtExpression#getIndexExpr <em>Index Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index Expr</em>' containment reference.
   * @see #getIndexExpr()
   * @generated
   */
  void setIndexExpr(Expression value);

} // AtExpression
