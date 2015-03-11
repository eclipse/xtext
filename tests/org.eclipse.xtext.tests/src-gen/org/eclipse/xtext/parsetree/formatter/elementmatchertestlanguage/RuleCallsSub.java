/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Calls Sub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getCall1 <em>Call1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getCall2 <em>Call2</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getSub <em>Sub</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getRuleCallsSub()
 * @model
 * @generated
 */
public interface RuleCallsSub extends RuleCalls
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getRuleCallsSub_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Call1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call1</em>' containment reference.
   * @see #setCall1(RuleCallsAss1)
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getRuleCallsSub_Call1()
   * @model containment="true"
   * @generated
   */
  RuleCallsAss1 getCall1();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getCall1 <em>Call1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call1</em>' containment reference.
   * @see #getCall1()
   * @generated
   */
  void setCall1(RuleCallsAss1 value);

  /**
   * Returns the value of the '<em><b>Call2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call2</em>' containment reference.
   * @see #setCall2(RuleCallsAss2)
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getRuleCallsSub_Call2()
   * @model containment="true"
   * @generated
   */
  RuleCallsAss2 getCall2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getCall2 <em>Call2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call2</em>' containment reference.
   * @see #getCall2()
   * @generated
   */
  void setCall2(RuleCallsAss2 value);

  /**
   * Returns the value of the '<em><b>Sub</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub</em>' attribute.
   * @see #setSub(String)
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getRuleCallsSub_Sub()
   * @model
   * @generated
   */
  String getSub();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub#getSub <em>Sub</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub</em>' attribute.
   * @see #getSub()
   * @generated
   */
  void setSub(String value);

} // RuleCallsSub
