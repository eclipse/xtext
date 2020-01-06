/**
 * ******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  ******************************************************************************
 */
package org.eclipse.xtext.example.arithmetics.arithmetics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.arithmetics.arithmetics.Import#getModule <em>Module</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject
{
  /**
   * Returns the value of the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module</em>' reference.
   * @see #setModule(org.eclipse.xtext.example.arithmetics.arithmetics.Module)
   * @see org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage#getImport_Module()
   * @model
   * @generated
   */
  org.eclipse.xtext.example.arithmetics.arithmetics.Module getModule();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.arithmetics.arithmetics.Import#getModule <em>Module</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module</em>' reference.
   * @see #getModule()
   * @generated
   */
  void setModule(org.eclipse.xtext.example.arithmetics.arithmetics.Module value);

} // Import
