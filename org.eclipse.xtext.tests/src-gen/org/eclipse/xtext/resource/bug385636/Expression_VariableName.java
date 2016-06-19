/**
 */
package org.eclipse.xtext.resource.bug385636;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Variable Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.bug385636.Expression_VariableName#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getExpression_VariableName()
 * @model
 * @generated
 */
public interface Expression_VariableName extends Expression
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(NVariableAccess)
   * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getExpression_VariableName_Variable()
   * @model containment="true"
   * @generated
   */
  NVariableAccess getVariable();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.bug385636.Expression_VariableName#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(NVariableAccess value);

} // Expression_VariableName
