/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tricky G</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG#getTree <em>Tree</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyG()
 * @model
 * @generated
 */
public interface TrickyG extends Root
{
  /**
   * Returns the value of the '<em><b>Tree</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tree</em>' containment reference.
   * @see #setTree(TrickyG1)
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyG_Tree()
   * @model containment="true"
   * @generated
   */
  TrickyG1 getTree();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG#getTree <em>Tree</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tree</em>' containment reference.
   * @see #getTree()
   * @generated
   */
  void setTree(TrickyG1 value);

} // TrickyG
