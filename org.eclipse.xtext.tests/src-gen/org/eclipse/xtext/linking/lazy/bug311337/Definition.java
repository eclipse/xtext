/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.linking.lazy.bug311337;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.Definition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.Definition#getChild <em>Child</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.Definition#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getDefinition()
 * @model
 * @generated
 */
public interface Definition extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getDefinition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.lazy.bug311337.Definition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Child</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.lazy.bug311337.Child}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference list.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getDefinition_Child()
   * @model containment="true"
   * @generated
   */
  EList<Child> getChild();

  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.lazy.bug311337.Reference}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference list.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getDefinition_Ref()
   * @model containment="true"
   * @generated
   */
  EList<Reference> getRef();

} // Definition
