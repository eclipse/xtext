/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.NestedRefsPackage
 * @generated
 */
public interface NestedRefsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  NestedRefsFactory eINSTANCE = org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.impl.NestedRefsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Doc</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Doc</em>'.
   * @generated
   */
  Doc createDoc();

  /**
   * Returns a new object of class '<em>Self Refering Decl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Self Refering Decl</em>'.
   * @generated
   */
  SelfReferingDecl createSelfReferingDecl();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  NestedRefsPackage getNestedRefsPackage();

} //NestedRefsFactory
