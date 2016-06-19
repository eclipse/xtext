/**
 */
package org.eclipse.xtext.parser.assignments.bug288432Test;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.Foo#getFooValue <em>Foo Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getFoo()
 * @model
 * @generated
 */
public interface Foo extends EObject
{
  /**
   * Returns the value of the '<em><b>Foo Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Foo Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foo Value</em>' attribute.
   * @see #setFooValue(String)
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getFoo_FooValue()
   * @model
   * @generated
   */
  String getFooValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Foo#getFooValue <em>Foo Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Foo Value</em>' attribute.
   * @see #getFooValue()
   * @generated
   */
  void setFooValue(String value);

} // Foo
