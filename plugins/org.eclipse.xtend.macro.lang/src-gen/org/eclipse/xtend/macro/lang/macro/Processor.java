/**
 */
package org.eclipse.xtend.macro.lang.macro;

import org.eclipse.xtend.core.xtend.XtendMember;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtend.macro.lang.macro.Processor#isEach <em>Each</em>}</li>
 *   <li>{@link org.eclipse.xtend.macro.lang.macro.Processor#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link org.eclipse.xtend.macro.lang.macro.Processor#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtend.macro.lang.macro.MacroPackage#getProcessor()
 * @model
 * @generated
 */
public interface Processor extends XtendMember
{
  /**
   * Returns the value of the '<em><b>Each</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Each</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Each</em>' attribute.
   * @see #setEach(boolean)
   * @see org.eclipse.xtend.macro.lang.macro.MacroPackage#getProcessor_Each()
   * @model
   * @generated
   */
  boolean isEach();

  /**
   * Sets the value of the '{@link org.eclipse.xtend.macro.lang.macro.Processor#isEach <em>Each</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Each</em>' attribute.
   * @see #isEach()
   * @generated
   */
  void setEach(boolean value);

  /**
   * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Name</em>' attribute.
   * @see #setVariableName(String)
   * @see org.eclipse.xtend.macro.lang.macro.MacroPackage#getProcessor_VariableName()
   * @model
   * @generated
   */
  String getVariableName();

  /**
   * Sets the value of the '{@link org.eclipse.xtend.macro.lang.macro.Processor#getVariableName <em>Variable Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Name</em>' attribute.
   * @see #getVariableName()
   * @generated
   */
  void setVariableName(String value);

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
   * @see org.eclipse.xtend.macro.lang.macro.MacroPackage#getProcessor_Expression()
   * @model containment="true"
   * @generated
   */
  XExpression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.xtend.macro.lang.macro.Processor#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(XExpression value);

} // Processor
