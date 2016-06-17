/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.RuleCall;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo#getNameRefs <em>Name Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestPackage#getFoo()
 * @model
 * @generated
 */
public interface Foo extends EObject
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
   * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestPackage#getFoo_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Name Refs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.RuleCall}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Refs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name Refs</em>' containment reference list.
   * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestPackage#getFoo_NameRefs()
   * @model containment="true"
   * @generated
   */
  EList<RuleCall> getNameRefs();

} // Foo
