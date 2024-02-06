/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>First Concrete</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete#getReferencedContainer <em>Referenced Container</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getFirstConcrete()
 * @model
 * @generated
 */
public interface FirstConcrete extends AbstractChild
{
  /**
   * Returns the value of the '<em><b>Referenced Container</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Container</em>' reference.
   * @see #setReferencedContainer(SomeContainer)
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getFirstConcrete_ReferencedContainer()
   * @model
   * @generated
   */
  SomeContainer getReferencedContainer();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete#getReferencedContainer <em>Referenced Container</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Container</em>' reference.
   * @see #getReferencedContainer()
   * @generated
   */
  void setReferencedContainer(SomeContainer value);

} // FirstConcrete
