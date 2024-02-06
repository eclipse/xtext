/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer.sequencertest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Null Cross Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.NullCrossRef#getRef <em>Ref</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.NullCrossRef#getFoo <em>Foo</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getNullCrossRef()
 * @model
 * @generated
 */
public interface NullCrossRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(EObject)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getNullCrossRef_Ref()
   * @model
   * @generated
   */
  EObject getRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.NullCrossRef#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(EObject value);

  /**
   * Returns the value of the '<em><b>Foo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foo</em>' attribute.
   * @see #setFoo(String)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getNullCrossRef_Foo()
   * @model
   * @generated
   */
  String getFoo();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.NullCrossRef#getFoo <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Foo</em>' attribute.
   * @see #getFoo()
   * @generated
   */
  void setFoo(String value);

} // NullCrossRef
