/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.assignments.assignmentsTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.MultiValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage#getMultiValue()
 * @model
 * @generated
 */
public interface MultiValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute list.
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage#getMultiValue_Value()
   * @model unique="false"
   * @generated
   */
  EList<String> getValue();

} // MultiValue
