/**
 * <copyright>
 * </copyright>
 *
 */
package xbase;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmFormalParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XCatch Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xbase.XCatchClause#getExpression <em>Expression</em>}</li>
 *   <li>{@link xbase.XCatchClause#getDeclaredParam <em>Declared Param</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXCatchClause()
 * @model
 * @generated
 */
public interface XCatchClause extends EObject
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
   * @see xbase.XbasePackage#getXCatchClause_Expression()
   * @model containment="true"
   * @generated
   */
  XExpression getExpression();

  /**
   * Sets the value of the '{@link xbase.XCatchClause#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(XExpression value);

  /**
   * Returns the value of the '<em><b>Declared Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declared Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declared Param</em>' containment reference.
   * @see #setDeclaredParam(JvmFormalParameter)
   * @see xbase.XbasePackage#getXCatchClause_DeclaredParam()
   * @model containment="true"
   * @generated
   */
  JvmFormalParameter getDeclaredParam();

  /**
   * Sets the value of the '{@link xbase.XCatchClause#getDeclaredParam <em>Declared Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declared Param</em>' containment reference.
   * @see #getDeclaredParam()
   * @generated
   */
  void setDeclaredParam(JvmFormalParameter value);

} // XCatchClause
