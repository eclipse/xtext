/**
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal.formattertestlanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguagePackage
 * @generated
 */
public interface FormattertestlanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FormattertestlanguageFactory eINSTANCE = org.eclipse.xtext.formatting2.internal.formattertestlanguage.impl.FormattertestlanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root</em>'.
   * @generated
   */
  Root createRoot();

  /**
   * Returns a new object of class '<em>ID List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ID List</em>'.
   * @generated
   */
  IDList createIDList();

  /**
   * Returns a new object of class '<em>KW List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>KW List</em>'.
   * @generated
   */
  KWList createKWList();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FormattertestlanguagePackage getFormattertestlanguagePackage();

} //FormattertestlanguageFactory