/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.bug462047.bug462047;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.bug462047.bug462047.Bug462047Root#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.testlanguages.bug462047.bug462047.Bug462047Package#getBug462047Root()
 * @model
 * @generated
 */
public interface Bug462047Root extends EObject
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.testlanguages.bug462047.bug462047.Bug462047Element}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.xbase.testlanguages.bug462047.bug462047.Bug462047Package#getBug462047Root_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Bug462047Element> getElements();

} // Bug462047Root
