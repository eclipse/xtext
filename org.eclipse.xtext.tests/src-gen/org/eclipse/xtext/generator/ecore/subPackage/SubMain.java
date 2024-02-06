/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.ecore.subPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.ecore.superPackage.SuperMain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Main</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.ecore.subPackage.SubMain#getSuperMains <em>Super Mains</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.ecore.subPackage.SubMain#getAnother <em>Another</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.ecore.subPackage.SubPackagePackage#getSubMain()
 * @model
 * @generated
 */
public interface SubMain extends EObject
{
  /**
   * Returns the value of the '<em><b>Super Mains</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.generator.ecore.superPackage.SuperMain}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Mains</em>' containment reference list.
   * @see org.eclipse.xtext.generator.ecore.subPackage.SubPackagePackage#getSubMain_SuperMains()
   * @model containment="true"
   * @generated
   */
  EList<SuperMain> getSuperMains();

  /**
   * Returns the value of the '<em><b>Another</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Another</em>' containment reference.
   * @see #setAnother(AnotherSuperMain)
   * @see org.eclipse.xtext.generator.ecore.subPackage.SubPackagePackage#getSubMain_Another()
   * @model containment="true"
   * @generated
   */
  AnotherSuperMain getAnother();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.ecore.subPackage.SubMain#getAnother <em>Another</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Another</em>' containment reference.
   * @see #getAnother()
   * @generated
   */
  void setAnother(AnotherSuperMain value);

} // SubMain
