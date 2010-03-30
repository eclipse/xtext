/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.arithmetics.arithmetics;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.arithmetics.arithmetics.Definition#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.arithmetics.arithmetics.Definition#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage#getDefinition()
 * @model
 * @generated
 */
public interface Definition extends Statement, AbstractDefinition
{
  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage#getDefinition_Args()
   * @model containment="true"
   * @generated
   */
  EList<DeclaredParameter> getArgs();

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
   * @see org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage#getDefinition_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.arithmetics.arithmetics.Definition#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // Definition
