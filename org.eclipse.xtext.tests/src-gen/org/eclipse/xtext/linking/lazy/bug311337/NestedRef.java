/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.linking.lazy.bug311337;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.NestedRef#getLeft <em>Left</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getNestedRef()
 * @model
 * @generated
 */
public interface NestedRef extends Reference
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Reference)
   * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getNestedRef_Left()
   * @model containment="true"
   * @generated
   */
  Reference getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.lazy.bug311337.NestedRef#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Reference value);

} // NestedRef
