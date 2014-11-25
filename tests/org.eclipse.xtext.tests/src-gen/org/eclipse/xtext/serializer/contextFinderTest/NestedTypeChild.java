/**
 */
package org.eclipse.xtext.serializer.contextFinderTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Type Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild#getVal <em>Val</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getNestedTypeChild()
 * @model
 * @generated
 */
public interface NestedTypeChild extends EObject
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute.
   * @see #setVal(String)
   * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getNestedTypeChild_Val()
   * @model
   * @generated
   */
  String getVal();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see #getVal()
   * @generated
   */
  void setVal(String value);

} // NestedTypeChild
