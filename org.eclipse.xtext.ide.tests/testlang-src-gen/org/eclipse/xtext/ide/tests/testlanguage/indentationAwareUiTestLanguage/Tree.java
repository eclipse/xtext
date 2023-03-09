/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.Tree#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.Tree#getMoreNodes <em>More Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.IndentationAwareUiTestLanguagePackage#getTree()
 * @model
 * @generated
 */
public interface Tree extends EObject
{
  /**
   * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.TreeNode}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodes</em>' containment reference list.
   * @see org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.IndentationAwareUiTestLanguagePackage#getTree_Nodes()
   * @model containment="true"
   * @generated
   */
  EList<TreeNode> getNodes();

  /**
   * Returns the value of the '<em><b>More Nodes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.OtherTreeNode}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>More Nodes</em>' containment reference list.
   * @see org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.IndentationAwareUiTestLanguagePackage#getTree_MoreNodes()
   * @model containment="true"
   * @generated
   */
  EList<OtherTreeNode> getMoreNodes();

} // Tree
