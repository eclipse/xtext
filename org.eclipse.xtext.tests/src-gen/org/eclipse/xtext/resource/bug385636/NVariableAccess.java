/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.bug385636;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NVariable Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.bug385636.NVariableAccess#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getNVariableAccess()
 * @model
 * @generated
 */
public interface NVariableAccess extends EObject
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' reference.
   * @see #setVariable(DefineVariable)
   * @see org.eclipse.xtext.resource.bug385636.Bug385636Package#getNVariableAccess_Variable()
   * @model
   * @generated
   */
  DefineVariable getVariable();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.bug385636.NVariableAccess#getVariable <em>Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(DefineVariable value);

} // NVariableAccess
