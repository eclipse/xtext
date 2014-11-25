/**
 */
package org.eclipse.xtext.parser.assignments.bug288432Test;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.Parameter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends EObject
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
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getParameter_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Parameter#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(ParameterObject)
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getParameter_Value()
   * @model
   * @generated
   */
  ParameterObject getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Parameter#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ParameterObject value);

} // Parameter
