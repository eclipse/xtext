/**
 */
package org.eclipse.xtext.parser.antlr.bug301935Test;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug301935Test.Model#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug301935Test.Model#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug301935Test.Model#getValue2 <em>Value2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.antlr.bug301935Test.Bug301935TestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
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
   * @see org.eclipse.xtext.parser.antlr.bug301935Test.Bug301935TestPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug301935Test.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.xtext.parser.antlr.bug301935Test.Bug301935TestPackage#getModel_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug301935Test.Model#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Value2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value2</em>' attribute.
   * @see #setValue2(String)
   * @see org.eclipse.xtext.parser.antlr.bug301935Test.Bug301935TestPackage#getModel_Value2()
   * @model
   * @generated
   */
  String getValue2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug301935Test.Model#getValue2 <em>Value2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value2</em>' attribute.
   * @see #getValue2()
   * @generated
   */
  void setValue2(String value);

} // Model
