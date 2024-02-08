/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
