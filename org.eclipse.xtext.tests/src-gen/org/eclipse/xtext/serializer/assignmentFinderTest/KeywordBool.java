/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer.assignmentFinderTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Keyword Bool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool#isKw <em>Kw</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage#getKeywordBool()
 * @model
 * @generated
 */
public interface KeywordBool extends EObject
{
  /**
   * Returns the value of the '<em><b>Kw</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kw</em>' attribute.
   * @see #setKw(boolean)
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage#getKeywordBool_Kw()
   * @model
   * @generated
   */
  boolean isKw();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool#isKw <em>Kw</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kw</em>' attribute.
   * @see #isKw()
   * @generated
   */
  void setKw(boolean value);

} // KeywordBool
