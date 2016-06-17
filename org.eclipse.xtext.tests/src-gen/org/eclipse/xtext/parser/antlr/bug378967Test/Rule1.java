/**
 */
package org.eclipse.xtext.parser.antlr.bug378967Test;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRule1()
 * @model
 * @generated
 */
public interface Rule1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum
   * @see #setType(FirstEnum)
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRule1_Type()
   * @model
   * @generated
   */
  FirstEnum getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.FirstEnum
   * @see #getType()
   * @generated
   */
  void setType(FirstEnum value);

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
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRule1_Value()
   * @model
   * @generated
   */
  int getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(int value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' attribute.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum
   * @see #setUnit(SecondEnum)
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRule1_Unit()
   * @model
   * @generated
   */
  SecondEnum getUnit();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Rule1#getUnit <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' attribute.
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.SecondEnum
   * @see #getUnit()
   * @generated
   */
  void setUnit(SecondEnum value);

} // Rule1
