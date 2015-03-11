/**
 */
package org.eclipse.xtext.grammarinheritance.foo;

import org.eclipse.xtext.grammarinheritance.ametamodel.AModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Overriden Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule#getCall <em>Call</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage#getCallOverridenParserRule()
 * @model
 * @generated
 */
public interface CallOverridenParserRule extends RootRule
{
  /**
   * Returns the value of the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' containment reference.
   * @see #setCall(AModel)
   * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage#getCallOverridenParserRule_Call()
   * @model containment="true"
   * @generated
   */
  AModel getCall();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule#getCall <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' containment reference.
   * @see #getCall()
   * @generated
   */
  void setCall(AModel value);

} // CallOverridenParserRule
