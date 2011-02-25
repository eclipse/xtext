/**
 * <copyright>
 * </copyright>
 *
 */
package xbase;

import org.eclipse.xtext.common.types.JvmFormalParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFor Loop Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xbase.XForLoopExpression#getForExpression <em>For Expression</em>}</li>
 *   <li>{@link xbase.XForLoopExpression#getEachExpression <em>Each Expression</em>}</li>
 *   <li>{@link xbase.XForLoopExpression#getDeclaredParam <em>Declared Param</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXForLoopExpression()
 * @model
 * @generated
 */
public interface XForLoopExpression extends XExpression
{
  /**
   * Returns the value of the '<em><b>For Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>For Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>For Expression</em>' containment reference.
   * @see #setForExpression(XExpression)
   * @see xbase.XbasePackage#getXForLoopExpression_ForExpression()
   * @model containment="true"
   * @generated
   */
  XExpression getForExpression();

  /**
   * Sets the value of the '{@link xbase.XForLoopExpression#getForExpression <em>For Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>For Expression</em>' containment reference.
   * @see #getForExpression()
   * @generated
   */
  void setForExpression(XExpression value);

  /**
   * Returns the value of the '<em><b>Each Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Each Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Each Expression</em>' containment reference.
   * @see #setEachExpression(XExpression)
   * @see xbase.XbasePackage#getXForLoopExpression_EachExpression()
   * @model containment="true"
   * @generated
   */
  XExpression getEachExpression();

  /**
   * Sets the value of the '{@link xbase.XForLoopExpression#getEachExpression <em>Each Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Each Expression</em>' containment reference.
   * @see #getEachExpression()
   * @generated
   */
  void setEachExpression(XExpression value);

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
   * @see xbase.XbasePackage#getXForLoopExpression_DeclaredParam()
   * @model containment="true"
   * @generated
   */
  JvmFormalParameter getDeclaredParam();

  /**
   * Sets the value of the '{@link xbase.XForLoopExpression#getDeclaredParam <em>Declared Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declared Param</em>' containment reference.
   * @see #getDeclaredParam()
   * @generated
   */
  void setDeclaredParam(JvmFormalParameter value);

} // XForLoopExpression
