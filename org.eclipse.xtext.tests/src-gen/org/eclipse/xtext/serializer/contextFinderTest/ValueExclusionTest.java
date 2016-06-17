/**
 */
package org.eclipse.xtext.serializer.contextFinderTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Exclusion Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTest#getVal <em>Val</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getValueExclusionTest()
 * @model
 * @generated
 */
public interface ValueExclusionTest extends EObject
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn
   * @see #setVal(ValueExclusionTestEn)
   * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getValueExclusionTest_Val()
   * @model
   * @generated
   */
  ValueExclusionTestEn getVal();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTest#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTestEn
   * @see #getVal()
   * @generated
   */
  void setVal(ValueExclusionTestEn value);

} // ValueExclusionTest
