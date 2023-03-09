/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.IndentationAwareUiTestLanguagePackage
 * @generated
 */
public interface IndentationAwareUiTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IndentationAwareUiTestLanguageFactory eINSTANCE = org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.impl.IndentationAwareUiTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Tree</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tree</em>'.
   * @generated
   */
  Tree createTree();

  /**
   * Returns a new object of class '<em>Tree Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tree Node</em>'.
   * @generated
   */
  TreeNode createTreeNode();

  /**
   * Returns a new object of class '<em>Other Tree Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Other Tree Node</em>'.
   * @generated
   */
  OtherTreeNode createOtherTreeNode();

  /**
   * Returns a new object of class '<em>Child List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Child List</em>'.
   * @generated
   */
  ChildList createChildList();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  IndentationAwareUiTestLanguagePackage getIndentationAwareUiTestLanguagePackage();

} //IndentationAwareUiTestLanguageFactory
