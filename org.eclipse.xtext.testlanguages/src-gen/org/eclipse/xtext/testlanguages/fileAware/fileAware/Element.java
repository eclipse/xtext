/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.fileAware.fileAware;

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
 *   <li>{@link org.eclipse.xtext.testlanguages.fileAware.fileAware.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.fileAware.fileAware.Element#getContents <em>Contents</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.fileAware.fileAware.Element#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage#getElement()
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
   * @see org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.fileAware.fileAware.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.fileAware.fileAware.Element}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contents</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage#getElement_Contents()
   * @model containment="true"
   * @generated
   */
  EList<Element> getContents();

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.fileAware.fileAware.Element}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference list.
   * @see org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage#getElement_Ref()
   * @model
   * @generated
   */
  EList<Element> getRef();

} // Element
