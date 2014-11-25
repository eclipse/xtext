/**
 */
package org.eclipse.xtext.parser.antlr.bug296889Test;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug296889Test.Postop#getExpr <em>Expr</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug296889Test.Postop#getFunctionName <em>Function Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.antlr.bug296889Test.Bug296889TestPackage#getPostop()
 * @model
 * @generated
 */
public interface Postop extends Expression
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see org.eclipse.xtext.parser.antlr.bug296889Test.Bug296889TestPackage#getPostop_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug296889Test.Postop#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

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
   * @see org.eclipse.xtext.parser.antlr.bug296889Test.Bug296889TestPackage#getPostop_FunctionName()
   * @model
   * @generated
   */
  String getFunctionName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug296889Test.Postop#getFunctionName <em>Function Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Name</em>' attribute.
   * @see #getFunctionName()
   * @generated
   */
  void setFunctionName(String value);

} // Postop
