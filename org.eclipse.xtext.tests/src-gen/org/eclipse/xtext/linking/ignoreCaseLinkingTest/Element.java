/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.linking.ignoreCaseLinkingTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.ignoreCaseLinkingTest.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.ignoreCaseLinkingTest.Element#getReference <em>Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.ignoreCaseLinkingTest.Element#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.ignoreCaseLinkingTest.IgnoreCaseLinkingTestPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.linking.ignoreCaseLinkingTest.IgnoreCaseLinkingTestPackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.ignoreCaseLinkingTest.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' reference.
   * @see #setReference(Element)
   * @see org.eclipse.xtext.linking.ignoreCaseLinkingTest.IgnoreCaseLinkingTestPackage#getElement_Reference()
   * @model
   * @generated
   */
  Element getReference();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.ignoreCaseLinkingTest.Element#getReference <em>Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' reference.
   * @see #getReference()
   * @generated
   */
  void setReference(Element value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.ignoreCaseLinkingTest.Element}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.linking.ignoreCaseLinkingTest.IgnoreCaseLinkingTestPackage#getElement_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Element> getElements();

} // Element
