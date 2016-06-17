/**
 */
package org.eclipse.xtext.serializer.contextFinderTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Type Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest#getNested <em>Nested</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getNestedTypeTest()
 * @model
 * @generated
 */
public interface NestedTypeTest extends EObject
{
  /**
   * Returns the value of the '<em><b>Nested</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nested</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nested</em>' containment reference.
   * @see #setNested(NestedTypeChild)
   * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getNestedTypeTest_Nested()
   * @model containment="true"
   * @generated
   */
  NestedTypeChild getNested();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest#getNested <em>Nested</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nested</em>' containment reference.
   * @see #getNested()
   * @generated
   */
  void setNested(NestedTypeChild value);

} // NestedTypeTest
