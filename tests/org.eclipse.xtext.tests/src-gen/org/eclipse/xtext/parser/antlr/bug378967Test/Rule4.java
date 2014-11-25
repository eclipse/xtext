/**
 */
package org.eclipse.xtext.parser.antlr.bug378967Test;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule4</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getAfter <em>After</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getS <em>S</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRule4()
 * @model
 * @generated
 */
public interface Rule4 extends EObject
{
  /**
   * Returns the value of the '<em><b>After</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>After</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>After</em>' containment reference.
   * @see #setAfter(AfterObj)
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRule4_After()
   * @model containment="true"
   * @generated
   */
  AfterObj getAfter();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getAfter <em>After</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>After</em>' containment reference.
   * @see #getAfter()
   * @generated
   */
  void setAfter(AfterObj value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(int)
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRule4_Value()
   * @model
   * @generated
   */
  int getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(int value);

  /**
   * Returns the value of the '<em><b>S</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>S</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>S</em>' containment reference.
   * @see #setS(SObj)
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRule4_S()
   * @model containment="true"
   * @generated
   */
  SObj getS();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule4#getS <em>S</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>S</em>' containment reference.
   * @see #getS()
   * @generated
   */
  void setS(SObj value);

} // Rule4
