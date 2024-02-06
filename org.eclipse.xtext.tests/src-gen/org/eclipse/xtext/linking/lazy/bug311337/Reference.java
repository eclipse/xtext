/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.linking.lazy.bug311337;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.Reference#getRefChild <em>Ref Child</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getReference()
 * @model
 * @generated
 */
public interface Reference extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref Child</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Child</em>' reference.
   * @see #setRefChild(Child)
   * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getReference_RefChild()
   * @model
   * @generated
   */
  Child getRefChild();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.lazy.bug311337.Reference#getRefChild <em>Ref Child</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Child</em>' reference.
   * @see #getRefChild()
   * @generated
   */
  void setRefChild(Child value);

} // Reference
