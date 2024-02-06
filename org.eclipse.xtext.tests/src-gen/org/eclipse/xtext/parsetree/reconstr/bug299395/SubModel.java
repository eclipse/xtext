/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.reconstr.bug299395;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.SubModel#getStrings <em>Strings</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getSubModel()
 * @model
 * @generated
 */
public interface SubModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Strings</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Strings</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getSubModel_Strings()
   * @model unique="false"
   * @generated
   */
  EList<String> getStrings();

} // SubModel
